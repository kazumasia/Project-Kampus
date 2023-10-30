package com.example.pb3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private ArrayList<List> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("List User");


        rvList = findViewById(R.id.rv_ListMain);
        rvList.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecyclerList();
    }

    public ArrayList<List> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_desc);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        TypedArray dataLatar = getResources().obtainTypedArray(R.array.latar);
        ArrayList<List> listKuma = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            List kuma = new List();
            kuma.setName(dataName[i]);
            kuma.setDescription(dataDescription[i]);
            kuma.setPhoto(dataPhoto.getResourceId(i, -1));
            kuma.setLatar(dataLatar.getResourceId(i,-1));
            listKuma.add(kuma);
        }
        return listKuma;
    }

    private void showRecyclerList() {
        rvList.setLayoutManager(new GridLayoutManager(this, 2));
        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvList.setLayoutManager(new GridLayoutManager(this, 2));
        } else {

            rvList.setLayoutManager(new LinearLayoutManager(this));
        }
        ListAdapter listAdapter = new ListAdapter(list);
        rvList.setAdapter(listAdapter);
    }
}
