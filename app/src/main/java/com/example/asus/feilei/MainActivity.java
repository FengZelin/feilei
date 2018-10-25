package com.example.asus.feilei;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.feilei.adapter.LeftAdapter;
import com.example.asus.feilei.adapter.RightAdapter;
import com.example.asus.feilei.bean.LeftBean;
import com.example.asus.feilei.bean.RightBean;
import com.example.asus.feilei.iview.IView;
import com.example.asus.feilei.iview.RightIView;
import com.example.asus.feilei.presenter.LeftPresenter;
import com.example.asus.feilei.presenter.RightPresent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView,RightIView {
    private RecyclerView recleft;
    private LeftAdapter leftAdapter;
    private List<LeftBean.DataBean> beanList;
    private LeftPresenter leftPresenter;
    private LinearLayout layoutright;
    private RightAdapter rightAdapter;
    private RightPresent rightPresenter;
    private List<RightBean.DataBean> beanright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recleft= findViewById(R.id.rec_left);
        layoutright=findViewById(R.id.right_lnl);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1, LinearLayoutManager.VERTICAL,false);
        recleft.setLayoutManager(layoutManager);
        beanList = new ArrayList<>();
        beanright = new ArrayList<>();
        leftAdapter = new LeftAdapter(this,beanList);
        leftAdapter.setOnItemClickListener(new LeftAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
                LeftBean.DataBean dataBean = beanList.get(position);
                rightPresenter.getright("http://www.zhaoapi.cn/product/getProductCatagory?cid="+dataBean.getCid());
            }
        });
        recleft.setAdapter(leftAdapter);
        leftPresenter = new LeftPresenter();
        leftPresenter.attch(this);
        leftPresenter.getleft();
        rightPresenter = new RightPresent();
        rightPresenter.attch(this);

    }

    @Override
    public void getleft(List<LeftBean.DataBean> list) {
        if (list !=null){
            beanList.clear();
            beanList.addAll(list);
            leftAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getrights(List<RightBean.DataBean> list) {
        if (list != null){
            layoutright.removeAllViews();
            for (int i = 0;i<list.size();i++){
                TextView textView = new TextView(this);
                textView.setText(list.get(i).getName());
                RecyclerView rvNextb = new RecyclerView(this);
                RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(this,3);
                rvNextb.setLayoutManager(layoutManager2);
                rightAdapter = new RightAdapter(MainActivity.this,list.get(i).getList());
                rvNextb.setAdapter(rightAdapter);
                beanright.clear();
                beanright.addAll(list);
                leftAdapter.notifyDataSetChanged();
                layoutright.addView(textView);
                layoutright.addView(rvNextb);
            }
        }
    }

    @Override
    public void failed(Exception e) {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (leftPresenter!=null){
            leftPresenter.detach();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        rightPresenter.getright("http://www.zhaoapi.cn/product/getProductCatagory?cid=1");
    }
}
