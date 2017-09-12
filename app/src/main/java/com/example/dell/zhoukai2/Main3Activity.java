package com.example.dell.zhoukai2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.youth.banner.Banner;

public class Main3Activity extends AppCompatActivity {

    private TextView title;
    private Banner banner;
    private TextView main3_content;
    private Bean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initData();
        initView();
    }

    private void initData() {
        bean = (Bean) getIntent().getExtras().getSerializable("key");
    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        banner = (Banner) findViewById(R.id.banner);
        main3_content = (TextView) findViewById(R.id.main3_content);
        banner.setImages(bean.getImgs())
                .setImageLoader(new GlideImageLoader())
                .start();
        title.setText(bean.getName());
        main3_content.setText(bean.getContent());
    }
}
