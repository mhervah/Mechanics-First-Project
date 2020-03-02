package com.company;

public class Road {
    private int lightDuration;
    private int intersectionWidth;

    public Road(int lightDuration, int intersectionWidth)
    {
        this.intersectionWidth = intersectionWidth;
        this.lightDuration = lightDuration;
    }

    public int getLightDuration() {
        return lightDuration;
    }

    public void setLightDuration(int lightDuration) {
        this.lightDuration = lightDuration;
    }

    public int getIntersectionWidth() {
        return intersectionWidth;
    }

    public void setIntersectionWidth(int intersectionWidth) {
        this.intersectionWidth = intersectionWidth;
    }
}
