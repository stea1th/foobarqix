package de.stea1th.foobarqix;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class RuleRegistry {

    private Set<Class<?>> registry;

    public RuleRegistry() {
        initRegistry();
    }

    private void initRegistry() {
        Reflections reflections = new Reflections("de.stea1th.foobarqix", new TypeAnnotationsScanner(), new SubTypesScanner());

        registry = reflections.getTypesAnnotatedWith(Rule.class);
    }

    public List<Divider> getDividers() {
        return registry
                .stream()
                .filter(c -> Arrays.asList(c.getInterfaces()).contains(Divider.class))
                .sorted(Comparator.comparing(s-> s.getAnnotation(Rule.class).value()))
                .map(s -> {
                    try {
                        return (Divider) s.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    throw new IllegalArgumentException("Not possible to create an instance");
                }).collect(Collectors.toList());
    }

    public List<Replacer> getReplacers() {
        return registry
                .stream()
                .filter(c -> Arrays.asList(c.getInterfaces()).contains(Replacer.class))
                .sorted(Comparator.comparing(s-> s.getAnnotation(Rule.class).value()))
                .map(s -> {
                    try {
                        return (Replacer) s.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    throw new IllegalArgumentException("Not possible to create an instance");
                }).collect(Collectors.toList());
    }

}
