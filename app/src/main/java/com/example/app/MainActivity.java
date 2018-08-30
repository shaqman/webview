package com.example.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private final static String schema = "http";
    private final static String domain = "example.com";
    private final static String url = schema + "://" + domain;

    private boolean isPageError = false;

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
//            public void onPageCommitVisible(WebView view, String url) {
//                super.onPageCommitVisible(view, url);
//                if(!isPageError) {
//                    mLayout.setVisibility(View.GONE);
//                    mWebView.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                super.onReceivedError(view, request, error);
//                isPageError = true;
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setMessage(R.string.request_error_dialog_message)
//                        .setTitle(R.string.request_error_dialog_title)
//                        .setPositiveButton(R.string.request_error_dialog_okay_button, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                MainActivity.this.finishAndRemoveTask();
//                            }
//                        });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
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