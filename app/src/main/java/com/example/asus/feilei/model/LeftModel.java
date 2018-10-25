package com.example.asus.feilei.model;

import com.example.asus.feilei.utils.HttpUtils;
import com.example.asus.feilei.utils.ICallBack;

import java.lang.reflect.Type;

public class LeftModel {
    public void getlefts(String url, ICallBack callBack, Type type){
    HttpUtils.getInstance().get(url,callBack,type);
}

}
