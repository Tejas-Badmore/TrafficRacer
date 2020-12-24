package com.example.trafficracer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.trafficracer.GameView.screenRatioX;
import static com.example.trafficracer.GameView.screenRatioY;

public class RaceCar {
    int x=0,y=0,width,height,carCounter=1;
    Bitmap car1,car2,car3;
    RaceCar(int screenX, int screenY, Resources res){
        car1 = BitmapFactory.decodeResource(res, R.drawable.maincar1);
        car2 = BitmapFactory.decodeResource(res, R.drawable.maincar2);
        car3 = BitmapFactory.decodeResource(res, R.drawable.maincar3);
        width = car1.getWidth();
        height = car1.getHeight();
        width /=2;
        height/=2;
        width -=15*screenRatioX;
        height -=36*screenRatioY;
        width *=screenRatioX;
        height *=screenRatioY;

        car1 = Bitmap.createScaledBitmap(car1,width,height,false);
        car2 = Bitmap.createScaledBitmap(car2,width,height,false);
        car3 = Bitmap.createScaledBitmap(car3,width,height,false);

        y=  (screenY-height)-(int)(64*screenRatioY);
        x= (screenX/2) - width/2;
    }
    Bitmap getCar(){
        if(carCounter==1) {
            carCounter++;
            return car1;
        }
        if(carCounter==2) {
            carCounter++;
            return car2;
        }
            carCounter=1;
            return car3;
    }
    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }
}
