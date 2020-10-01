package com.example.lessonfragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> items;
    Context context;
    IFragments iFragments;

    public Adapter(List items, Context context, IFragments i) {
        this.items = items;
        this.context = context;
        this.iFragments = i;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.ViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   iFragments.onOpenUrl(textView.getText().toString());
                }
            });
        }
    }
}
