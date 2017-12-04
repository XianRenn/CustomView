package defineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.xianren.customview.R;

import static android.content.ContentValues.TAG;

/**
 * Created by xianren on 2017/12/2.
 */
public class SubView extends View {
    Paint mPaint;
    Paint txPaint;
    int widthSize;
    int heightSize;

    String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    private Rect mBound;

    public SubView(Context context) {
        super(context);
        init();
    }

    public SubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrubutSet(context, R.styleable.SubView_titleText, attrs);
        init();
    }


    public SubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrubutSet(context, defStyleAttr, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
                break;
            case MeasureSpec.AT_MOST:
                Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
                break;
            case MeasureSpec.UNSPECIFIED:
                Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circleRadius = heightSize / 2;
        mPaint.setAntiAlias(false);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(widthSize / 2, heightSize / 2, circleRadius, mPaint);
        if (mTitleText != null)
            canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, txPaint);
    }

    void init() {
        mPaint = new Paint();
        txPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        txPaint.setTextSize(36);
        mBound = new Rect();
    }

    void getAttrubutSet(Context context, int defstyle, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SubView, defstyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SubView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.SubView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.SubView_titleTextSize:
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();
    }
}
