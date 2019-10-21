package com.example.cityandimage4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private ArrayList<CityModel> mCityList;

private RecyclerView mRecycleView;
private CityAdapter mCityAdapter;
private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

createCityList();
buildRecyclerView();
    }

    public void createCityList(){

        mCityList =new ArrayList<>();
        mCityList.add(new CityModel(R.drawable.gaziantep,"Gaziantep","27"));
        mCityList.add(new CityModel(R.drawable.istanbul,"İstanbul","34"));
        mCityList.add(new CityModel(R.drawable.izmir,"İzmir","38"));

    }

    public void buildRecyclerView() {
        //

        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mCityAdapter = new CityAdapter(mCityList);

        mRecycleView.setLayoutManager(mlayoutManager);
        mRecycleView.setAdapter(mCityAdapter);

        mCityAdapter.setOnItemClickListener(new CityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("pars",mCityList.get(position));
                startActivity(intent);


            }
        });
    }

}
