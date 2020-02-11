package com.msg91.sendotp.sample;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.content.Context.MODE_PRIVATE;


public class CallFragment1 extends Fragment implements
        AdapterView.OnItemSelectedListener {
    private ArrayList<Doctor> goodModelArrayList;
    TextView dname,dphno,dw;
   private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private DatePicker datePicker;
    ProgressDialog loading;
    private TextView dateView;
    DatePickerDialog datePickerDialog;
Spinner empid;
TextView empname,refresh;
    EditText empdate,emptime,emptask;
Button update;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    Intent intent ;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String ab;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_call1, container, false);

      empname= root.findViewById(R.id.empname);
      empid= root.findViewById(R.id.empidd);
     //   empdate= root.findViewById(R.id.empdate);
   //emptime= root.findViewById(R.id.emptime);
        emptask= root.findViewById(R.id.emptask);
       update= root.findViewById(R.id.taskupdate);

      refresh= root.findViewById(R.id.refresh);
        //Creating the ArrayAdapter instance having the country list
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/task_spiner.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server
//                        Toast.makeText(Therapy.this, response, Toast.LENGTH_LONG).show();

                            goodModelArrayList = new ArrayList<>();


                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");

                                    Doctor doctor = new Doctor();
                                    // doctor.setName(json_obj.getString("name"));
                                    doctor.setType(json_obj.getString("type"));
                                    goodModelArrayList.add(doctor);
                                }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            for (int i = 0; i < goodModelArrayList.size(); i++) {
                                //  names.add(goodModelArrayList.get(i).getName().toString());
                                name.add(goodModelArrayList.get(i).getType());
                            }

                            ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, name);
                            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                            empid.setAdapter(spinnerArrayAdapter);
                            //ArrayAdapter spinnerArrayAdapte = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, name);
//                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//                    empid.setAdapter(spinnerArrayAdapte);
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


// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                    return params;
                }

            };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


            //Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(stringRequest);

        }


//        empdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                datePickerDialog = new DatePickerDialog(getActivity(),
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                               empdate.setText(day + "/" + (month + 1) + "/" + year);
//                            }
//                        }, year, month, dayOfMonth);
//                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
//                datePickerDialog.show();
//            }
//        });


//
//      emptime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final Calendar c = Calendar.getInstance();
//                mHour = c.get(Calendar.HOUR_OF_DAY);
//                mMinute = c.get(Calendar.MINUTE);
//
//                // Launch Time Picker Dialog
//                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
//                        new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                  int minute) {
//
//                              emptime.setText(hourOfDay + ":" + minute);
//                            }
//                        }, mHour, mMinute, false);
//                timePickerDialog.show();
//
//
//            }
//        });


refresh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {



        {     //

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/task_spiner_emp_name.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server


                            //     Toast.makeText(Addrequset.this,abc.getStringExtra("ph")+response,Toast.LENGTH_LONG).show();
                            if (!response.equals("ok")) {

                                empname.setText("No Data Found");


                            }
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
                                    ab = json_obj.getString("name");




                                    empname.setText(ab);

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

                    params.put("aa",empid.getSelectedItem().toString());

                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(stringRequest);

        }

    }
});


update.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


       if (emptask.getText().toString().isEmpty()){

            emptask.setError("Empty Field");
        }

        {





            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Employ_Tracking_office/Task_add.php",


                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {


                        Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();
                        if(response.equals("ok"))
                        {

                            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Task Added")
                                    .setContentText("Succefull!")
                                    .setConfirmText("ok")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            sDialog
                                                    .setTitleText("Logining...!")

                                                    .setConfirmText("OK")

                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                                                            Intent in=new Intent(regtwonurse.this,Signinnurse.class);
////
                                                       //  empdate.getText().clear();
                                                       //   emptime.getText().clear();
                                                          emptask.getText().clear();
                                                        }
                                                    })
                                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                        }
                                    })
                                    .show();




//
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                    }


                })
            {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();



                params.put("id",empid.getSelectedItem().toString());
                params.put("name",empname.getText().toString());
              //  params.put("date",empdate.getText().toString());
              //  params.put("time",emptime.getText().toString());
                params.put("task",emptask.getText().toString());

                return params;

            }

        };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }}
});
 return root;
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}

