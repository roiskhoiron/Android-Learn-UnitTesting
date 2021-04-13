package com.example.unittesting;

public class CuboidModel {
    private double width;
    private double length;
    private double height;

    /*public CuboidModel() {
    }*/

    public void save(double length, double width, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double getVolume(){
        return width * length * height;
    }

    public double getSurfaceArea() {
        double wl = width * length;
        double wh = width * height;
        double lh = length * height;

        return 2 * (wl + wh + lh);
    }

    public double getCircumeference(){
        return 4 * (width + length + height);
    }
}
