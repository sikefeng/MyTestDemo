package com.example.mytestdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mytestdemo.adapter.CommonAdapter;
import com.example.mytestdemo.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;
/**
 * 文件名：FoodFindListActivity <br>
 * 创建时间： 2018/3/2 下午14:20 <br>
 * 文件描述：<br>
 * 食品分类
 *
 * @author <a href="mailto:sikefeng.com">sikefeng</a> <br>
 * @version v0.1  <br>
 * @since JDK 1.8
 */
public class FoodFindListActivity extends AppCompatActivity {
    private ImageView ivBtnBack;
    private ListView listView;
    private List<EnergyBean> dataList;
    private FoodListAdapter foodListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_find_list);
        listView = findViewById(R.id.listView);
        ivBtnBack = findViewById(R.id.ivBtnBack);
        dataList = new ArrayList<>();
        EnergyBean energyBean = null;
        for (int i = 0; i < 15; i++) {
            energyBean = new EnergyBean();
            energyBean.setFoodName("鸡蛋");
            energyBean.setEnergyValue(144);
            dataList.add(energyBean);
        }
        foodListAdapter = new FoodListAdapter(FoodFindListActivity.this, dataList, R.layout.item_food_list);
        listView.setAdapter(foodListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(FoodFindListActivity.this, NutritionalInfoActivity.class));
            }
        });
        ivBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    onBackPressed();
            }
        });
    }

    private class FoodListAdapter extends CommonAdapter<EnergyBean> {

        public FoodListAdapter(Context mContext, List<EnergyBean> mDatas, int layoutId) {
            super(mContext, mDatas, layoutId);
        }

        @Override
        public void convert(ViewHolder holder, EnergyBean energyBean) {
            holder.setText(R.id.tv_food_name, energyBean.getFoodName());
            holder.setText(R.id.tv_energy, String.valueOf(energyBean.getEnergyValue()));
        }
    }


}
