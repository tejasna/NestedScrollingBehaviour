package com.example.test.nestedscrollingviewbehaviour;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private static final int ITEM = 0;
  private ArrayList<Integer> data = new ArrayList<>();

  Adapter(ArrayList<Integer> data) {
    this.data = data;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    if (viewType == ITEM) {
      LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
      View view = layoutInflater.inflate(R.layout.item, parent, false);
      return new Holder(view);
    }
    throw new RuntimeException("view type not found");
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder.getItemViewType() == ITEM) {
      Holder dataHolder = (Holder) holder;
      dataHolder.data.setText(String.valueOf(position));
    }
  }

  @Override public int getItemCount() {
    return data.size();
  }

  @Override public int getItemViewType(int position) {
    return ITEM;
  }

  private class Holder extends RecyclerView.ViewHolder {
    private TextView data;

    Holder(View itemView) {
      super(itemView);
      this.data = (TextView) itemView.findViewById(R.id.data);
    }
  }
}
