package com.example.lesson_4;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

        public DetailViewHolder(View itemView) {
            super(itemView);

            headerTextView = itemView.findViewById(R.id.headerTextViewDetail);
            infoTextView = itemView.findViewById(R.id.infoTextViewDetail);
            imageView = itemView.findViewById(R.id.imageDetail);
        }

        public void bind(CardInfo cardInfo) {

            headerTextView.setText(cardInfo.header);

            imageView.setImageResource(cardInfo.idImage);

            if (cardInfo.info.equals("")) {
                infoTextView.setVisibility(View.INVISIBLE);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.CENTER_VERTICAL);
                params.addRule(RelativeLayout.RIGHT_OF, R.id.imageDetail);
                headerTextView.setLayoutParams(params);
            } else {
                if (cardsList.get(getAdapterPosition() + 1).info.equals("")) {
                    if (getAdapterPosition() % 2 == 0) {
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.RIGHT_OF, R.id.imageDetail);
                        headerTextView.setLayoutParams(params);
                    }
                }

                infoTextView.setText(cardInfo.info);
            }
        }
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
        DetailViewHolder holder = new DetailViewHolder(view);
        holder.itemView.setOnClickListener(view1 -> {
            Snackbar.make(view, holder.headerTextView.getText(), Snackbar.LENGTH_SHORT).show();
        });
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        holder.bind(cardsList.get(position));
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
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
