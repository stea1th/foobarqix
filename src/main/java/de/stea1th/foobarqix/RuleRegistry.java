package de.stea1th.foobarqix;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
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

    public Map<Integer, Divisible> getDividers() {
        return registry
                .stream()
                .filter(c -> Arrays.asList(c.getInterfaces()).contains(Divisible.class))
                .collect(Collectors.toMap(s -> s.getAnnotation(Rule.class).value(), s -> {
                    try {
                        return (Divisible) s.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    throw new IllegalArgumentException("Not possible to create an instance");
                }));
    }

    public Map<Integer, Existing> getReplacers() {
        return registry
                .stream()
                .filter(c -> Arrays.asList(c.getInterfaces()).contains(Divisible.class))
                .collect(Collectors.toMap(s -> s.getAnnotation(Rule.class).value(), s -> {
                    try {
                        return (Existing) s.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    throw new IllegalArgumentException("Not possible to create an instance");
                }));
    }

}
