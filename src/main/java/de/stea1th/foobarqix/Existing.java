package de.stea1th.foobarqix;

public interface Existing {

    default boolean isExists(String s) {
        return String.valueOf(this.getClass().getAnnotation(Rule.class).value()).equals(s);
    }

}
