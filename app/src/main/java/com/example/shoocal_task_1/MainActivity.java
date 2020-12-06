package com.example.shoocal_task_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shoocal_task_1.adapter.ShowDataAdapter;
import com.example.shoocal_task_1.api.ApiClientInterface;
import com.example.shoocal_task_1.databinding.ActivityMainBinding;
import com.example.shoocal_task_1.model.MainPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

     private ActivityMainBinding mainBinding;
     private List<MainPojo> mainPojoList;
     private ShowDataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        mainPojoList = new ArrayList<>();

        mainBinding.recyle.setHasFixedSize(true);
        mainBinding.recyle.setLayoutManager(new LinearLayoutManager(this));


        Call<List<MainPojo>> call =ApiClientInterface.getApiInterface().getData();
        call.enqueue(new Callback<List<MainPojo>>() {
            @Override
            public void onResponse(Call<List<MainPojo>> call, Response<List<MainPojo>> response) {
                if(response.code() ==200){
                    mainPojoList = response.body();

                    mAdapter = new ShowDataAdapter(MainActivity.this , mainPojoList);
                    mainBinding.recyle.setAdapter(mAdapter);



                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MainPojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "try after some times", Toast.LENGTH_SHORT).show();

            }
        });


    }
}