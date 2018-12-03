package com.bwei.heqianqian20181203;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2018/12/3 0003.
 */

public class SearchActivity extends FrameLayout {
    public SearchActivity(@NonNull Context context) {
        super(context);
    }

    public SearchActivity(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchActivity(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //先获取控件的宽度
        int width=getWidth();
        //d定义一个常量的行数
        int row=0;
        int disWidth=18;
        for (int i = 0; i <getChildCount() ; i++) {
            View view=getChildAt(i);
            int viewWidth=view.getWidth();
            int viewHeight=view.getHeight();
            if (disWidth+viewWidth>width){
                row++;
                disWidth=18;
            }
            view.layout(disWidth,row*viewHeight,viewWidth+disWidth,viewHeight*(row+1));
            disWidth+=viewWidth;
        }
    }
}
