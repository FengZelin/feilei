package com.example.asus.feilei.presenter;

import com.example.asus.feilei.bean.LeftBean;
import com.example.asus.feilei.iview.IView;
import com.example.asus.feilei.model.LeftModel;
import com.example.asus.feilei.utils.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class LeftPresenter {
    private IView iv;
    private LeftModel leftModel;
    public void attch(final IView iv){
        this.iv = iv;
        leftModel = new LeftModel();
    }
    public void getleft(){
        Type type = new TypeToken<LeftBean>(){}.getType();
        leftModel.getlefts("http://www.zhaoapi.cn/product/getCatagory", new ICallBack() {

            public void onSuccess(Object obj) {
                LeftBean leftBean = (LeftBean) obj;
                if (leftBean!=null){
                    iv.getleft(leftBean.getData());
                }
            }


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
