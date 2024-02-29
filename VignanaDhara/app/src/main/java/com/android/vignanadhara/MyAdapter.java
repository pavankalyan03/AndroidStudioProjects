package com.android.vignanadhara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public MyAdapter(Context context, List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recycle, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.recImage.setImageResource(dataList.get(position).getDataimg());
        holder.recTitle.setText(dataList.get(position).getDatatitle());
        holder.recDesc.setText(dataList.get(position).getDatadesc());
        holder.recLang.setText(dataList.get(position).getDesig());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detailed_View.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataimg());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDatatitle());
                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDatadesc());
                intent.putExtra("desig",dataList.get(holder.getAdapterPosition()).getDesig());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.studentimg);
        recTitle = itemView.findViewById(R.id.studentname);
        recDesc = itemView.findViewById(R.id.Desc);
        recLang = itemView.findViewById(R.id.desig);
        recCard = itemView.findViewById(R.id.studentcard);
    }
}