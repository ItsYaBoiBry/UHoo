package hoo.u.magazine.u_hooprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ActivityWebView extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String booking = intent.getStringExtra("link");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(booking);

    }
}
