package com.codingblocks.retrofitgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codingblocks.retrofitgson.models.Post;
import com.google.gson.Gson;

import java.lang.reflect.Field;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit r = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        JsonPlaceholder api = r.create(JsonPlaceholder.class);

        api.getPostById(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post p = response.body();

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
}
