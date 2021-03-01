package com.app.bharatcart.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bharatcart.R;
import com.app.bharatcart.pojo.Result;
import com.bumptech.glide.Glide;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>{

    Result result;
    Context context;
    count_update_listener listener;
    int count = 0;

    public SearchResultAdapter(Result result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_design,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.appTitle.setText(result.getResult().get(position).getTitle());
        holder.appCompany.setText(result.getResult().get(position).getDeveloper());
        holder.rating.setText(result.getResult().get(position).getScoreText()+" ★");
        holder.appdownloads.setText(result.getResult().get(position).getInstalls()+"");
       if(result.getResult().get(position).getFree())
       {
           holder.appPrice.setText("Free");
       }
       else{
           holder.appPrice.setText(result.getResult().get(position).getPriceText());
       }
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=+1;
                listener.getCountValue(count);
                Intent browserIntent = new Intent("android.intent.action.VIEW");
                Log.e("Adapter", "onClick: "+result.getResult().get(position).getUrl());
                browserIntent.setData( Uri.parse(result.getResult().get(position).getUrl()));
                browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                browserIntent.setPackage("com.android.vending");
                context.startActivity(browserIntent);
            }
        });
        Glide.with(context).load(result.getResult().get(position).getIcon()).into(holder.appIcon);


    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        listener = (count_update_listener) context;
        super.onAttachedToRecyclerView(recyclerView);

    }

    public interface count_update_listener{
        void getCountValue(int count);
    }

    @Override
    public int getItemCount() {
        return result.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView appTitle,appCompany,rating,appdownloads,appPrice;
        ImageView appIcon;
        LinearLayout link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appTitle=itemView.findViewById(R.id.appTitle);

            appCompany=itemView.findViewById(R.id.appCompany);
            rating=itemView.findViewById(R.id.appRating);
            appIcon=itemView.findViewById(R.id.appIcon);
            link = itemView.findViewById(R.id.link);
            appdownloads=itemView.findViewById(R.id.appdownloads);
            appPrice=itemView.findViewById(R.id.appPrice);
        }

    }






}
