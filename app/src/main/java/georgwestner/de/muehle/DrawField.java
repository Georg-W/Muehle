package georgwestner.de.muehle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Georg on 04.11.2016.
 */

public class DrawField extends View
{

    final Paint outlinePaint;
    final Paint fields;

    {
        outlinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outlinePaint.setAntiAlias(true);
        outlinePaint.setStyle(Paint.Style.STROKE);
        outlinePaint.setColor(Color.BLACK);
        outlinePaint.setStrokeWidth(20);
    }

    {
        fields = new Paint(Paint.ANTI_ALIAS_FLAG);
        fields.setAntiAlias(true);
        fields.setStyle(Paint.Style.FILL);
        fields.setColor(Color.BLACK);
    }

    public DrawField(Context context) {
        super(context);
    }

    public DrawField(Context context, AttributeSet set) {
        super(context, set);
    }

    public DrawField(Context context, AttributeSet set, int style) {
        super(context, set, style);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = width > height ? height : width;
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int space = 350;
        int outlinemargin =30;


        Rect outer = new Rect();
        outer.set(outlinemargin, outlinemargin,canvas.getWidth()-outlinemargin,canvas.getHeight()-outlinemargin);
        Rect middle = new Rect();
        middle.set(200, 200,canvas.getWidth()-200,canvas.getHeight()-200);
        Rect inner = new Rect();
        inner.set(350, 350,canvas.getWidth()-350,canvas.getHeight()-350);




        canvas.drawLine(outlinemargin, canvas.getHeight()/2, space, canvas.getHeight()/2, outlinePaint); //1st left to right
        canvas.drawLine(canvas.getWidth()-space, canvas.getHeight()/2, canvas.getWidth()-outlinemargin, canvas.getHeight()/2, outlinePaint); //2nd left to right
        canvas.drawLine(canvas.getWidth()/2, outlinemargin,canvas.getWidth()/2, space, outlinePaint); //1st top to bottom
        canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()-space, canvas.getWidth()/2, canvas.getHeight()-outlinemargin, outlinePaint); //2nd top to bottom
        canvas.drawRect(outer, outlinePaint);
        canvas.drawRect(middle, outlinePaint);
        canvas.drawRect(inner, outlinePaint);
        Log.d("test", "got created");


        int circleNumbers = 24;

        for (int i=0; i<24; i++){

            canvas.drawCircle(30,30,30,fields);

        }



    }
}
