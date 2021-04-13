package com.example.unittesting;

public class MainViewModel {
    private final CuboidModel cuboidModel;

    public MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    public void save(double l, double w, double h){
        cuboidModel.save(l, w, h);
    }

    public double getCircumeference(){
        return cuboidModel.getCircumeference();
    }

    public double getVolume(){
        return cuboidModel.getVolume();
    }

    public double getSurfaceArea(){
        return cuboidModel.getSurfaceArea();
    }
}
