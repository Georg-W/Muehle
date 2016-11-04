package georgwestner.de.muehle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Georg on 04.11.2016.
 */

public class CanvasView extends View{

    Bitmap b;
    int x,y;

    public CanvasView(Context context) {
        super(context);

        b = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        x = 0;
        y = 0;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect outline = new Rect();
        outline.set(20, 20, canvas.getWidth()-20, canvas.getHeight()/2);

        Paint blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.STROKE);
        blue.setStrokeWidth(10);

        canvas.drawRect(outline, blue);

/*
        Rect myRect = new Rect();
        myRect.set(0,0,canvas.getWidth(), canvas.getHeight()/2);

        Paint blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.STROKE);

        canvas.drawRect(myRect, blue);

        if (x< canvas.getWidth()){
            x += 10;
        }
        else{
            x= 0;
        }

        if (y< canvas.getHeight()){
            y += 10;
        }
        else{
            y= 0;
        }

        Paint p = new Paint();
        canvas.drawBitmap(b, x, y, p);
        invalidate();

        */
    }



}
