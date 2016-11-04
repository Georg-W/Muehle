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

    {
        outlinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outlinePaint.setAntiAlias(true);
        outlinePaint.setStyle(Paint.Style.STROKE);
        outlinePaint.setColor(Color.BLACK);
        outlinePaint.setStrokeWidth(20);
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int space = 350;


        Rect outer = new Rect();
        outer.set(10, 10,canvas.getWidth()-10,canvas.getHeight()-10);
        Rect middle = new Rect();
        middle.set(175, 175,canvas.getWidth()-175,canvas.getHeight()-175);
        Rect inner = new Rect();
        inner.set(350, 350,canvas.getWidth()-350,canvas.getHeight()-350);




        canvas.drawLine(0, canvas.getHeight()/2, space, canvas.getHeight()/2, outlinePaint);
        canvas.drawLine(canvas.getWidth()-space, canvas.getHeight()/2, canvas.getWidth(), canvas.getHeight()/2, outlinePaint);
        canvas.drawLine(canvas.getWidth()/2, 0,canvas.getWidth()/2, space, outlinePaint);
        canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()-space, canvas.getWidth()/2, canvas.getHeight(), outlinePaint);
        canvas.drawRect(outer, outlinePaint);
        canvas.drawRect(middle, outlinePaint);
        canvas.drawRect(inner, outlinePaint);
        Log.d("test", "got created");



    }
}
