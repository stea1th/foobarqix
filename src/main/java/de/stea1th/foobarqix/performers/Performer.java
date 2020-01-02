package de.stea1th.foobarqix.performers;

import de.stea1th.foobarqix.helper.StringHelper;
import de.stea1th.foobarqix.rules.Divider;
import de.stea1th.foobarqix.rules.Replacer;
import de.stea1th.foobarqix.rules.registry.RuleRegistry;

import java.util.List;

public class Performer {

    private RuleRegistry ruleRegistry;

    private StringBuilder stringBuilder;

    private StringHelper stringHelper;

    public Performer(RuleRegistry ruleRegistry) {
        this.ruleRegistry = ruleRegistry;
        this.stringBuilder = new StringBuilder();
        this.stringHelper = new StringHelper();
    }

    public String compute(String num) {
        checkIfDivisible(num);
        checkIfNumberExists(num);
        String result = stringBuilder.toString();
        return result.equals("") ? num : result;
    }

    private void checkIfDivisible(String num) {
        int number = stringHelper.convertToInt(num);
        List<Divider> dividers = ruleRegistry.getDividers();
        for (Divider divider : dividers) {
            stringBuilder.append(divider.isDivisible(number) ? divider.getDividerName() : "");
        }
    }

    private void checkIfNumberExists(String num) {
        String[] strings = stringHelper.convertToStringArray(num);
        List<Replacer> replacers = ruleRegistry.getReplacers();
        for (String string : strings) {
            for (Replacer replacer : replacers) {
                stringBuilder.append(replacer.isExists(string) ? replacer.getReplacerName() : "");
            }
        }
    }
}
