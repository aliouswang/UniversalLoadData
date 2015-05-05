package com.sw.library.request.mylibrary;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by aliouswang on 15/5/5.
 */
public class Utils {

    public static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
