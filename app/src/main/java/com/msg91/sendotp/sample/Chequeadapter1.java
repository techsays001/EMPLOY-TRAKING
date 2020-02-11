package com.msg91.sendotp.sample;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.content.Context.MODE_PRIVATE;

public class Chequeadapter1 extends RecyclerView.Adapter<Chequeadapter1.ProductViewHolder> {
    Intent abc;
    SharedPreferences sh;

    private Context mCtx;
    private List<Cheque1> productList1;

    public Chequeadapter1(Context mCtx, List<Cheque1> productList) {
        sh = Objects.requireNonNull(mCtx).getSharedPreferences("data", MODE_PRIVATE);
        this.mCtx = mCtx;
        this.productList1 = productList;
        // sh=mCtx.getSharedPreferences("Official1",MODE_PRIVATE);
        //Toast.makeText(mCtx,,Toast.LENGTH_LONG).show();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c1, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Cheque1 cheque = productList1.get(position);


        holder.name.setText(cheque.getImage());
        holder.detalis.setText(cheque.getStatus());
        Picasso.get().load(cheque.getUser1()).into(holder.image);
        holder.ph.setText(cheque.getUser2());
        holder.la.setText(cheque.getUser3());
        holder.lo.setText(cheque.getUser4());
        holder.emails.setText(cheque.getUser5());
        holder.empid.setText(cheque.getUser7());
        sh = Objects.requireNonNull(mCtx).getSharedPreferences("data", MODE_PRIVATE);
      //  Toast.makeText(mCtx,cheque.getStatus(),Toast.LENGTH_LONG).show();

        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abc = new Intent(mCtx, Eventok.class);

                abc.putExtra("id",cheque.getUser7());
                mCtx.startActivity(abc);





            }
        });

//        holder.share.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBody = cheque.getUser1()+"\t\t\t\t"+"phone number :"+"\t\t\t"+cheque.getStatus()+"\t\t\t\t"+"farm name :"+"\t\t\t"+cheque.getUser2()+"\t\t\t\t"+"oner name :"+"\t\t\t"+cheque.getImage();
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
//                mCtx.startActivity(sharingIntent);
//
//            }
//
//        });

holder.empmsg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {




        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/empid_sent.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server
                                   Toast.makeText(mCtx,response,Toast.LENGTH_LONG).show();


                        if(response.equals("Password sent to your registerd phonenumber"))
                        {
//
                            new SweetAlertDialog(mCtx, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Employ ID sent to  registerd phonenumber")
                                    .setContentText("Back To Home!")
                                    .show();

                        }
                               else{


                            new SweetAlertDialog(mCtx, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Employ ID  not sent to  registerd phonenumber")
                                    .setContentText("Back To Home!")
                                    .show();






                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
//Adding parameters to request
                params.put("phone",cheque.getStatus());

//returning parameter
                return params;
            }

        };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(mCtx);
        requestQueue.add(stringRequest);





    }
});
    }


    @Override
    public int getItemCount() {
        return productList1.size();
    }

    public void filterList1(ArrayList<Cheque1> filteredList1) {

        productList1 = filteredList1;
        notifyDataSetChanged();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView name, price, detalis, a, ph, app, call, msg, lo, la, map, share, emails, pass,empid;
        ImageView image;
        Button accept,empmsg;
        Button buy, del;


        public ProductViewHolder(View itemView) {
            super(itemView);

            sh = Objects.requireNonNull(mCtx).getSharedPreferences("data", MODE_PRIVATE);
            name = itemView.findViewById(R.id.t_discription16);
            ph = itemView.findViewById(R.id.pph26);
            detalis = itemView.findViewById(R.id.pph16);
            image = itemView.findViewById(R.id.t_name16);
         empmsg= itemView.findViewById(R.id.empidmsg);

            accept = itemView.findViewById(R.id.view5);
            lo = itemView.findViewById(R.id.lo6);
            la = itemView.findViewById(R.id.la6);
          empid = itemView.findViewById(R.id.id6);


            emails = itemView.findViewById(R.id.email123456);


//    @Override
//    public int getItemCount() {
//        return productList.size();
//    }
//
//    class ProductViewHolder extends RecyclerView.ViewHolder {
//
//

//        public ProductViewHolder(View itemView) {
//            super(itemView);
//
//

////            review=itemView.findViewById(R.id.re);
////            viewreview=itemView.findViewById(R.id.ve);
////          //  pid=itemView.findViewById(R.id.productidd);
//
//        }
//
//    }

        }



    }
}