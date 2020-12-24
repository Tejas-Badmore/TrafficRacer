package com.example.trafficracer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

import static com.example.trafficracer.GameView.screenRatioX;
import static com.example.trafficracer.GameView.screenRatioY;

public class Traffic {
    int x=0,y,speed=15;
    int id;
    int width,heigth;
    boolean firstTimeCar=false;
    Random random;
     private TrafficCars trafficCars;
    Traffic(int id,int screenX, int screenY, Resources res){
        this.id = id;
        random = new Random();
        trafficCars = new TrafficCars(screenX,screenY,res);
        y=-getMainHeight(this.id)-((int)(random.nextInt(20)*screenRatioY));
        x=random.nextInt((screenX*3)/4);
        if(x<screenX/6-(20*screenRatioX))
            x= (int) (x+screenX/6-(20*screenRatioX));
        width = getMainWidth(this.id);
        heigth = getMainHeight(this.id);
        firstTimeCar = true;
    }


    Bitmap getMainCar(int id){

        return trafficCars.createParticularCar(id);
    }
    int getMainWidth(int id){
        width = trafficCars.getWidth(id);
        return trafficCars.getWidth(id);
    }
    int getMainHeight(int id){
        heigth = trafficCars.getHeight(id);
        return trafficCars.getHeight(id);
    }

    Rect getCollisionShape(int id){
        return new Rect(x,y,x+getMainWidth(id),y+getMainHeight(id));
    }
}
