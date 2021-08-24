package com.whesh.mesassistant.core;

import com.whesh.mesassistant.core.model.Baloon;
import com.whesh.mesassistant.core.model.Baloons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaloonsTest {

    @Test
    public void creation_isCorrect(){
        Baloon baloon = new Baloons(50);
        assertTrue(baloon != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void baloon_isOverload(){
        Baloon baloon = new Baloons(350);
    }

    @Test(expected = IllegalArgumentException.class)
    public void baloon_isEmpty(){
        Baloon baloon = new Baloons(-20);
    }

    @Test
    public void baloon_nominal_isSet(){
        Baloons baloon = new Baloons(300);
        baloon.setNominalPressure(270);
        assertEquals(baloon.getNominalPressure(), 270);
    }

    @Test
    public void baloon_consumption_isCorrect(){
        Baloons baloon = new Baloons(300);
        baloon.setNominalPressure(270);
        assertEquals(baloon.getConsumption(), 30);
    }
}
