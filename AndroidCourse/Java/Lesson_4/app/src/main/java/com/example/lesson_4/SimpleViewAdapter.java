package com.example.lesson_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimpleViewAdapter extends RecyclerView.Adapter<SimpleViewAdapter.SimpleViewHolder> {

    private List<CardInfo> cardsList = new ArrayList<>();

    class SimpleViewHolder extends RecyclerView.ViewHolder {

        private TextView headerTextView;

        private TextView infoTextView;

        private ImageView imageView;

        public SimpleViewHolder(View itemView) {
            super(itemView);

            headerTextView = itemView.findViewById(R.id.headerTextViewSimple);
            infoTextView = itemView.findViewById(R.id.infoTextViewSimple);
            imageView = itemView.findViewById(R.id.imageSimple);
        }

        public void bind(CardInfo cardInfo) {

            headerTextView.setText(cardInfo.header);

            imageView.setImageResource(cardInfo.idImage);



            if (!cardInfo.info.equals("")) {
                infoTextView.setText(cardInfo.info);
            } else {
                infoTextView.setVisibility(View.INVISIBLE);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.CENTER_VERTICAL);
                params.addRule(RelativeLayout.RIGHT_OF, R.id.imageSimple);
                headerTextView.setLayoutParams(params);
            }
        }
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_info_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
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
