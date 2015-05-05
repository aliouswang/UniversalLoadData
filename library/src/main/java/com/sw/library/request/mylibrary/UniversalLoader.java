package com.sw.library.request.mylibrary;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.sw.library.request.mylibrary.mode.UniversalResult;

import org.apache.http.Header;

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

    public void loadData (Context context, final String url,
                                final UniversalLoadListener listener,
                                final boolean needParse,
                                final Class... clazz) {
        AsyncHttpClient client = new AsyncHttpClient();
        if (listener != null) {
            listener.preLoad();
        }
        client.get(url, new AsyncHttpResponseHandler() {
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

}
