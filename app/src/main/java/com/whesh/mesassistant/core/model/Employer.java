package com.whesh.mesassistant.core.model;

public class Employer {

    private Baloon baloon;

    public Employer (int baloonCapacityFull) throws IllegalArgumentException{
        this.baloon = new Baloons(baloonCapacityFull);
    }

    public void setInPressure(int inPressure){
        baloon.setNominalPressure(inPressure);
    }

    public int getInConsumption() {
        return baloon.getConsumption();
    }

    public Baloon getBaloon() {
        return baloon;
    }
}
