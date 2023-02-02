package com.fongmi.android.tv.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fongmi.android.tv.bean.Filter;
import com.fongmi.android.tv.databinding.AdapterValueBinding;

import java.util.List;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ViewHolder> {

    private final OnClickListener mListener;
    private final List<Filter.Value> mItems;
    private final String mKey;

    public ValueAdapter(OnClickListener listener, Filter filter) {
        this.mListener = listener;
        this.mItems = filter.getValue();
        this.mKey = filter.getKey();
    }

    public interface OnClickListener {
        void onItemClick(String key, Filter.Value item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final AdapterValueBinding binding;

        ViewHolder(@NonNull AdapterValueBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(AdapterValueBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filter.Value item = mItems.get(position);
        holder.binding.text.setText(item.getN());
        holder.binding.text.setActivated(item.isActivated());
        holder.binding.getRoot().setOnClickListener(v -> mListener.onItemClick(mKey, item));
    }
}