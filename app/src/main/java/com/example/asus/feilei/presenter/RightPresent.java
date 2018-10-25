package com.example.asus.feilei.presenter;

import com.example.asus.feilei.bean.RightBean;
import com.example.asus.feilei.iview.RightIView;
import com.example.asus.feilei.model.RightModel;
import com.example.asus.feilei.utils.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class RightPresent {
    private RightIView iv;
    private RightModel rightModel;
    public void attch(RightIView iv){
        this.iv = iv;
        rightModel = new RightModel();
    }
    public void getright(String url){
        Type type = new TypeToken<RightBean>(){}.getType();
        rightModel.getrights(url, new ICallBack() {

            public void onSuccess(Object obj) {
                RightBean rightBean = (RightBean) obj;
                if (rightBean!=null){
                    iv.getrights(rightBean.getData());
                }
            }

            @Override
            public void onFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void detach(){
        if (iv !=null){
            iv = null;
        }
    }
}
