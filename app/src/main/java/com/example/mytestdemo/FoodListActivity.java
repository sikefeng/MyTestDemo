package com.example.mytestdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodListActivity extends Activity {
    private GridView gview;
    private LinearLayout layoutFindFood;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.mainfood, R.drawable.meat_eggs,
            R.drawable.peas, R.drawable.vegetables, R.drawable.fruits,
            R.drawable.milk, R.drawable.grease, R.drawable.nuts,
            R.drawable.condiment, R.drawable.drinks, R.drawable.snacks,
            R.drawable.other_food};
    private String[] iconName = {"主食类", "肉蛋类", "大豆及制品", "蔬菜及菌藻类", "水果类", "奶类", "油脂类",
            "坚果类", "调味类", "饮料类", "零食,点心及冷饮", "其它"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodlist_topbar);
        gview = (GridView) findViewById(R.id.gridView);
        layoutFindFood = (LinearLayout) findViewById(R.id.findFood);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item_gridview_food, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(FoodListActivity.this, FoodFindListActivity.class));
            }
        });
        layoutFindFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodListActivity.this, FoodFindListActivity.class));
            }
        });
    }


    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }


}