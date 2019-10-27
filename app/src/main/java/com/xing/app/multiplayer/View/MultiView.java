package com.xing.app.multiplayer.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 *
 */
public class MultiView extends FrameLayout {

    private boolean orientation = horizontal;//true为左右滑动，false为上下滑动
    public static final boolean vertical = false;
    public static final boolean horizontal = true;

    public MultiView(@NonNull Context context) {
        this(context,null);
    }

    public MultiView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MultiView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public MultiView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private float startX,startY,moveDis;
    private long startTime,endTime;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                startTime = System.currentTimeMillis();
                break;

            case MotionEvent.ACTION_MOVE:

                if (orientation){
                    moveDis = event.getX() - startX;
                } else {
                    moveDis = event.getY() - startY;
                }
                onTouchMove(moveDis);

                break;

            case MotionEvent.ACTION_UP:
                endTime = System.currentTimeMillis();
                IsSlide(moveDis,endTime - startTime);
                break;
        }

        return super.onTouchEvent(event);
    }

    /**
     * @param distance 距离变化
     * @param time 从开始触摸，到结束触摸的时间
     */
    public void IsSlide(float distance, long time){
        //TODO 判断是否可以滑动
    }

    public void onTouchMove(float distance){
        //TODO 跟随手指滑动
    }

}
