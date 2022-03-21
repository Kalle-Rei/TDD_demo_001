package se.kalle;

public class Calculator {

    public static int add(final String numbers){
        int returnValue = 0;
        String[] numbersArray = numbers.split(",");
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number); // if it is not a number parseInt will throw an exception
            }
        }
        return returnValue;
    }
}
