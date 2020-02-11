package com.msg91.sendotp.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Addrequset extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener {
    String[] danc = {"completed","Partially complete","Note completed"};
    EditText report;
    Spinner spiner;
    Button upload;
Intent abc;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrequset);
    report=findViewById(R.id.reportdetails);
      spiner=findViewById(R.id.reportspiner);
       upload=findViewById(R.id.reportupload);
      sh=getSharedPreferences("data11",MODE_PRIVATE);
        ArrayAdapter aas = new ArrayAdapter(this,android.R.layout.simple_spinner_item,danc);
        aas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
     spiner.setAdapter(aas);
abc=getIntent();
upload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
if(report.getText().toString().isEmpty()){


    report.setError("empty");
    Toast.makeText(Addrequset.this, "Enter details", Toast.LENGTH_LONG).show();

}
else{

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/report.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server
                       // Toast.makeText(Addrequset.this, response, Toast.LENGTH_LONG).show();
                        if(response.equals("ok"))
                        {
                            new SweetAlertDialog(Addrequset.this, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText(" Success")
                                    .setContentText("Back To Home!")
                                    .setConfirmText("Yes")

                                    .show();
          report.getText().clear();



                        }
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");


                            }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
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

                params.put("st",spiner.getSelectedItem().toString());
                params.put("r",report.getText().toString());
                params.put("id",sh.getString("empid",null));
                params.put("name",sh.getString("name",null));
                params.put("date",abc.getStringExtra("time"));
                params.put("t",abc.getStringExtra("task"));
                return params;
            }

        };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(Addrequset.this);
        requestQueue.add(stringRequest);
    }}
});


    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
