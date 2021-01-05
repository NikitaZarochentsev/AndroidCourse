package com.example.lesson_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.HeaderViewHolder> {

    private List<String> holderList = new ArrayList<>();

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView holderTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            holderTextView = itemView.findViewById(R.id.headerTextView);
        }

        public void bind(String header) {
            holderTextView.setText(header);
        }
    }

    @Override
    public HeaderViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder (HeaderViewHolder holder, int position) {
        holder.bind(holderList.get(position));
    }

    @Override
    public int getItemCount() {
        return holderList.size();
    }

    public void setItems(Collection<String> holders) {
        holderList.addAll(holders);
        notifyDataSetChanged();
    }

    public void clearItems() {
        holderList.clear();
        notifyDataSetChanged();
    }
}
