package com.example.dell.zhoukai2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String URL = "http://172.16.44.18:8080/xiaoshixun.json";
    private ListView listview;
    private List<Bean> bean = new ArrayList<>();
    private AlertDialog dialog;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        Utills.getInstance().getNetData(URL, new Utills.CallBacks() {
            @Override
            public void getString(String ss) {
                if (BuildConfig.DEBUG) Log.d("Main2Activity", ss);
                Gson gson = new Gson();
                dialog.dismiss();
                listview.setVisibility(View.VISIBLE);
                Type type = new TypeToken<List<Bean>>() {

                }.getType();
                List<Bean> list_bean = gson.fromJson(ss, type);
                bean.addAll(list_bean);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new MyAdapter(Main2Activity.this, bean);
                        listview.setAdapter(adapter);
                    }
                });

            }
        });
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        listview.setOnItemClickListener(this);
        dialog = new AlertDialog.Builder(Main2Activity.this)
                .setMessage("请稍等...")
                .show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", bean.get(i));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
