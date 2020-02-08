package co.codigo.codetest.presentation.features.wonderlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.codigo.codetest.R
import co.codigo.codetest.presentation.internal.extensions.load
import co.codigo.codetest.presentation.model.WonderUiModel

/**
 * Created by Chan Myae Aung on 2/8/20.
 */
class WondersAdapter(private val itemClickListener: WonderItemClickListener) :
    ListAdapter<WonderUiModel, WonderViewHolder>(
        object : DiffUtil.ItemCallback<WonderUiModel>() {
            override fun areItemsTheSame(oldItem: WonderUiModel, newItem: WonderUiModel): Boolean {
                return oldItem.location == newItem.location
            }

            override fun areContentsTheSame(
                oldItem: WonderUiModel,
                newItem: WonderUiModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WonderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wonder, parent, false)
        return WonderViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: WonderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface WonderItemClickListener {
        fun onWonderItemClick(model: WonderUiModel)
    }
}

class WonderViewHolder(val view: View, val listener: WondersAdapter.WonderItemClickListener) :
    RecyclerView.ViewHolder(view) {

    private val ivPlace: ImageView = view.findViewById(R.id.ivPlace)
    private val tvDesc: TextView = view.findViewById(R.id.tvDescription)

    fun bind(model: WonderUiModel) {
        ivPlace.load(model.imageUrl)
        tvDesc.text = model.description

        view.setOnClickListener { listener.onWonderItemClick(model) }
    }
}