package com.company;

public class Car {
    private int initialSpeed;
    private int initialDistance;
    private int posAcceleration;
    private int negAcceleration;

    public Car(int initialSpeed, int posAcceleration, int negAcceleration, int initialDistance) {
        this.initialSpeed = initialSpeed;
        this.initialDistance = initialDistance;
        this.posAcceleration = posAcceleration;
        this.negAcceleration = negAcceleration;
    }

    public boolean check(Road road) {
        int lightDuration = road.getLightDuration();
        int intersectionWidth = road.getIntersectionWidth();
        double v1 = initialSpeed * 1000 / 3600;
        if (lightDuration * v1 >= initialDistance + intersectionWidth) {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " Car does not need to accelerate, it will pass");
            return true;
        } else if (lightDuration * v1 + posAcceleration * lightDuration * lightDuration / 2 >= initialDistance + intersectionWidth) {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " Car needs to accelerate, it will pass");
            return true;
        } else if (lightDuration * v1 - negAcceleration * lightDuration * lightDuration / 2 <= initialDistance) {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " Car needs to stop, it will not pass");
            return false;
        } else {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " No solution can be suggested, it is very late");
            return false;
        }
    }

    public boolean checkFor50to100(Road road){
        double v = initialSpeed*1000/3600;
        double vMax = 100*1000/3600;
        double vMin = 50*1000/3600;
        int lightDuration = road.getLightDuration();
        int intersectionWidth = road.getIntersectionWidth();

        if(lightDuration*v >= initialDistance+intersectionWidth && vMin < v && v < vMax)
        {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " Car does not need to accelerate. it will pass");
            return true;
        }
        else if (lightDuration*v + posAcceleration*lightDuration*lightDuration/2 >= initialDistance+intersectionWidth && vMin < v+posAcceleration*lightDuration/2 && v+posAcceleration*lightDuration/2 < vMax)
        {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " Car needs to accelerate. it will pass");
            return true;
        }
        else if (lightDuration*v - negAcceleration*lightDuration*lightDuration/2 <= initialDistance)
        {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " Car needs to stop, it will not pass");
            return false;
        } else
        {
            System.out.println("For values v0:" + initialSpeed + " x0:" + initialDistance + " t:" + lightDuration + " s:" + intersectionWidth + " ap:" + posAcceleration + " na:" + negAcceleration + " No solution can be suggested, it is very late");
            return false;
        }
    }

    public void twoCarsCheck(Car car2, Road road) {
        double v1 = initialSpeed * 1000 / 3600;
        double v2 = car2.initialSpeed * 1000 / 3600;
        int t = road.getLightDuration();
        int s = road.getIntersectionWidth();
        int an1 = negAcceleration;
        int ap1 = posAcceleration;
        int an2 = car2.negAcceleration;
        int ap2 = car2.posAcceleration;
        int x0 = initialDistance;
        int d = car2.initialDistance - initialDistance;

        if (t * v1 >= x0 + s) {
            if (t * v2 >= d + x0 + s && t * v2 < t * v1 + d)
                System.out.println("Both cars do not need to accelerate, They will pass.");
            else if (t * v2 - an2 * t * t / 2 <= d + x0 && t * v2 - an2 * t * t / 2 < t * v1 + d)
                System.out.println("First car does not need to accelerate, it will pass. Second car needs to stop, it will not pass.");
            else if (t * v2 + ap2 * t * t / 2 >= d + x0 + s && t * v2 + ap2 * t * t / 2 < t * v1 + d)
                System.out.println("First car does not need to accelerate, it will pass. Second car needs to accelerate, it will pass.");
            else
                System.out.println("No solution can be suggested.");
        } else if (t * v1 + ap1 * t * t / 2 >= x0 + s) {
            if (t * v2 >= d + x0 + s && t * v2 < t * v1 + ap1 * t * t / 2 + d)
                System.out.println("First car needs to accelerate, it will pass. Second car does not need to accelerate, it will pass.");
            else if (t * v2 - an2 * t * t / 2 <= d + x0 && t * v2 - an2 * t * t / 2 < t * v1 + ap1 * t * t / 2 + d)
                System.out.println("First car needs to accelerate, it will pass. Second car needs to stop, it will not pass.");
            else if (t * v2 + ap2 * t * t / 2 >= d + x0 + s && t * v2 + ap2 * t * t / 2 < t * v1 + ap1 * t * t / 2 + d)
                System.out.println("First car needs accelerate, it will pass. Second car needs to accelerate, it will pass.");
            else
                System.out.println("No solution can be suggested.");
        } else if (t * v1 - an1 * t * t / 2 <= x0) {
            if (t * v2 - an2 * t * t / 2 <= d + x0 && t * v2 - an2 * t * t / 2 < t * v1 - an1 * t * t / 2 + d)
                System.out.println("Both cars need to stop, they will not pass.");
            else
                System.out.println("No solution can be suggested.");
        }
    }

    public int getPosAcceleration() {
        return posAcceleration;
    }

    public void setPosAcceleration(int posAcceleration) {
        this.posAcceleration = posAcceleration;
    }

    public int getNegAcceleration() {
        return negAcceleration;
    }

    public void setNegAcceleration(int negAcceleration) {
        this.negAcceleration = negAcceleration;
    }

    public int getInitialSpeed() {
        return initialSpeed;
    }

    public int getInitialDistance() {
        return initialDistance;
    }

    public void setInitialDistance(int initialDistance) {
        this.initialDistance = initialDistance;
    }

    public void setInitialSpeed(int initialSpeed) {
        this.initialSpeed = initialSpeed;
    }
}
