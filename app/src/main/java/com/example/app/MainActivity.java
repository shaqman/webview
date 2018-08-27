package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private final static String schema = "http";
    private final static String domain = "example.com";
    private final static String url = schema + "://" + domain;

    private WebView mWebView;
    private ConstraintLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.activity_main_webview);
        mLayout = findViewById(R.id.logoLayout);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // REMOTE RESOURCE
//        mWebView.loadUrl(url);
//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                if (Uri.parse(request.getUrl().toString()).getHost().endsWith(domain)) {
//                    return false;
//                }
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
//                view.getContext().startActivity(intent);
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                mLayout.setVisibility(View.GONE);
//                mWebView.setVisibility(View.VISIBLE);
//            }
//        });

        // LOCAL RESOURCE
//        mWebView.loadUrl("file:///android_asset/index.html");
    }

    // Prevent the back-button from closing the app
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}