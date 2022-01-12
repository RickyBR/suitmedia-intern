package com.example.suitmedia_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class ThirdActivity extends AppCompatActivity {
    ListView list_user;
    private RequestQueue requestQueue;
    DataAdapter dataAdapter;
    TextView judul;
    public static ArrayList<Data> dataArrayList = new ArrayList<>();
    Data data;
    String url = "https://reqres.in/api/users?page=1&per_page=10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        list_user = findViewById(R.id.list_user);
        judul = findViewById(R.id.judul);
        list_user.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String nama = toString();
                startActivity(new Intent(getApplicationContext(), SecondActivity.class).putExtra("position", position).putExtra("lala",nama));
            }
        });
        retrieveData();
    }

    private void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Res", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                                    if(jsonArray.length()>0){

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String id = object.getString("id");
                                    String firstN = object.getString("first_name");
                                    String lastN = object.getString("last_name");
                                    String email = object.getString("email");
                                    String avatar = object.getString("avatar");

                                   Data data = new Data(id , firstN, lastN, email, avatar);
                                    dataArrayList.add(data);

                                }

                                    }
                                    dataAdapter = new DataAdapter(ThirdActivity.this, dataArrayList);
                                    list_user.setAdapter(dataAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ThirdActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
/* JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        for (int i = 0 ; i < response.length() ; i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String firstN = jsonObject.getString("first_name");
                                String lastN = jsonObject.getString("last_name");
                                String email = jsonObject.getString("email");
                                String avatar = jsonObject.getString("avatar");



                                Data hero = new Data(id , firstN, lastN, email, avatar);
                                dataArrayList.add(hero);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            DataAdapter adapter = new DataAdapter(ThirdActivity.this , dataArrayList);

                            list_user.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ThirdActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);

        */