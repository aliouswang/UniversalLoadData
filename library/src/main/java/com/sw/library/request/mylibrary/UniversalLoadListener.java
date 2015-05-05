package com.sw.library.request.mylibrary;

import com.sw.library.request.mylibrary.mode.UniversalResult;

/**
 * Created by aliouswang on 15/5/5.
 */
public interface UniversalLoadListener {

    /**
     * invoke before load.
     */
    public void preLoad();

    /**
     * invoke after load success.
     * @param url           load url
     * @param response      response data
     * @return
     */
    public void loadSuccess(String url, String response, UniversalResult result);

    /**
     * invoke after load failed.
     * @param url           load url
     * @param response      response data
     * @return
     */
    public void loadFailed(String url, String response);

}
