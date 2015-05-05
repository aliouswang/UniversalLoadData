package com.sw.library.request.mylibrary.mode;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by aliouswang on 15/5/5.
 */
public class UniversalResult <T> implements Serializable{

    private static final long serialVersionUID = 1L;

    private ArrayList<T> resultList;


    public ArrayList<T> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<T> resultList) {
        this.resultList = resultList;
    }
}
