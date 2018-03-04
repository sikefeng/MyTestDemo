package com.example.mytestdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.mytestdemo.adapter.CommonAdapter;
import com.example.mytestdemo.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名：NutritionalInfoActivity <br>
 * 创建时间： 2018/3/2 下午14:31 <br>
 * 文件描述：<br>
 * 营养信息列表
 *
 * @author <a href="mailto:sikefeng.com">sikefeng</a> <br>
 * @version v0.1  <br>
 * @since JDK 1.8
 */
public class NutritionalInfoActivity extends AppCompatActivity {

    private ListView listView;
    private List<NutritionBean> dataList;
    private NutritionalInfoAdapter nutritionalInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional_info);
        listView = findViewById(R.id.listView);
        dataList = new ArrayList<>();
        NutritionBean nutritionBean = null;
        for (int i = 0; i < 15; i++) {
            nutritionBean = new NutritionBean();
            nutritionBean.setName("热量");
            nutritionBean.setNutValue("20.30千克");
            dataList.add(nutritionBean);
        }
        nutritionalInfoAdapter = new NutritionalInfoAdapter(NutritionalInfoActivity.this, dataList, R.layout.item_nutri_info);
        listView.setAdapter(nutritionalInfoAdapter);
    }

    private class NutritionalInfoAdapter extends CommonAdapter<NutritionBean> {

        public NutritionalInfoAdapter(Context mContext, List<NutritionBean> mDatas, int layoutId) {
            super(mContext, mDatas, layoutId);
        }

        @Override
        public void convert(ViewHolder holder, NutritionBean nutritionBean) {
            holder.setText(R.id.tv_energy, nutritionBean.getName());
            holder.setText(R.id.tv_energy_value, nutritionBean.getNutValue());
        }
    }


}