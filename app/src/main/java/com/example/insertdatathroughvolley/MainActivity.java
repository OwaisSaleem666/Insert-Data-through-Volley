package com.example.insertdatathroughvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static String url = "http://192.168.10.8/aqua/public/api/users/submit";
    EditText txtName;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (EditText) findViewById(R.id.et_Name);
        requestQueue = Volley.newRequestQueue(this);
    }
    public void insertData(View view){

        final String name = txtName.getText().toString();

        StringRequest insert_request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("Name", name);
                map.put("Phone", "0975436787");
                map.put("UserName", "dfbkikk");
                map.put("Email", "email2@gmail.com");
                map.put("Password", "password___213");
                map.put("TerritoryId", "1");
                map.put("Type", "User");
                return map;
            }
        };
requestQueue.add(insert_request);
    }
}