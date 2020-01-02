package de.stea1th.foobarqix.printers;

public class Printer {

    private String number;

    public Printer(String number) {
        this.number = number;
    }

    public void print(String result) {
        System.out.println(number + " -> " + result);
    }
}
