package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    void willNotPass(){
        Assert.assertTrue("this test will fail", false);
    }
}
