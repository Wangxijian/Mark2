package com.stark.mark2.ui;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.mark2.R;
import com.stark.mark2.bean.News;
import com.stark.mark2.util.Utils;

import static android.webkit.WebSettings.TextSize.LARGER;

public class NewsContentActivity extends AppCompatActivity {
    WebView webView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        webView = findViewById(R.id.web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setTextSize(LARGER);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            News news = bundle.getParcelable("News");
            if (null != news) {
                url = news.getNewsContent();
                Utils.LogE(url);
                webView.loadUrl(url);
            }
        }

    }
}
