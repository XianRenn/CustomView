package defineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by xianren on 2017/12/2.
 */
public class SubView extends View {
    Paint mPaint;
    int widthSize;
    int heightSize;

    public SubView(Context context) {
        super(context);
        init();
    }

    public SubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circleRadius = heightSize/2;
        mPaint.setAntiAlias(false);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(widthSize/2,heightSize/2, circleRadius, mPaint);
    }

    void init() {
        mPaint = new Paint();
    }
}
