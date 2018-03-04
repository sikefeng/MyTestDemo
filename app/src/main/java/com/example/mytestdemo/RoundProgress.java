package com.example.mytestdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/3/3.
 */

public class RoundProgress extends View {
    private static final int DEFAULT_BG_COLOR = Color.GRAY;
    private static final int DEFAULT_ROUND_COLOR = Color.RED;
    private static final float DEFAULT_TEXT_SIZE = 16;
    private static final float DEFAULT_ROUND_WIDTH = 10;
    private static final int DEFAULT_TEXT_COLOR = Color.BLACK;
    private int mBgColor;
    private int mRoundColor;
    private float mTextSize;
    private float mRoundWidth;
    private int mTextColor;
    private Paint mPaint;
    private int mCenterY;
    private int mCenterX;
    private float mRadius;
    private RectF mRectF;
    private int mProgerss=0;

    public RoundProgress(Context context) {
        this(context,null);
    }

    public RoundProgress(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public RoundProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = getResources().obtainAttributes(attrs, R.styleable.RoundProgress);
        //拿到在xml配置的属性，如果没有配置，就使用默认的。
        mBgColor = a.getColor(R.styleable.RoundProgress_bgColor, DEFAULT_BG_COLOR);
        mRoundColor = a.getColor(R.styleable.RoundProgress_roundColor, DEFAULT_ROUND_COLOR);
        mTextSize = a.getDimension(R.styleable.RoundProgress_roundTextSize, DEFAULT_TEXT_SIZE);
        mRoundWidth = a.getDimension(R.styleable.RoundProgress_roundWidth, DEFAULT_ROUND_WIDTH);
        mTextColor = a.getColor(R.styleable.RoundProgress_roundTextColor, DEFAULT_TEXT_COLOR);
        a.recycle();//释放资源
        init();//初始化画笔
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    /**
     * 当layout大小变化后会回调次方法
     * 通过这方法获取宽高
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w/2;//控宽的中心点
        mCenterY = h/2;//控件高的中心点
        //防止宽高不一致
        int min = Math.min(mCenterX, mCenterY);
        //半径
        mRadius = min-mRoundWidth/2;
        //为画圆弧准备
        mRectF = new RectF(mCenterX-mRadius,mCenterY-mRadius,mCenterX+mRadius,mCenterY+mRadius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //        super.onDraw(canvas); 我们自己来画
        //1、先画背景圆环
        mPaint.setColor(mBgColor);
        mPaint.setStrokeWidth(mRoundWidth);
        canvas.drawCircle(mCenterX, mCenterY,mRadius,mPaint);



        Paint pp = new Paint(Paint.ANTI_ALIAS_FLAG);
        pp.setStyle(Paint.Style.FILL);
        pp.setColor(Color.parseColor("#e5e5e5"));
        canvas.drawCircle(mCenterX, mCenterY,mRadius-mRoundWidth,pp);



        //2、画动态圆弧
        mPaint.setColor(mRoundColor);
        canvas.drawArc(mRectF,0, (float) (3.6*mProgerss),false,mPaint);
        //3、画中间的文字
        mPaint.setColor(mTextColor);
        mPaint.setStrokeWidth(0);//如果不设置回0，很难看
        mPaint.setTextSize(mTextSize);
        //测量字体的宽度
        float width = mPaint.measureText(mProgerss + "%");
        canvas.drawText(mProgerss+"%",mCenterX-width/2,mCenterY+mTextSize/2,mPaint);
    }
    public void setProgress(int progerss){
        mProgerss=progerss;
        postInvalidate();
    }
}
