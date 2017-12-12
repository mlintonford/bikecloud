package info.unitool.app3.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Random;

public class MainActivity extends Activity {

    public MySurfaceView mySurfaceView;
    public GameManager gm;
    protected MyApp mMyApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApp = (MyApp)this.getApplicationContext();
        //mySurfaceView = new MySurfaceView(this);
        setContentView(R.layout.activity_main);
        //setContentView(mySurfaceView);

        gm = new GameManager();


    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //mySurfaceView.onResumeMySurfaceView();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        clearReferences();
        mySurfaceView.onPauseMySurfaceView();
    }

    private void clearReferences(){
        Activity currActivity = mMyApp.getCurrentActivity();
        if (this.equals(currActivity))
            mMyApp.setCurrentActivity(null);
    }

    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }





    public static class MySurfaceView extends SurfaceView implements Runnable {

        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Random random;

        Thread thread = null;
        SurfaceHolder surfaceHolder;
        volatile boolean running = false;

        public MySurfaceView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
            surfaceHolder = getHolder();
            running = true;
            thread = new Thread(this);
            thread.start();
        }

        public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            // TODO Auto-generated constructor stub
            surfaceHolder = getHolder();
            running = true;
            thread = new Thread(this);
            thread.start();
        }

        public MySurfaceView(Context context, AttributeSet attrs) {
            super(context, attrs);
            // TODO Auto-generated constructor stub
            surfaceHolder = getHolder();
            running = true;
            thread = new Thread(this);
            thread.start();
        }

    public void onResumeMySurfaceView() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

        public void onPauseMySurfaceView() {
            boolean retry = true;
            running = false;
            while (retry) {
                try {
                    thread.join();
                    retry = false;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        // Create an anonymous implementation of OnClickListener
        private OnTouchListener mCorkyListener = new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {

                return true;
            }
        };

        public void run() {
            // TODO Auto-generated method stub
            while (running) {
                if (surfaceHolder.getSurface().isValid()) {
                    Canvas canvas = surfaceHolder.lockCanvas();

                    Context context = this.getContext();
                    MainActivity ma = (MainActivity) context;
                    canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), ma.gm.DEATH_PIT.pictureId), 0, 0, paint);

                    Bitmap picture = BitmapFactory.decodeResource(getResources(), R.mipmap.picture1);
                    canvas.drawBitmap(picture, 100, 100, paint);

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
