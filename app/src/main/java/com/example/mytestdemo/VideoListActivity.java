package com.example.mytestdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mytestdemo.adapter.CommonAdapter;
import com.example.mytestdemo.adapter.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        ImageView imageView = (ImageView) findViewById(R.id.thumbImageView);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rel_layout_play);
        Picasso.with(this)
                .load("https://vthumb.ykimg.com/05410708524CAEEB6A0A4415CC19270A")
                .resize(600, 200)
                .centerInside()
                .into(imageView);
//        Picasso.with(VideoListActivity.this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").centerCrop().into(imageView);
//        test();
        tttttt();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JZVideoPlayerStandard.startFullscreen(VideoListActivity.this, JZVideoPlayerStandard.class, "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "动画世界");
            }
        });
    }


    private void test() {
//        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
////        jzVideoPlayerStandard.startFullscreen(this, JZVideoPlayerStandard.class, "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", "音乐会");
//        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
//                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
//        Picasso.with(VideoListActivity.this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").centerCrop().into(jzVideoPlayerStandard.thumbImageView);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    private void tttttt() {
        GridView gridView = (GridView) findViewById(R.id.gridView);
        List<VideoBean> list = new ArrayList<>();
        VideoBean videoBean = null;
        for (int i = 0; i < 8; i++) {
            videoBean = new VideoBean();
            videoBean.setTitle("纵向全套压缩运动");
            videoBean.setThumbImageView("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png");
            if (i==1){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/05410708524CAEEB6A0A4415CC19270A");
            }else if (i==2){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/0541040857C793D96A0A45045ACAEC1D");
            }else if (i==3){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/054104085402C5EE6A0A43315AB4728F");
            }else if (i==4){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/0541040856EF6B1F6A0A410460B1095D");
            }else if (i==5){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/054104085A56FC3D00000173B400648E");
            }else if (i==6){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/0541040856C3D5026A0A4104566A62E5");
            }else if (i==7){
                videoBean.setThumbImageView("https://vthumb.ykimg.com/0541040856DE99CE6A0A3F045FC18DA7");
            }
            videoBean.setVideoLink("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4");
            list.add(videoBean);
        }
        MyAdapter myAdapter = new MyAdapter(this, list, R.layout.item_gridview_video);
        gridView.setAdapter(myAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                startActivity(new Intent(VideoListActivity.this,ViewPlayerActivity.class));
                JZVideoPlayerStandard.startFullscreen(VideoListActivity.this, JZVideoPlayerStandard.class, "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", "饺子辛苦了");
            }
        });
    }

    public class MyAdapter extends CommonAdapter<VideoBean> {

        public MyAdapter(Context mContext, List<VideoBean> mDatas, int layoutId) {
            super(mContext, mDatas, layoutId);
        }

        @Override
        public void convert(ViewHolder holder, VideoBean videoBean) {
            ImageView thumbImageView = holder.getView(R.id.thumbImageView);
//            Picasso.with(mContext)
//                    .load(videoBean.getThumbImageView())
//                    .resize(600, 200)
//                    .centerInside()
//                    .into(thumbImageView);
            Picasso.with(mContext)
                    .load(videoBean.getThumbImageView())
                    .fit()
                    .into(thumbImageView);
        }
    }


}
