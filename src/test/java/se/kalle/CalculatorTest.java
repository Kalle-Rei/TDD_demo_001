package se.kalle;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

//    @Test(expected = RuntimeException.class)
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown(){
//        Calculator.add("1,2,3");
//    }
    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesIsTheirSums(){
        Assert.assertEquals(3+6+15+18+46+33, Calculator.add("3,6,15,18,46,33"));
    }
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown(){
        Calculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown(){
        Calculator.add("1,X");
    }
    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0(){
        Assert.assertEquals(0, Calculator.add(""));
    }
    @Test
    public final void when1NumberIsUsedThenReturnValueIsThatSameNumber(){
        Assert.assertEquals(3, Calculator.add("3"));
    }
    @Test
    public final void when2NumbersAreUsedThenReturnValueIsTheirSum(){
        Assert.assertEquals(3+6, Calculator.add("3,6"));
    }
}
