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

    private List<String> headerList = new ArrayList<>();

    private List<String> infoList = new ArrayList<>();

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView headerTextView;

        private TextView infoTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.headerTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
        }

        public void bind(String header, String info) {
            headerTextView.setText(header);
            infoTextView.setText(info);
        }
    }

    @Override
    public HeaderViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_info_item, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder (HeaderViewHolder holder, int position) {
        holder.bind(headerList.get(position), infoList.get(position));
    }

    @Override
    public int getItemCount() {
        return headerList.size();
    }

    public void setItems(Collection<String> holders, Collection<String> info) {
        headerList.addAll(holders);
        infoList.addAll(info);
        notifyDataSetChanged();
    }

    public void clearItems() {
        headerList.clear();
        infoList.clear();
        notifyDataSetChanged();
    }
}
