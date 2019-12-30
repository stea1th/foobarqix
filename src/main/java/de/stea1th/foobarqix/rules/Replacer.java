package de.stea1th.foobarqix.rules;

public interface Replacer {

    default boolean isExists(String s) {
        return String.valueOf(this.getClass().getAnnotation(Rule.class).value()).equals(s);
    }

    default String getReplacerName() {
        return this.getClass().getAnnotation(Rule.class).name();
    }
}
