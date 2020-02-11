package com.msg91.sendotp.sample;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.content.Context.MODE_PRIVATE;

public class Chequeadapter4 extends RecyclerView.Adapter<Chequeadapter4.ProductViewHolder> {
    Intent i;
SharedPreferences sh;

    private Context mCtx;
    private List<Cheque4> productList2;

    public Chequeadapter4(Context mCtx, List<Cheque4> productList) {
        sh = Objects.requireNonNull(mCtx).getSharedPreferences("data", MODE_PRIVATE);
        this.mCtx = mCtx;
        this.productList2 = productList;
       // sh=mCtx.getSharedPreferences("Official1",MODE_PRIVATE);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c4, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Cheque4 cheque = productList2.get(position);


        holder.date.setText(cheque.getImage());
        Picasso.get().load(cheque.getStatus()).into(holder.imagee);
        holder.details.setText(cheque.getUser1());


        sh = Objects.requireNonNull(mCtx).getSharedPreferences("data", MODE_PRIVATE);




    }


    @Override
    public int getItemCount() {
        return productList2.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder {

TextView date,details;
ImageView imagee;


        public ProductViewHolder(View itemView) {
            super(itemView);

          date= itemView.findViewById(R.id.achdate);
        details= itemView.findViewById(R.id.achdetails);
           imagee= itemView.findViewById(R.id.achimage);



        }


    }


}
