package de.stea1th.foobarqix.helper;

public class StringHelper {

    public int convertToInt(String num) {
        int result;
        try {
            result = Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("It is not a number");
        }
        return result;
    }

    public String[] convertToStringArray(String num) {
        return num.split("");
    }

}
