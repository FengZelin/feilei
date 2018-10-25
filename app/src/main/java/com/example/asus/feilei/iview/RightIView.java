package com.example.asus.feilei.iview;

import com.example.asus.feilei.bean.RightBean;

import java.util.List;

public interface RightIView {
    void getrights(List<RightBean.DataBean> list);
    void failed(Exception e);
}
