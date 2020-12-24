package com.example.trafficracer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.trafficracer.GameView.screenRatioX;
import static com.example.trafficracer.GameView.screenRatioY;

public class TrafficCars {
    int width,heigth;
    int x=0,y,speed=15;
    int width_audi,heigth_audi,width_ambu,heigth_ambu,width_taxi,heigth_taxi,w_black,h_black,w_van,h_van;
    int w_truck,h_truck,w_miniTruck,h_miniTruck,w_redcar,h_redcar,w_police,h_police;
    Bitmap ambulance,audi,blackViper,van,truck,miniTruck,redCar,taxi,police;
    TrafficCars(int screenX, int screenY, Resources res){
        ambulance = BitmapFactory.decodeResource(res,R.drawable.ambulance);
        audi = BitmapFactory.decodeResource(res,R.drawable.audi);
        blackViper = BitmapFactory.decodeResource(res,R.drawable.black);
        van = BitmapFactory.decodeResource(res,R.drawable.mini_van);
        truck = BitmapFactory.decodeResource(res,R.drawable.truck);
        miniTruck = BitmapFactory.decodeResource(res,R.drawable.mini_truck);
        redCar = BitmapFactory.decodeResource(res,R.drawable.car1);
        taxi = BitmapFactory.decodeResource(res,R.drawable.taxi);
        police = BitmapFactory.decodeResource(res,R.drawable.maincar2);

        generateWidthAndHeigth();

        ambulance = Bitmap.createScaledBitmap(ambulance,width_ambu,heigth_ambu,false);
        audi = Bitmap.createScaledBitmap(audi,width_audi,heigth_audi,false);
        blackViper = Bitmap.createScaledBitmap(blackViper,w_black,h_black,false);
        van = Bitmap.createScaledBitmap(van,w_van,h_van,false);
        truck = Bitmap.createScaledBitmap(truck,w_truck,h_truck,false);
        miniTruck = Bitmap.createScaledBitmap(miniTruck,w_miniTruck,h_miniTruck,false);
        redCar = Bitmap.createScaledBitmap(redCar,w_redcar,h_redcar,false);
        taxi = Bitmap.createScaledBitmap(taxi,width_taxi,heigth_taxi,false);
        police = Bitmap.createScaledBitmap(police,w_police,h_police,false);

    }

    private void generateWidthAndHeigth() {
        width_ambu=ambulance.getWidth();
        heigth_ambu=ambulance.getHeight();
        width_ambu /=2;
        heigth_ambu/=2;
        width_ambu -=15*screenRatioX;
        heigth_ambu -=36*screenRatioY;
        width_ambu *=screenRatioX;
        heigth_ambu *=screenRatioY;

        width_audi=audi.getWidth();
        heigth_audi=audi.getHeight();
        width_audi /=2;
        heigth_audi/=2;
        width_audi -=15*screenRatioX;
        heigth_audi -=36*screenRatioY;
        width_audi *=screenRatioX;
        heigth_audi *=screenRatioY;

        width_taxi=taxi.getWidth();
        heigth_taxi=taxi.getHeight();
        width_taxi /=2;
        heigth_taxi/=2;
        width_taxi -=15*screenRatioX;
        heigth_taxi -=36*screenRatioY;
        width_taxi *=screenRatioX;
        heigth_taxi *=screenRatioY;

        w_black=blackViper.getWidth();
        h_black=blackViper.getHeight();
        w_black /=2;
        h_black/=2;
        w_black -=15*screenRatioX;
        h_black -=36*screenRatioY;
        w_black *=screenRatioX;
        h_black *=screenRatioY;

        w_van=van.getWidth();
        h_van=van.getHeight();
        w_van /=2;
        h_van/=2;
        w_van -=15*screenRatioX;
        h_van -=36*screenRatioY;
        w_van *=screenRatioX;
        h_van *=screenRatioY;

        w_truck=truck.getWidth();
        h_truck=truck.getHeight();
        w_truck /=2;
        h_truck/=2;
        w_truck -=15*screenRatioX;
        h_truck -=36*screenRatioY;
        w_truck *=screenRatioX;
        h_truck *=screenRatioY;

        w_miniTruck=miniTruck.getWidth();
        h_miniTruck=miniTruck.getHeight();
        w_miniTruck /=2;
        h_miniTruck/=2;
        w_miniTruck -=15*screenRatioX;
        h_miniTruck -=36*screenRatioY;
        w_miniTruck *=screenRatioX;
        h_miniTruck *=screenRatioY;

        w_redcar=redCar.getWidth();
        h_redcar=redCar.getHeight();
        w_redcar /=2;
        h_redcar/=2;
        w_redcar -=15*screenRatioX;
        h_redcar -=36*screenRatioY;
        w_redcar *=screenRatioX;
        h_redcar *=screenRatioY;

        w_police=police.getWidth();
        h_police=police.getHeight();
        w_police /=2;
        h_police/=2;
        w_police -=15*screenRatioX;
        h_police -=36*screenRatioY;
        w_police *=screenRatioX;
        h_police *=screenRatioY;
    }
    Bitmap createParticularCar(int id){
        switch (id){
            case 1:
                return ambulance;
            case 2:
                return audi;
            case 3:
                return blackViper;
            case 4:
                return van;
            case 5:
                return truck;
            case 6:
                return miniTruck;
            case 7:
                return redCar;
            case 8:
                return taxi;
            case 9:
                return police;
            default:
                return redCar;
        }
    }

    public int getWidth(int id) {
        switch (id) {
            case 1:
                return width_ambu;
            case 2:
                return width_audi;
            case 3:
                return w_black;
            case 4:
                return w_van;
            case 5:
                return w_truck;
            case 6:
                return w_miniTruck;
            case 7:
                return w_redcar;
            case 8:
                return width_taxi;
            case 9:
                return w_police;
            default:
                return w_redcar;
        }
    }
    public int getHeight(int id) {
        switch (id) {
            case 1:
                return heigth_ambu;
            case 2:
                return heigth_audi;
            case 3:
                return h_black;
            case 4:
                return h_van;
            case 5:
                return h_truck;
            case 6:
                return h_miniTruck;
            case 7:
                return h_redcar;
            case 8:
                return heigth_taxi;
            case 9:
                return h_police;
            default:
                return h_redcar;
        }
    }
}
