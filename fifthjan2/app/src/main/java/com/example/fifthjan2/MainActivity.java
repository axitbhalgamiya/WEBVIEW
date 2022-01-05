package com.example.fifthjan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button b1;
EditText t1;
WebView wb;
String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.b1);
        t1=(EditText) findViewById(R.id.t1);
        wb=(WebView) findViewById(R.id.wb);
        wb.setWebViewClient(new MyBrowser());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url=t1.getText().toString();
                wb.getSettings().setLoadsImagesAutomatically(true);
                wb.getSettings().setJavaScriptEnabled(true);
                wb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wb.loadUrl(url);
            }
        });
    }
    private class MyBrowser extends WebViewClient{
         /*public boolean shouldOverrideUrlLoading(WebView view, String url) {
             view.loadUrl(url);
             return true;
         }*/

        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            final Uri uri = request.getUrl();
            return handleUri(uri);

        }

        private boolean handleUri(Uri uri) {

           //final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
           //startActivity(intent);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wb.loadUrl(String.valueOf(uri));
                }
            });

            return  true;
        }
    }

}