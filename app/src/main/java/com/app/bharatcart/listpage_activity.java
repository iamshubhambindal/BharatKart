package com.app.bharatcart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bharatcart.Adapters.SearchResultAdapter;
import com.app.bharatcart.R;
import com.app.bharatcart.pojo.Result;
import com.google.gson.Gson;

public class listpage_activity extends AppCompatActivity implements SearchResultAdapter.count_update_listener{
    Result result;
    RecyclerView searchResultRecyclerView;
    LinearLayoutManager linearLayoutManager;
    Button button;
    int count_value=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpage);
        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.listPageToolBar);
        setSupportActionBar(toolbar);
        Log.e("TAG", "onCreate: "+toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        toolbar.setTitle("");
        Intent intent =  getIntent();
        result=intent.getParcelableExtra("searchresult");
        Log.e("List Activity", "onCreate: "+new Gson().toJson(result));
        searchResultRecyclerView=findViewById(R.id.appListRecyclerView);
        SearchResultAdapter searchResultAdapter=new SearchResultAdapter(result,listpage_activity.this);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        searchResultRecyclerView.setLayoutManager(linearLayoutManager);
        searchResultRecyclerView.setAdapter(searchResultAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void getCountValue(int count) {
        count_value = count;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e("Count", "onPostResume: "+count_value );
        if (count_value == 1){
            Intent intent = new Intent(listpage_activity.this,thankyou.class);
            startActivity(intent);
            count_value = 2;
        }

    }
}
