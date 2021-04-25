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

    private List<BaseInfoItem> cardsList = new ArrayList<>();

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView headerTextView;

        private ImageView imageView;

        private TextView infoTextView;

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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_info_item, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_info_item, parent, false);
                break;
        }

        ViewHolder holder = new ViewHolder(view, viewType);
        // возможно, если в BaseViewHolder присвоить DetailViewHolder, то метод всё равно вернёт BaseViewHolder
        // а давай-ка мы это ... проверим!

        // проблема в том, что разные holders должны правильно учитывать разные typeViews

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Snackbar.make(view, holder.headerTextView.getText(), Snackbar.LENGTH_SHORT).show();

            }
        });

        return holder;


// старая реализация (возможно, нерабочая)
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
//        switch (viewType) {
//            case 0:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
//                break;
//            case 1:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_info_item, parent, false);
//        }
//
//        View vieww = view;
//
//        DetailViewHolder holder = new DetailViewHolder(view);
//        holder.itemView.setOnClickListener(view1 -> {
//            Snackbar.make(vieww, holder.headerTextView.getText(), Snackbar.LENGTH_SHORT).show();
//        });
//        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaseInfoItem baseInfoItem = cardsList.get(position);

        holder.headerTextView.setText(baseInfoItem.header);
        holder.imageView.setImageResource(baseInfoItem.idImage);

        // нужно правильно связывать данные с отображением в зависимости от типов данных и ячеек
        // пока немного запутанно, нужно переделывать
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            // нужно добавить информацию в поле info и при необходимости откорректировать его
            DetailInfoItem detailInfoItem = (DetailInfoItem) baseInfoItem;
            holder.infoTextView.setText(detailInfoItem.info);
            if(detailInfoItem.attention) {
                holder.infoTextView.setTextColor(Color.rgb(255, 0, 0));
            }
        } else {
            if (baseInfoItem instanceof DetailInfoItem) {
                DetailInfoItem detailInfoItem = (DetailInfoItem) baseInfoItem;
                holder.infoTextView.setText(detailInfoItem.info);
                if(detailInfoItem.attention) {
                    holder.infoTextView.setTextColor(Color.rgb(255, 0, 0));
                }
            } else {
                // значит нужна корректировка view (сокрытие поля infoTextView и выравнивание поля headerTextView)
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
                holder.infoTextView.setLayoutParams(params);
            }
        }

        // реализация из метода bind(CardInfo) класса DetailViewHolder
//        switch (itemViewType) {
//            case 0:
//                if (cardsList.get(getAdapterPosition() + 1).info.equals("")) {
//                    if (getAdapterPosition() % 2 == 0) {
//                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                        params.addRule(RelativeLayout.RIGHT_OF, R.id.imageDetail);
//                        params.setMarginStart(16);
//                        headerTextView.setGravity(Gravity.CENTER_VERTICAL);
//                        infoTextView.setGravity(Gravity.CENTER_VERTICAL);
//                        headerTextView.setLayoutParams(params);
//                    }
//                }
//
//                if (cardInfo.attention) {
//                    infoTextView.setTextColor(Color.rgb(255, 0, 0));
//                }
//
//                infoTextView.setText(cardInfo.info);
//                break;
//        }

        // без деления на разные view
//            if (cardInfo.info.equals("")) {
//                infoTextView.setVisibility(View.INVISIBLE);
//                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                params.addRule(RelativeLayout.CENTER_VERTICAL);
//                params.addRule(RelativeLayout.RIGHT_OF, R.id.imageDetail);
//                params.setMarginStart(16);
//                headerTextView.setLayoutParams(params);
//            } else {
//                if (cardsList.get(getAdapterPosition() + 1).info.equals("")) {
//                    if (getAdapterPosition() % 2 == 0) {
//                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                        params.addRule(RelativeLayout.RIGHT_OF, R.id.imageDetail);
//                        params.setMarginStart(16);
//                        headerTextView.setGravity(Gravity.CENTER_VERTICAL);
//                        infoTextView.setGravity(Gravity.CENTER_VERTICAL);
//                        headerTextView.setLayoutParams(params);
//                    }
//                }
//
//                if (cardInfo.attention) {
//                    infoTextView.setTextColor(Color.rgb(255, 0, 0));
//                }
//
//                infoTextView.setText(cardInfo.info);
//            }
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

    public void clearItems() {
        cardsList.clear();
        notifyDataSetChanged();
    }
}
