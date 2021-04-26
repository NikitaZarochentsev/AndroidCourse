package com.example.lesson_4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DetailViewAdapter extends RecyclerView.Adapter<DetailViewAdapter.ViewHolder> {

    private final List<BaseInfoItem> cardsList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView headerTextView;

        private final ImageView imageView;

        private final TextView infoTextView;

        public ViewHolder(View itemView, int itemViewType) {
            super(itemView);

            if (itemViewType == 0) {
                headerTextView = itemView.findViewById(R.id.headerTextViewDetail);
                imageView = itemView.findViewById(R.id.imageDetail);
                infoTextView = itemView.findViewById(R.id.infoTextViewDetail);
            } else {
                headerTextView = itemView.findViewById(R.id.headerTextViewBase);
                imageView = itemView.findViewById(R.id.imageBase);
                infoTextView = itemView.findViewById(R.id.infoTextViewBase);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_info_item, parent, false);
        }

        ViewHolder holder = new ViewHolder(view, viewType);

        holder.itemView.setOnClickListener(view1 -> Snackbar.make(view1, holder.headerTextView.getText(), Snackbar.LENGTH_SHORT).show());

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaseInfoItem baseInfoItem = cardsList.get(position);

        holder.headerTextView.setText(baseInfoItem.header);
        holder.imageView.setImageResource(baseInfoItem.idImage);

        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            // нужно добавить информацию в поле info и при необходимости откорректировать его
            DetailInfoItem detailInfoItem = (DetailInfoItem) baseInfoItem;
            holder.infoTextView.setText(detailInfoItem.info);
            if (detailInfoItem.attention) {
                holder.infoTextView.setTextColor(Color.rgb(255, 0, 0));
            }
        } else {
            if (baseInfoItem instanceof DetailInfoItem) {
                DetailInfoItem detailInfoItem = (DetailInfoItem) baseInfoItem;
                holder.infoTextView.setText(detailInfoItem.info);
                if (detailInfoItem.attention) {
                    holder.infoTextView.setTextColor(Color.rgb(255, 0, 0));
                }
            } else {
                // значит нужна корректировка view (сокрытие поля infoTextView и выравнивание поля headerTextView)
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
                holder.infoTextView.setLayoutParams(params);
            }
        }
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        BaseInfoItem card = cardsList.get(position);

        // если объект без информации, то это view типа 1
        if (!(card instanceof DetailInfoItem)) {
            return 1;
        }

        // если объект с информации и чётным номером, то это view типа 0
        if ((position + 1) % 2 == 0) {
            return 0;
        } else {
            // если номер объекта нечетный и он последний, то это view типа 1
            if ((position - 1) == cardsList.size()) {
                return 1;
            }

            // иначе если у него есть пара, то это так же view типа 0
            if (cardsList.get(position + 1) instanceof DetailInfoItem) {
                return 0;
            } else {
                // иначе - view типа 1
                return 1;
            }
        }
    }

    public void setItems(Collection<BaseInfoItem> cards) {
        cardsList.addAll(cards);
        notifyDataSetChanged();
    }
}
