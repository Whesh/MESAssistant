package com.whesh.mesassistant.core.controller;

import com.whesh.mesassistant.core.model.Employer;

import java.util.List;

public class BreathController {

    private List<Employer> employers;

    public BreathController (List<Employer> employers){
        this.employers = employers;
    }

    public int getMinVolumeBaloon(){
        int result = 350;
        for (Employer employer : employers){
            if (employer.getBaloon().getFullPressure() < result){
                result = employer.getBaloon().getFullPressure();
            }
        }
        return result;
    }

    public int getMaxConsume(){
        int result = 0;
        for (Employer employer :employers){
            if (employer.getInConsumption() > result){
                result = employer.getInConsumption();
            }
        }
        return result;
    }

    public int getOutAllertPressure(){
        return getMaxConsume() + 50;
    }

    public long getOutTimeout(){
        return (int) ((getMinVolumeBaloon() - (getMaxConsume() + getOutAllertPressure())) / 6);
    }

    public long getFullWorktime(){
        return (int)((getMinVolumeBaloon() - 50) / 6);
    }

}
