package com.msg91.sendotp.sample;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class Chequeadapter6 extends RecyclerView.Adapter<Chequeadapter6.ProductViewHolder> {
    Intent i;
SharedPreferences sh;

    private Context mCtx;
    private List<Cheque6> productList;

    public Chequeadapter6(Context mCtx, List<Cheque6> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
       // sh=mCtx.getSharedPreferences("Official1",MODE_PRIVATE);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_taskadminview, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Cheque6 cheque = productList.get(position);


       holder.name.setText(cheque.getImage());
        holder.time.setText(cheque.getStatus());
        holder.task.setText(cheque.getStatus1());
        holder.id.setText(cheque.getStatus2());
      //  Picasso.get().load(cheque.getStatus()).into(holder.image);
holder.report.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {




        Intent abcd = new Intent(mCtx, Viewtask.class);

        abcd.putExtra("id",cheque.getStatus());
        abcd.putExtra("time",cheque.getStatus1());
        mCtx.startActivity(abcd);




    }
});
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView name,time,task,id;
Button report;

        public ProductViewHolder(View itemView) {
            super(itemView);

    report= itemView.findViewById(R.id.report1);
      time= itemView.findViewById(R.id.time171);
          task= itemView.findViewById(R.id.task171);
           name= itemView.findViewById(R.id.name171);
           id= itemView.findViewById(R.id.empid171);
        }


    }


}
