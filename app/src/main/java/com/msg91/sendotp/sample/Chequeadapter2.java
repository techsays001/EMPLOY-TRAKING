package com.msg91.sendotp.sample;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class Chequeadapter2 extends RecyclerView.Adapter<Chequeadapter2.ProductViewHolder> {
    Intent i;


    private Context mCtx;
    private List<Cheque2> productList;

    public Chequeadapter2(Context mCtx, List<Cheque2> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c2, null);
        return new ProductViewHolder(view);








    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final   Cheque2 cheque;   cheque = productList.get(position);

        holder.qq.setText(cheque.getImage());
        holder.ww.setText(cheque.getPrize6());
        holder.ee.setText(cheque.getPrize5());
        holder.rr.setText(cheque.getPrize7());
        sh= mCtx.getSharedPreferences("data",MODE_PRIVATE);

    }




    @Override
    public int getItemCount() {
        return productList.size();
    }
    SharedPreferences sh;
    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView qq,ww,ee,rr;



        public ProductViewHolder(View itemView) {
            super(itemView);

           qq = itemView.findViewById(R.id.q);
            ww= itemView.findViewById(R.id.w);
            ee= itemView.findViewById(R.id.e);
            rr= itemView.findViewById(R.id.r);

        }


    }

}