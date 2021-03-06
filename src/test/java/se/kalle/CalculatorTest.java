package se.kalle;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public final void whenDelimitersOfAnyLengthAreUsedThenTheyAreTreatedTheSameAsDelimitersOfAnyOtherLength(){
        Assert.assertEquals(3+6+15, Calculator.add("//[—]\n3—6—15")); //Will not work because regex expressions are like magic
    }

    @Test
    public final void when1OrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum(){
        Assert.assertEquals(3+1000+6, Calculator.add("3,1000,1001,6,1234"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown(){
        Calculator.add("3,-6,15,18,46,33");
    }
    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown(){
        RuntimeException exception = null;
        try {
            Calculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e){
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums(){
        Assert.assertEquals(3+6+15, Calculator.add("3,6n15"));
    }

    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers(){
        Assert.assertEquals(3+6+15, Calculator.add("//;n3;6;15"));
    }

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
