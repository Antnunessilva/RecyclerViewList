package com.example.antonio.derplist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antonio.derplist.R;
import com.example.antonio.derplist.model.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonio on 08-10-2016.
 */

public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.derpHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    //interface vai nos deixar comunicar com a atividade - canal de comunicação

    private itemClickCallback itemClickCallback;

    public interface itemClickCallback {
        void onItemClick(int p);

        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final itemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public DerpAdapter(List<ListItem> ListData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = ListData; //this = listdata da classe
    }

    @Override
    public derpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new derpHolder(view);
    }

    @Override
    public void onBindViewHolder(derpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubtitle());
        if (item.isFavorite()) {
            holder.secondIcon.setImageResource(R.drawable.ic_sentiment_satisfied_black_36dp);
        } else {
            holder.secondIcon.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
    }

    public void setListData(ArrayList<ListItem> exerciseList){
      this.listData.clear();
        this.listData.addAll(exerciseList);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    //adapter precisa de um viewholder

    class derpHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView subTitle;
        private ImageView thumbnail;
        private ImageView secondIcon;
        private View container;


        public derpHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.lbl_item_text);
            subTitle = (TextView) itemView.findViewById(R.id.lbl_item_sub_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.im_item_icon);
            secondIcon = (ImageView) itemView.findViewById(R.id.im_item_icon_secondary);
            secondIcon.setOnClickListener(this);
            container = itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.cont_item_root) {
                itemClickCallback.onItemClick(getAdapterPosition());
            } else {
            itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }
        }
    }
}
