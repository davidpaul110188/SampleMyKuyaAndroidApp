package com.dearwolves.mykuya.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dearwolves.mykuya.R;
import com.dearwolves.mykuya.model.WhatsNew;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder>  {

    private List<WhatsNew> items;
    private Context context;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public NewAdapter(Context context, List<WhatsNew> items) {
        this.mInflater = LayoutInflater.from(context);
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public NewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_new, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.ViewHolder holder, int position) {
        ImageView thumbnail = holder.thumbnail;
        TextView title = holder.title;
        TextView description = holder.description;

        thumbnail.setImageResource(items.get(position).getImage());
        title.setText(items.get(position).getTitle());
        description.setText(items.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView thumbnail;
        TextView title;
        TextView description;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
