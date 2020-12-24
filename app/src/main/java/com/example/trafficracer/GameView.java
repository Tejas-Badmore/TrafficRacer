package com.example.trafficracer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.Random;

public class GameView extends SurfaceView implements Runnable {
    Thread thread;
    private boolean isPlaying;
    Background background1,background2;
    int screenY,screenX;
    private RaceCar raceCar;
    private Traffic[] traffics;
    public static float screenRatioX,screenRatioY;
    private Paint paint;
    private boolean isMovingRight=false,isMovingLeft=false;
    private Random random;
    private boolean isGameOver= false;
    private GameActivity activity;

    public GameView(GameActivity context,int screenX, int screenY) {
        super(context);
        this.screenX= screenX;
        this.screenY= screenY;
        activity=context;
        screenRatioY = 1920f/screenY;
        screenRatioX = 1080f/screenX;
        background1 =new Background(screenX,screenY,getResources());
        background2 = new Background(screenX,screenY,getResources());
        raceCar = new RaceCar(screenX,screenY,getResources());
        background2.y = -screenY;
        random = new Random();

        traffics = new Traffic[4];
        for(int i=0;i<4;i++){
            int id= random.nextInt(9)+1;
            Traffic traffic=new Traffic(id,screenX,screenY,getResources());
            traffics[i]=traffic;
        }
        paint = new Paint();

    }

    @Override
    public void run() {
        while (isPlaying){
            update();
            draw();
            sleep();
        }
    }

    private void update() {
        background1.y +=20*screenRatioY;
        background2.y +=20*screenRatioY;

        if(background1.background.getHeight() - background1.y < 0)
        {
            background1.y= -screenY;
        }
        if(background2.background.getHeight()-background2.y  < 0)
        {
            background2.y= -screenY;
        }

        if(isMovingLeft){
            raceCar.x -=12*screenRatioX;
            isMovingLeft=false;
        }
        if(isMovingRight){
            raceCar.x +=12*screenRatioX;
            isMovingRight=false;
        }
        if(raceCar.x<screenX/6-(20*screenRatioX))
            raceCar.x=screenX/6-(int)(30*screenRatioX);
        if(raceCar.x>(screenX*3)/4)
            raceCar.x=(screenX*3)/4;

        for(Traffic traffic: traffics)
        {
            traffic.y +=traffic.speed;
            int prev_id=traffic.id;
            if(background1.background.getHeight() - traffic.y < 0){
                int bound= (int)(18*screenRatioY);
                traffic.speed=random.nextInt(bound);
                if (traffic.speed<(10*screenRatioY))
                    traffic.speed= (int) (10*screenRatioY);

                traffic.id=random.nextInt(9)+1;
                traffic.y=-screenY-((int)(random.nextInt(20)*screenRatioY));
                //idhar trafiic intersect nahi hona chahiye
                traffic.x=random.nextInt(screenX);
                if(traffic.x<screenX/6-(20*screenRatioX))
                    traffic.x=screenX/6-(int)(30*screenRatioX);
                if(traffic.x>(screenX*3)/4)
                    traffic.x=(screenX*3)/4;

            }
            //collision vala scene
            if(Rect.intersects(traffic.getCollisionShape(prev_id),raceCar.getCollisionShape())){
                isGameOver = true;
                return;
            }
        }
    }
    private void sleep(){
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void draw(){
        if(getHolder().getSurface().isValid())
        {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background,background1.x,background1.y,paint);
            canvas.drawBitmap(background2.background,background2.x,background2.y,paint);

            for (Traffic traffic:traffics){
                canvas.drawBitmap(traffic.getMainCar(traffic.id),traffic.x,traffic.y,paint);
            }
            if(isGameOver){
                isPlaying = false;
                waitBeforExiting();
                return;
            }
            canvas.drawBitmap(raceCar.getCar(),raceCar.x,raceCar.y,paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void waitBeforExiting() {
        try {
            Thread.sleep(2000);
            Intent i= new Intent(activity,MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void resume(){
        isPlaying= true;
        thread = new Thread(this);
        thread.start();
    }

    void pause(){
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                switch (event.ACTION_DOWN){
                    case MotionEvent.ACTION_DOWN:
                        if( event.getX() < screenX/3)
                            isMovingLeft=true;
                        if (event.getX()>(screenX*2)/3)
                            isMovingRight=true;
                        break;
                }
                break;
        }

        return true;
    }

}
