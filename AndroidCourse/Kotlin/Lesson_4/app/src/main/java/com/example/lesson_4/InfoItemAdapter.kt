package com.example.lesson_4

import android.graphics.Color
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lesson_4.databinding.ActivityMainBinding
import com.example.lesson_4.databinding.BaseInfoItemBinding
import com.example.lesson_4.databinding.DetailInfoItemBinding
import org.w3c.dom.Text
import java.lang.IllegalArgumentException

class InfoItemAdapter(private val cardsList: List<BaseInfoItem>) :
    RecyclerView.Adapter<InfoItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ViewBinding = when(viewType) {
            R.layout.base_info_item -> BaseInfoItemBinding.inflate(inflater)
            R.layout.detail_info_item -> DetailInfoItemBinding.inflate(inflater)
            else -> throw IllegalArgumentException("Wrong type of view")
        }

        return ViewHolder(binding, viewType)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var baseInfoItem = cardsList[position]

        holder.bind(baseInfoItem)
    }

    class ViewHolder(val binding: ViewBinding, itemViewType: Int) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BaseInfoItem) {
            when (itemViewType) {
                R.layout.base_info_item -> {
                    val bindingBase = (binding as BaseInfoItemBinding)

                    bindingBase.headerTextViewBase.text = item.header
                    bindingBase.imageBase.setImageResource(item.idImage)

                    if (item is DetailInfoItem) {
                        val itemDetail = (item as DetailInfoItem)
                        bindingBase.infoTextViewBase.text = itemDetail.info
                        if (itemDetail.attention) {
                            bindingBase.infoTextViewBase.setTextColor(Color.rgb(255, 0, 0))
                        }
                    } else {
                        bindingBase.infoTextViewBase.width = 0
                        bindingBase.infoTextViewBase.height = 0
                    }
                }
                R.layout.detail_info_item -> {
                    val bindingDetail = (binding as DetailInfoItemBinding)
                    val itemDetail = (item as DetailInfoItem)

                    bindingDetail.headerTextViewDetail.text = itemDetail.header
                    bindingDetail.imageDetail.setImageResource(itemDetail.idImage)
                    bindingDetail.infoTextViewDetail.text = itemDetail.info
                    if (itemDetail.attention) {
                        bindingDetail.infoTextViewDetail.setTextColor(Color.rgb(255, 0, 0))
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val card = cardsList[position]

        // если объект без информации, то это base
        if (!(card is DetailInfoItem)) {
            return R.layout.base_info_item
        }

        // если объект с информацией и чётным номером, то это detail
        if ((position + 1) % 2 == 0) {
            return R.layout.detail_info_item
        } else {
            // если номер объекта нечетный и он последний, то это base
            if ((position - 1) == cardsList.size) {
                return R.layout.base_info_item
            }

            // иначе если у него есть пара, то это так же detail
            if (cardsList[position + 1] is DetailInfoItem) {
                return R.layout.detail_info_item
            } else {
                // иначе - это base
                return R.layout.base_info_item
            }
        }
    }
}
