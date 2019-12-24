package com.azhon.scheme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

/**
 * <data
 * android:host="azhon"
 * android:port="1011"
 * android:scheme="azhon.scheme" />
 * 1.在Manifest中添加<data> 配置scheme地址
 * 2.scheme 规则
 * <scheme>://<host>:<port>[<path>|<pathPrefix>|<pathPattern>]
 * 3.跳转地址拼接如下
 * azhon.scheme://azhon:1012/我是路径?user=958460248&psd=123456
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView web = findViewById(R.id.web);
        Button btn = findViewById(R.id.btn);
        web.loadUrl("file:///android_asset/index.html");
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("azhon.scheme://azhon:1011/我是路径?user=958460248&psd=123456")));
            }
        });
    }
}
