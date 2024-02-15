package com.example.dataphpserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText name1, mobile1, emal1;

    AppCompatButton button, button2;

    ListView listView;

    ProgressBar progressBar;


    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();


    HashMap<String,String>hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.prog);

        name1=findViewById(R.id.name1);
        mobile1=findViewById(R.id.mobile1);
        emal1=findViewById(R.id.password1);
        button=findViewById(R.id.button);

        button2=findViewById(R.id.buttonbbb);

        listView=findViewById(R.id.list);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          startActivity(new Intent(MainActivity.this,MainActivity2.class));




            }
        });




       LoadData();



























        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=name1.getText().toString();

                String mobile=mobile1.getText().toString();

                String  emal=emal1.getText().toString();


                String url ="https://sowrovnil5bd.000webhostapp.com/apps/data.php?n="+name+"&m="+mobile+"&e="+emal;






                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {




                                new AlertDialog.Builder(MainActivity.this)
                                        .setMessage(response)
                                        .setTitle("server response")

                                        .show();
    // >>>>>>>>>>>>>> ai khane lod data call koara karon  data add korar por abar data jate {{<<<<<<<RELOD>>>>>[[ hoi >>>>>>>>>>>>>>>>
                                LoadData();



                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


RequestQueue requestQueue=Volley.newRequestQueue(MainActivity.this);

                requestQueue.add(stringRequest);




            }
        });











    }


    public class Myadapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {




            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater layoutInflater=getLayoutInflater();

            View myview= layoutInflater.inflate(R.layout.layout,null);


            TextView tvid,tvname,tvmobile,tvemail;

            AppCompatButton buttondelet,buttonupgrate;


            tvid=myview.findViewById(R.id.tvid);
            tvname=myview.findViewById(R.id.tvname);
            tvmobile=myview.findViewById(R.id.tvmobile);
            tvemail=myview.findViewById(R.id.tvemail1);
            buttondelet=myview.findViewById(R.id.buttondelete);
            buttonupgrate=myview.findViewById(R.id.buttonupgrate);


            hashMap=arrayList.get(position);


            String id =hashMap.get("id");


            String name =hashMap.get("name");


            String mobile =hashMap.get("mobile");


            String email =hashMap.get("email");




            tvid.setText(id);

            tvname.setText(name);
            tvmobile.setText(mobile);
            tvemail.setText(email);








            buttonupgrate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name=name1.getText().toString();

                    String mobile=mobile1.getText().toString();

                    String  emal=emal1.getText().toString();


                    String url ="https://sowrovnil5bd.000webhostapp.com/apps/update.php?id="+id+"+&name="+name+"&mobile="+mobile+"&email="+emal;






                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {




                                    new AlertDialog.Builder(MainActivity.this)
                                            .setMessage(response)
                                            .setTitle("server response")

                                            .show();
                                    // >>>>>>>>>>>>>> ai khane lod data call koara karon  data add korar por abar data jate {{<<<<<<<RELOD>>>>>[[ hoi >>>>>>>>>>>>>>>>
                                    LoadData();



                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });


                    RequestQueue requestQueue=Volley.newRequestQueue(MainActivity.this);

                    requestQueue.add(stringRequest);



                }
            });



            buttondelet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                    String url ="https://sowrovnil5bd.000webhostapp.com/apps/deletdata.php?id="+id;






                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {




                                    new AlertDialog.Builder(MainActivity.this)
                                            .setMessage(response)
                                            .setTitle("server response")

                                            .show();
                                    // >>>>>>>>>>>>>> ai khane lod data call koara karon  data add korar por abar data jate {{<<<<<<<RELOD>>>>>[[ hoi >>>>>>>>>>>>>>>>
                                    LoadData();



                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });


                    RequestQueue requestQueue=Volley.newRequestQueue(MainActivity.this);

                    requestQueue.add(stringRequest);














                }
            });






            return myview;
        }
    }





  private void LoadData(){

        //<<<<<<<<<<<<<  atar karon  holo sarvaer a 2 bar Lod data jaoar por data aksate na hoye  new arraylist call hoi jno

        arrayList=new ArrayList<>();





      RequestQueue queue = Volley.newRequestQueue(MainActivity.this);


      progressBar.setVisibility(View.VISIBLE);


      JsonArrayRequest arrayRequest=new JsonArrayRequest(Request.Method.GET,
              "https://sowrovnil5bd.000webhostapp.com/apps/class266.php", null, new Response.Listener<JSONArray>() {
          @Override
          public void onResponse(JSONArray response) {

              progressBar.setVisibility(View.GONE);


              for (int x=0;x<response.length();x++) {
                  try {
                      JSONObject jsonObject=response.getJSONObject(x);


                      String id=jsonObject.getString("id");

                      String name=jsonObject.getString("name");

                      String mobile=jsonObject.getString("mobile");

                      String email=jsonObject.getString("email");


                      hashMap=new HashMap<>();




                      hashMap.put("name",name);
                      hashMap.put("mobile",mobile);
                      hashMap.put("email",email);

                      hashMap.put("id",id);

                      arrayList.add(hashMap);




                  } catch (JSONException e) {
                      throw new RuntimeException(e);
                  }
              }



              if (arrayList.size()>0){

                  Myadapter myadapter=new Myadapter();

                  listView.setAdapter(myadapter);





              }









          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {

              Log.d("ss",error.toString());

          }
      });





      queue.add(arrayRequest);


  }


}