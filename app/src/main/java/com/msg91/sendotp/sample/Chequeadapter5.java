package com.msg91.sendotp.sample;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Chequeadapter5 extends RecyclerView.Adapter<Chequeadapter5.ProductViewHolder> {
    Intent i;


    private Context mCtx;
    private List<Cheque5> productList;

    public Chequeadapter5(Context mCtx, List<Cheque5> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c5, null);
        return new ProductViewHolder(view);








    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final   Cheque5 cheque;   cheque = productList.get(position);

        holder.addresss.setText(cheque.getImage());
        holder.time.setText(cheque.getPrize6());
//        holder.ee.setText(cheque.getPrize5());
//        holder.rr.setText(cheque.getPrize7());
        sh= mCtx.getSharedPreferences("data",MODE_PRIVATE);

    }




    @Override
    public int getItemCount() {
        return productList.size();
    }
    SharedPreferences sh;
    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView addresss,time;



        public ProductViewHolder(View itemView) {
            super(itemView);

          addresss = itemView.findViewById(R.id.loaddress);
           time= itemView.findViewById(R.id.lotime);
            // itemView.findViewById(R.id.r);

        }


    }

}