package com.example.retrofitpostapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String email="interview@maishainfotech.com";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    List<Data> dataArrayList = new ArrayList<>();
    CategoryPojo categoryPojo = new CategoryPojo();
    List<Categories>categoriesList = new ArrayList<>();
    List<BData>bDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.maishainfotech.com/adinterview/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        UserClient client = retrofit.create(UserClient.class);

        //Call<T>- An invocation of a Retrofit method that sends a request to a webserver and returns a response.
        Call<CategoryPojo> call = client.sendEmail(
                email
        );

        call.enqueue(new Callback<CategoryPojo>() {
            @Override
            public void onResponse(Call<CategoryPojo> call, Response<CategoryPojo> response) {

                Toast.makeText(MainActivity.this, "Success"+response.body(),Toast.LENGTH_SHORT).show();
                Log.e("response",response.message().toString());

                categoryPojo = response.body();                 // all response added to categorypojo obj

                categoriesList= categoryPojo.getCategoriesList();       // response extracted from categorypojo and to arrayList

                for (int i=0;i<categoriesList.size();i++){

                    bDataList = new ArrayList<>();                          // the old data we are sending it to dataArrayList so we can reinitialze it
                    bDataList = categoriesList.get(i).getbDataList();

                    for (int j=0;j<bDataList.size();j++){                               // show all data finally  har baar refresh nahi kiya [we need to append data in existing data]
                        dataArrayList.addAll(bDataList.get(j).getDataList());
                    }
                }
                adapter = new RecyclerAdapter(MainActivity.this,dataArrayList);
                recyclerView.setAdapter(adapter);
               /* dataArrayList.addAll(response.body().)

                adapter = new RecyclerAdapter(MainActivity.this,book_arrayList);
                recyclerView.setAdapter(adapter);*/
            }

            @Override
            public void onFailure(Call<CategoryPojo> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });



    }
}