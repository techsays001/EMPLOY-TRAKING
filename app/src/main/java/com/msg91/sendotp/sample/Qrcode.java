package com.msg91.sendotp.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class Qrcode extends AppCompatActivity {
    Button btn,up,out;
    TextView txt1;
    IntentIntegrator qrscan;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        btn = findViewById(R.id.button);
        up = findViewById(R.id.update55);
     out = findViewById(R.id.checkout);
        txt1 = findViewById(R.id.textView);
        sh=getSharedPreferences("data11",MODE_PRIVATE);
        qrscan = new IntentIntegrator(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrscan.initiateScan();


            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(txt1.getText().toString().isEmpty())
                {
                    Toast.makeText(Qrcode.this,"Scan OR code",Toast.LENGTH_LONG).show();
                   // txt1.setError("scan ");

                }
                else if(!(txt1.getText().toString().equals("techsays"))){

                    Toast.makeText(Qrcode.this,"Scan a Valid OR code",Toast.LENGTH_LONG).show();
                }

                else {





                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/chech_in.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                  //  Toast.makeText(Qrcode.this,response,Toast.LENGTH_LONG).show();

                                    if(response.contains("ok"))
                                    {

                                        new SweetAlertDialog(Qrcode.this, SweetAlertDialog.WARNING_TYPE)
                                                .setTitleText("Check in Success")
                                                .setContentText("Back to Home!")
                                                .setConfirmText("Yes,Login")
                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                    @Override
                                                    public void onClick(SweetAlertDialog sDialog) {
                                                        sDialog
                                                                .setTitleText("Logining...!")

                                                                .setConfirmText("OK")

                                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                                    @Override
                                                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                    Intent in=new Intent(Qrcode.this,MainActivity2.class);
                                                                    startActivity(in);
                                                                    }
                                                                })
                                                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                                    }
                                                })
                                                .show();




//
                                    }


                                    else{



                                        new SweetAlertDialog(Qrcode.this, SweetAlertDialog.WARNING_TYPE)
                                                .setTitleText(" Already Checkin")
                                                .setContentText("Back to Home!")
                                                .setConfirmText("Yes,Login")
                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                    @Override
                                                    public void onClick(SweetAlertDialog sDialog) {
                                                        sDialog
                                                                .setTitleText("Logining...!")

                                                                .setConfirmText("OK")

                                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                                    @Override
                                                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        Intent in=new Intent(Qrcode.this,MainActivity2.class);
                                                                        startActivity(in);
                                                                    }
                                                                })
                                                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                                    }
                                                })
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

                            params.put("name",sh.getString("name",null));
                            params.put("ph",sh.getString("phone",null));
                            params.put("id",sh.getString("empid",null));
                         //   params.put("dep",sh.getString("department",null));
                            params.put("txt", txt1.getText().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(Qrcode.this);
                    requestQueue.add(stringRequest);








                }


            }
        });


        out.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(txt1.getText().toString().isEmpty())
                {
                    Toast.makeText(Qrcode.this,"Scan OR code",Toast.LENGTH_LONG).show();
                    // txt1.setError("scan ");

                }
else if(!(txt1.getText().toString().equals("techsays"))){

                    Toast.makeText(Qrcode.this,"Scan a Valid OR code",Toast.LENGTH_LONG).show();
                }

                else {





                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/check_out.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    //  Toast.makeText(Qrcode.this,response,Toast.LENGTH_LONG).show();

                                    if(response.contains("ok"))
                                    {

                                        new SweetAlertDialog(Qrcode.this, SweetAlertDialog.WARNING_TYPE)
                                                .setTitleText("Check Out Success")
                                                .setContentText("Back to Home!")
                                                .setConfirmText("Yes,Login")
                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                    @Override
                                                    public void onClick(SweetAlertDialog sDialog) {
                                                        sDialog
                                                                .setTitleText("Logining...!")

                                                                .setConfirmText("OK")

                                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                                    @Override
                                                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        Intent in=new Intent(Qrcode.this,MainActivity2.class);
                                                                        startActivity(in);
                                                                    }
                                                                })
                                                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                                    }
                                                })
                                                .show();




//
                                    }


                                    else{



                                        new SweetAlertDialog(Qrcode.this, SweetAlertDialog.WARNING_TYPE)
                                                .setTitleText(" Already Checkout")
                                                .setContentText("Back to Home!")
                                                .setConfirmText("Yes,Login")
                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                    @Override
                                                    public void onClick(SweetAlertDialog sDialog) {
                                                        sDialog
                                                                .setTitleText("Logining...!")

                                                                .setConfirmText("OK")

                                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                                    @Override
                                                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        Intent in=new Intent(Qrcode.this,MainActivity2.class);
                                                                        startActivity(in);
                                                                    }
                                                                })
                                                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                                    }
                                                })
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

                            params.put("name",sh.getString("name",null));
                            params.put("ph",sh.getString("phone",null));
                            params.put("id",sh.getString("empid",null));
                            //   params.put("dep",sh.getString("department",null));
                            params.put("txt", txt1.getText().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(Qrcode.this);
                    requestQueue.add(stringRequest);








                }


            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                    txt1.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    }







