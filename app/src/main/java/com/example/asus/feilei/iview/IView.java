package com.example.asus.feilei.iview;

import com.example.asus.feilei.bean.LeftBean;

import java.util.List;

public interface IView {
    void getleft(List<LeftBean.DataBean> list);
    void failed(Exception e);
}
