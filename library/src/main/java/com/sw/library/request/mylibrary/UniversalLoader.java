package com.sw.library.request.mylibrary;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.sw.library.request.mylibrary.mode.UniversalResult;

import org.apache.http.Header;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;

/**
 * Created by aliouswang on 15/5/5.
 */
public class UniversalLoader {

    private static UniversalLoader mDefaultLoader;

    private UniversalLoader() {

    }

    /**
     * get default universal loader
     * @return default loader
     */
    public static UniversalLoader getDefault() {
        if (mDefaultLoader == null) {
            mDefaultLoader = new UniversalLoader();
        }
        return mDefaultLoader;
    }

    /**
     * load data with GET without parse
     * @param context
     * @param url
     * @param listener
     */
    public void loadDataWithOutParse(Context context, final String url,
                                     final UniversalLoadListener listener) {
        loadData(context, url, listener, false);
    }

    /**
     * normal load data with GET and parse json if possible
     * without headers and params
     * @param context
     * @param url
     * @param listener
     * @param needParse
     * @param clazz
     */
    public void loadData (Context context, final String url,
                                final UniversalLoadListener listener,
                                final boolean needParse,
                                final Class... clazz) {
        loadDataWithHeader(context, url, null, null, listener, needParse, clazz);
    }

    /**
     * load data with GET and add headers and params
     * @param context
     * @param url
     * @param headers
     * @param params
     * @param listener
     * @param needParse
     * @param clazz
     */
    public void loadDataWithHeader (Context context, final String url,
                          final Header[] headers,
                          final RequestParams params,
                          final UniversalLoadListener listener,
                          final boolean needParse,
                          final Class... clazz) {
        AsyncHttpClient client = new AsyncHttpClient();
        if (listener != null) {
            listener.preLoad();
        }
        client.get(context, url, headers, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                //if use Gson parse json, we need assign params.
                if (responseBody == null || responseBody.length < 1) return;
                if (needParse && (clazz == null || clazz.length < 1)) return;
                String json = new String(responseBody);
                if (TextUtils.isEmpty(json)) {
                    return;
                }
                UniversalResult result = null;
                Gson gson = new Gson();
                if (needParse) {
                    Type type = Utils.type(UniversalResult.class, clazz);
                    result = gson.fromJson(json, type);
                }
                if (listener != null) {
                    listener.loadSuccess(url, json, result);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody == null || responseBody.length < 1) return;
                if (listener != null) {
                    listener.loadFailed(url, new String(responseBody));
                }
            }
        });

    }

    /**
     * normal load data with POST and parse json if possible
     * without headers and params
     * @param context
     * @param url
     * @param listener
     * @param needParse
     * @param clazz
     */
    public void loadDataWithPost (Context context, final String url,
                          final Header[] headers,
                          final RequestParams params,
                          final String contentType,
                          final UniversalLoadListener listener,
                          final boolean needParse,
                          final Class... clazz) {
        AsyncHttpClient client = new AsyncHttpClient();
        if (listener != null) {
            listener.preLoad();
        }
        client.post(context, url, headers, params, contentType, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                //if use Gson parse json, we need assign params.
                if (responseBody == null || responseBody.length < 1) return;
                if (needParse && (clazz == null || clazz.length < 1)) return;
                String json = new String(responseBody);
                if (TextUtils.isEmpty(json)) {
                    return;
                }
                UniversalResult result = null;
                Gson gson = new Gson();
                if (needParse) {
                    Type type = Utils.type(UniversalResult.class, clazz);
                    result = gson.fromJson(json, type);
                }
                if (listener != null) {
                    listener.loadSuccess(url, json, result);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (responseBody == null || responseBody.length < 1) return;
                if (listener != null) {
                    listener.loadFailed(url, new String(responseBody));
                }
            }
        });
    }

    public void uploadFiles(Context context, final String url,
                            final String[] filePaths,
                            final UniversalLoadListener listener) {
        AsyncHttpClient client = new AsyncHttpClient();
        if (listener != null) {
            listener.preLoad();
        }
        RequestParams params = new RequestParams();
        int index = 0;
        for (String path : filePaths) {
            if (TextUtils.isEmpty(path)) {
                continue;
            }
            File file = new File(path);
            try {
                params.put("file" + index++, file );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        client.post(context, url, params, new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (listener != null && responseBody != null) {
                    listener.loadSuccess(url, new String(responseBody), null);
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (listener != null && responseBody != null) {
                    listener.loadFailed(url, new String(responseBody));
                }
            }
        });
    }

}
