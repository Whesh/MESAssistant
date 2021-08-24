package com.whesh.mesassistant.core;

import com.whesh.mesassistant.core.controller.BreathController;
import com.whesh.mesassistant.core.model.Employer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

public class BreathControllerTest {

    List<Employer> employers;
    BreathController breathController;

    {
        employers = new ArrayList<>();
        Employer employer1 = new Employer(300);
        Employer employer2 = new Employer(290);
        Employer employer3 = new Employer(285);
        employer1.setInPressure(280);
        employer2.setInPressure(265);
        employer3.setInPressure(270);
        employers.add(employer1);
        employers.add(employer2);
        employers.add(employer3);
        breathController = new BreathController(employers);
    }

    @Test
    public void breathController_isCreate(){
        assertNotNull(breathController);
    }

    @Test
    public void breathController_minBaloonVolumeNotNull(){
        assertNotEquals(breathController.getMinVolumeBaloon(), 0);
    }

    @Test
    public void breathController_isBaloonVolumeCorrect(){
        assertEquals(breathController.getMinVolumeBaloon(), 285);
    }

    @Test(expected = IllegalArgumentException.class)
    public void breathController_isBaloonVolumeOutOfMaxRange(){
        List<Employer> employers = new ArrayList<>();
        employers.add(new Employer(400));
        employers.add(new Employer(390));
        employers.add(new Employer(385));
        BreathController breathController1 = new BreathController(employers);
        assertNotEquals(breathController1.getMinVolumeBaloon(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void breathController_isBaloonVolumeOutOfMinRange(){
        List<Employer> employers = new ArrayList<>();
        employers.add(new Employer(15));
        employers.add(new Employer(-25));
        employers.add(new Employer(0));
        BreathController breathController1 = new BreathController(employers);
        assertNotEquals(breathController1.getMinVolumeBaloon(), 0);
    }

    @Test
    public void breathController_maxConsumeNotNull(){
        assertNotEquals(breathController.getMaxConsume(), 0);
    }

    @Test
    public void breathController_isMaxConsumeCorrect(){
        assertEquals(breathController.getMaxConsume(), 25);
    }

    @Test
    public void breathController_outAlertPressureNotNull(){
        assertNotEquals(breathController.getOutAllertPressure(), 0);
    }

    @Test
    public void breathController_isAlertPressureCorrect(){
        assertEquals(breathController.getOutAllertPressure(), 75);
    }

    @Test (expected = IllegalArgumentException.class)
    public void breathController_isBaloonVolumeAlertPressureCorrect(){
        Employer employer = new Employer(70);
        employer.setInPressure(45);
        assertEquals(breathController.getOutAllertPressure(), 75);
    }

    @Test (expected = IllegalArgumentException.class)
    public void breathController_isBaloonVolumeOverBreathAlertPressureCorrect(){
        Employer employer = new Employer(300);
        employer.setInPressure(305);
        assertEquals(breathController.getOutAllertPressure(), 75);
    }

    @Test (expected = IllegalArgumentException.class)
    public void breathController_isBaloonVolumeOverloadAlertPressureCorrect(){
        Employer employer = new Employer(300);
        employer.setInPressure(315);
        assertEquals(breathController.getOutAllertPressure(), 75);
    }

    @Test
    public void breathController_outTimeoutNotNull(){
        assertNotEquals(breathController.getOutTimeout(), 0);
    }

    @Test
    public void breathController_isOutTimeoutCorrect(){
        assertEquals(breathController.getOutTimeout(), 30);
    }

    @Test
    public void breathController_fullWorktimeNotNull(){
        assertNotEquals(breathController.getFullWorktime(), 0);
    }

    @Test
    public void breathController_isFullWortimeCorrect(){
        assertEquals(breathController.getFullWorktime(), 39);
    }
}
