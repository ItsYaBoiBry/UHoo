package hoo.u.magazine.u_hooprototype;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityMagazine extends AppCompatActivity {
    WebView mWebView;
    LinearLayout loadingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);

        ImageButton bck = findViewById(R.id.btnBack);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mWebView = findViewById(R.id.magazineSite);
        loadingScreen = findViewById(R.id.loadingScreen);

        renderWebPage("https://www.google.com.sg");

    }
    // Custom method to render a web page
    protected void renderWebPage(String urlToRender){
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                // Do something on page loading started
                // Visible the progressbar
                loadingScreen.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url){
                // Do something when page loading finished
                loadingScreen.setVisibility(View.GONE);
            }

        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int newProgress){
                // Update the progress bar with page loading progress

                    loadingScreen.setVisibility(View.GONE);
                }

        });

        // Enable the javascript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // Render the web page
        mWebView.loadUrl(urlToRender);
    }
}
