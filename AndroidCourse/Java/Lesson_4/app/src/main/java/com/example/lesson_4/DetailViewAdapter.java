package com.example.lesson_4;

import android.app.Application;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DetailViewAdapter extends RecyclerView.Adapter<DetailViewAdapter.DetailViewHolder> {

    private List<CardInfo> cardsList = new ArrayList<>();

    class DetailViewHolder extends RecyclerView.ViewHolder {

        private TextView headerTextView;

        private TextView infoTextView;

        private ImageView imageView;

        public DetailViewHolder(View itemView, int itemViewType) {
            super(itemView);

            switch (itemViewType){
                case 0:
                    headerTextView = itemView.findViewById(R.id.headerTextViewDetail);
                    infoTextView = itemView.findViewById(R.id.infoTextViewDetail);
                    imageView = itemView.findViewById(R.id.imageDetail);
                    break;
                case 1:
                    headerTextView = itemView.findViewById(R.id.headerTextViewSimple);
                    infoTextView = itemView.findViewById(R.id.infoTextViewSimple);
                    imageView = itemView.findViewById(R.id.imageSimple);
                    break;
            }


        }
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_info_item, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_info_item, parent, false);
                break;
        }

        DetailViewHolder holder = new DetailViewHolder(view, viewType);
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
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        CardInfo cardInfo = cardsList.get(position);

        holder.headerTextView.setText(cardInfo.header);
        holder.infoTextView.setText(cardInfo.info);
        holder.imageView.setImageResource(cardInfo.idImage);

        int itemViewType = getItemViewType(position);

        if (itemViewType == 1 && cardInfo.info.equals("")) {
            // значит нужна корректировка view (сокрытие поля infoTextView и выравнивание поля headerTextView)
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
            holder.infoTextView.setLayoutParams(params);
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
        CardInfo card = cardsList.get(position);

        // если объект без информации, то это view типа 1
        if (card.info.equals("")) {
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
            if (!cardsList.get(position + 1).info.equals("")) {
                return 0;
            } else {
                // иначе - view типа 1
                return 1;
            }
        }
    }

    public void setItems(Collection<CardInfo> cards) {
        cardsList.addAll(cards);
        notifyDataSetChanged();
    }

    public void clearItems() {
        cardsList.clear();
        notifyDataSetChanged();
    }
}
