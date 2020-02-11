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

public class Chequeadapter3 extends RecyclerView.Adapter<Chequeadapter3.ProductViewHolder> {
    Intent i;
SharedPreferences sh;

    private Context mCtx;
    private List<Cheque3> productList;

    public Chequeadapter3(Context mCtx, List<Cheque3> productList) {
        sh = Objects.requireNonNull(mCtx).getSharedPreferences("data", MODE_PRIVATE);
        this.mCtx = mCtx;
        this.productList = productList;
       // sh=mCtx.getSharedPreferences("Official1",MODE_PRIVATE);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c3, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Cheque3 cheque = productList.get(position);


      //  holder.date.setText(cheque.getImage());
        holder.time.setText(cheque.getStatus());
        holder.task.setText(cheque.getStatus1());
      //  Picasso.get().load(cheque.getStatus()).into(holder.image);
holder.report.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {




        Intent abc = new Intent(mCtx, Addrequset.class);

        abc.putExtra("time",cheque.getStatus());
        abc.putExtra("task",cheque.getStatus1());
        mCtx.startActivity(abc);




    }
});
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView date,time,task;
Button report;

        public ProductViewHolder(View itemView) {
            super(itemView);

    report= itemView.findViewById(R.id.report);
      time= itemView.findViewById(R.id.time17);
          task= itemView.findViewById(R.id.task17);
        }


    }


}
