package com.example.dataphpserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;


public class MainActivity2 extends AppCompatActivity {


    EditText edQueary;

    AppCompatButton button1;


    TextView tcdisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        edQueary=findViewById(R.id.edQueary);

        button1=findViewById(R.id.bscerce);

        tcdisplay=findViewById(R.id.tvdisplay);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String ed=edQueary.getText().toString();


                String url ="https://sowrovnil5bd.000webhostapp.com/apps/search.php?name="+ed;


                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        tcdisplay.setText(response.toString());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


                RequestQueue requestQueue= Volley.newRequestQueue(MainActivity2.this);

                requestQueue.add(jsonArrayRequest);





























            }
        });














    }
}