package com.example.getimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemDataClickListener{
    private RecyclerView rcvListData;
    private ListDataAdapter mListDataAdapter;
    private ArrayList<Data> mListData = new ArrayList<>();
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initAction();
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
    }

    private void initData() {
        mListData = new ArrayList<>();
        mListData.add(new Data("Picture", R.drawable.ic_collections_black_24dp,1034));
    }

    private void initView() {
        rcvListData = findViewById(R.id.rcv_list_data);
    }

    @SuppressLint("WrongConstant")
    private void initAction() {
        mListDataAdapter = new ListDataAdapter(this,mListData);
        mListDataAdapter.setClick(this);
        rcvListData.setAdapter(mListDataAdapter);
        rcvListData.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayout.VERTICAL, false));
    }

    @Override
    public void OnItemDataClick(int position) {
        Log.d("????????","asdasdsad");
        Intent intent = new Intent(MainActivity.this, AllPictureActivity.class);
        startActivity(intent);
    }
}
