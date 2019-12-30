package de.stea1th.foobarqix;

public interface Divider {

    default boolean isDivisible(int x) {
        return x % this.getClass().getAnnotation(Rule.class).value() == 0;
    }
}
