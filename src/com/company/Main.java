package com.company;

import java.util.ArrayList;

public class Main {
    public static int aMin = 1;
    public static int aMax = 3;
    public static int vMin = 20;
    public static int vMax = 80;
    public static int initialDistanceMin = 10;
    public static int initialDistanceMax = 150;
    public static int lightDurationMin = 2;
    public static int lightDurationMax = 5;
    public static int widthMin = 5;
    public static int widthMax = 20;

    public static void main(String[] args) {
        automateTest();

        /*Car car1 = new Car(80, 2,3, 10);
        Car car2 = new Car(40, 2,1, 140);
        Road road = new Road(3, 15);
        car1.twoCarsCheck(car2, road);*/
    }

    public static void automateTest() {
        Road road;
        Car car;

        for (int v0 = vMin; v0 <= vMax; v0 += 20) {
            for (int x0 = initialDistanceMin; x0 <= initialDistanceMax; x0 += 20) {
                for (int t = lightDurationMin; t <= lightDurationMax; t++) {
                    for (int dS = widthMin; dS <= widthMax; dS += 5) {
                        for (int ap = aMin; ap <= aMax; ap++) {
                            for (int an = aMin; an <= aMax; an++) {
                                road = new Road(t,dS);
                                car = new Car(v0, ap, an, x0);
                                car.check(road);
                                //car.checkFor50to100(road);
                            }
                        }
                    }
                }
            }
        }
    }
}