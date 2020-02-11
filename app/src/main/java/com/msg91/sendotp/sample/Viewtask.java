package com.msg91.sendotp.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Viewtask extends AppCompatActivity {
    TextView report,name,date;
    Intent abcd;
    String a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtask);

       report=findViewById(R.id.homeaddress1);
      name=findViewById(R.id.name12301);
        date=findViewById(R.id.ph12301);
        abcd=getIntent();
       // Toast.makeText(Viewtask.this,abcd.getStringExtra("id")+abcd.getStringExtra("time"),Toast.LENGTH_LONG).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/report_admin_view.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server
                           //  Toast.makeText(Viewtask.this,response,Toast.LENGTH_LONG).show();
                        if(response.equals("enter valid data")){

                            new SweetAlertDialog(Viewtask.this, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("No Data Found")
                                    .setContentText("Back To Home!")
                                    .setConfirmText("Yes")
                                    .show();






                        }
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
                                a=json_obj.getString("name");
                                b=json_obj.getString("date");
                                c=json_obj.getString("report");


                             name.setText(a);
                                date.setText(b);
                               report.setText(c);

                            }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //   Toast.makeText(Signin.this, "success", Toast.LENGTH_LONG).show();

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

                params.put("id",abcd.getStringExtra("id"));
                params.put("date",abcd.getStringExtra("time"));
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(Viewtask.this);
        requestQueue.add(stringRequest);



    }
}
