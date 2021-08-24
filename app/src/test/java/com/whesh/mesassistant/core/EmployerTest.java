package com.whesh.mesassistant.core;

import com.whesh.mesassistant.core.model.Baloon;
import com.whesh.mesassistant.core.model.Baloons;
import com.whesh.mesassistant.core.model.Employer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmployerTest {

    @Test
    public void creation_isCorrect(){
        Employer employer = new Employer(300);
        assertNotNull(employer);
    }

    @Test
    public void employer_isSetInPressure(){
        Employer employer = new Employer(300);
        employer.setInPressure(285);
        assertEquals(employer.getInConsumption(), 15);
    }

}
