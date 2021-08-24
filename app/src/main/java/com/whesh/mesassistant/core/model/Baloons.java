package com.whesh.mesassistant.core.model;

public class Baloons implements Baloon {

    private int fullPressure;
    private int nominalPressure;

    public Baloons (int fullPressure){
        if (fullPressure > maxPressure){
            throw new IllegalArgumentException("Max pressure is reached");
        } else if (fullPressure < minPressure) {
            throw new IllegalArgumentException("Empty baloon");
        }
        this.fullPressure = fullPressure;
        this.nominalPressure = fullPressure;
    }

    public void setNominalPressure(int nominalPressure){
        if (nominalPressure > maxPressure){
            throw new IllegalArgumentException("Max pressure is reached");
        } else if (nominalPressure < minPressure) {
            throw new IllegalArgumentException("Empty baloon");
        } else if (nominalPressure > fullPressure){
            throw new IllegalArgumentException("Ты пока бежал в балон надышал?");
        }
        this.nominalPressure = nominalPressure;
    }

    public int getFullPressure() {
        return fullPressure;
    }

    public int getNominalPressure(){
        return nominalPressure;
    }

    public int getConsumption(){
        return fullPressure - nominalPressure;
    }

}
