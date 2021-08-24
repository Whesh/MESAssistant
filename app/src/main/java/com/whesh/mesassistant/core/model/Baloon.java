package com.whesh.mesassistant.core.model;

public interface Baloon {

    int maxPressure = 310;
    int minPressure = 50;

    void setNominalPressure(int nominalPressure);
    int getConsumption();

    int getFullPressure();
    int getNominalPressure();
}
