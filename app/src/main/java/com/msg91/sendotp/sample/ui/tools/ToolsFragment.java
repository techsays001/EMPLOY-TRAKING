package com.msg91.sendotp.sample.ui.tools;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.msg91.sendotp.sample.Addrequset;
import com.msg91.sendotp.sample.Cheque;
import com.msg91.sendotp.sample.Cheque2;
import com.msg91.sendotp.sample.Chequeadapter;
import com.msg91.sendotp.sample.Chequeadapter1;
import com.msg91.sendotp.sample.Chequeadapter2;
import com.msg91.sendotp.sample.Eventok;
import com.msg91.sendotp.sample.R;
import com.msg91.sendotp.sample.Registration;
import com.msg91.sendotp.sample.Resetpass;
import com.msg91.sendotp.sample.Signin;
import com.msg91.sendotp.sample.ui.notifications.NotificationsViewModel;
import com.msg91.sendotp.sample.ui.share.ShareViewModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;





//public class ToolsFragment extends Fragment {
//ImageView image;
//TextView name,email;
//    SharedPreferences sh;
//    private NotificationsViewModel ToolsViewModel;
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        ToolsViewModel =
//                ViewModelProviders.of(this).get(NotificationsViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_tools, container, false);
//
//image=root.findViewById(R.id.proimage);
//
//       name=root.findViewById(R.id.proname);
//        email=root.findViewById(R.id.proemail);
//
//
//        sh= Objects.requireNonNull(getActivity()).getSharedPreferences("data11",MODE_PRIVATE);
//
//       // String Item=sh.getString("phone",null);
//
//        String ii=   sh.getString("id",null);
//        String nn=  sh.getString("name",null);
//        return root;
//
////
//       // dph.setText(Item);
//      name.setText(nn);
//      email.setText(ii);
//
//
//    }
//}
//
//
public class ToolsFragment extends Fragment {
    ImageView image;
TextView name,email;
    SharedPreferences sh,logout;

    final int RequestPermissionCode=1;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_tools, container, false);
        image=root.findViewById(R.id.proimage);

       name=root.findViewById(R.id.proname);
        email=root.findViewById(R.id.proemail);

        sh= Objects.requireNonNull(getActivity()).getSharedPreferences("data11",MODE_PRIVATE);
        String Item=sh.getString("name",null);

        String ii=   sh.getString("empid",null);

       String ee=    sh.getString("image",null);



       name.setText(Item);
       email.setText(ii);
        Picasso.get().load(ee).into(image);



        return root;
    }


}



