package com.azhon.scheme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

public class TestOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
        setTitle("TestOneActivity");

        TextView tv = findViewById(R.id.message);
        StringBuilder sb = new StringBuilder();

        Intent intent = getIntent();
        Uri uri = intent.getData();

        assert uri != null;
        sb.append("scheme: ").append(intent.getScheme()).append("<p>");
        sb.append("host: ").append(uri.getHost()).append("<p>");
        sb.append("port: ").append(uri.getPort()).append("<p>");
        sb.append("path: ").append(uri.getPath()).append("<p>");
        sb.append("params: ").append(uri.getQuery()).append("<p>");
        //获取跳转过来携带所有参数的 键名
        Set<String> names = uri.getQueryParameterNames();
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            sb.append(key).append(": ").append(uri.getQueryParameter(key)).append("<p>");
        }
        tv.setText(Html.fromHtml(sb.toString()));
    }
}
