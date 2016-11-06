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
        int outerPos = 30;
        int middlePos = 200;
        int innerPos = 350;
        int fieldWidth = 30;


        Rect outer = new Rect();
        outer.set(outerPos, outerPos,canvas.getWidth()-outerPos,canvas.getHeight()-outerPos);
        Rect middle = new Rect();
        middle.set(middlePos, middlePos,canvas.getWidth()-middlePos,canvas.getHeight()-middlePos);
        Rect inner = new Rect();
        inner.set(innerPos, innerPos,canvas.getWidth()-innerPos,canvas.getHeight()-innerPos);




        canvas.drawLine(outerPos, canvas.getHeight()/2, space, canvas.getHeight()/2, outlinePaint); //1st left to right
        canvas.drawLine(canvas.getWidth()-space, canvas.getHeight()/2, canvas.getWidth()-outerPos, canvas.getHeight()/2, outlinePaint); //2nd left to right
        canvas.drawLine(canvas.getWidth()/2, outerPos,canvas.getWidth()/2, space, outlinePaint); //1st top to bottom
        canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()-space, canvas.getWidth()/2, canvas.getHeight()-outerPos, outlinePaint); //2nd top to bottom
        canvas.drawRect(outer, outlinePaint);
        canvas.drawRect(middle, outlinePaint);
        canvas.drawRect(inner, outlinePaint);
        Log.d("test", "got created");


        //1st Row down
        canvas.drawCircle(outerPos,outerPos,fieldWidth,fields);
        canvas.drawCircle(outerPos,canvas.getHeight()/2,fieldWidth,fields);
        canvas.drawCircle(outerPos,canvas.getHeight()-outerPos,fieldWidth,fields);
        //2nd Row down
        canvas.drawCircle(middlePos,middlePos,fieldWidth,fields);
        canvas.drawCircle(middlePos,canvas.getHeight()/2,fieldWidth,fields);
        canvas.drawCircle(middlePos,canvas.getHeight()-middlePos,fieldWidth,fields);
        //3rd Row down
        canvas.drawCircle(innerPos,innerPos,fieldWidth,fields);
        canvas.drawCircle(innerPos,canvas.getHeight()/2,fieldWidth,fields);
        canvas.drawCircle(innerPos,canvas.getHeight()-innerPos,fieldWidth,fields);
        //4th Row down
        canvas.drawCircle(canvas.getWidth()-innerPos,innerPos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()-innerPos,canvas.getHeight()/2,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()-innerPos,canvas.getHeight()-innerPos,fieldWidth,fields);
        //5th Row down
        canvas.drawCircle(canvas.getWidth()-middlePos,middlePos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()-middlePos,canvas.getHeight()/2,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()-middlePos,canvas.getHeight()-middlePos,fieldWidth,fields);
        //6th Row down
        canvas.drawCircle(canvas.getWidth()-outerPos,outerPos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()-outerPos,canvas.getHeight()/2,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()-outerPos,canvas.getHeight()-outerPos,fieldWidth,fields);
        //MiddleRow
        canvas.drawCircle(canvas.getWidth()/2,outerPos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()/2,middlePos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()/2,innerPos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()-innerPos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()-middlePos,fieldWidth,fields);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()-outerPos,fieldWidth,fields);





    }
}
