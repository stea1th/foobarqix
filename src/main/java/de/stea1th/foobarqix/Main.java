package de.stea1th.foobarqix;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String number = "51";
        RuleRegistry ruleRegistry = new RuleRegistry();
        StringHelper stringHelper = new StringHelper();
        List<Divider> dividers = ruleRegistry.getDividers();
        List<Replacer> replacers = ruleRegistry.getReplacers();
        StringBuilder stringBuilder = new StringBuilder();
        int num = stringHelper.convertToInt(number);
        String[] strings = stringHelper.convertToStringArray(number);

        for(Divider divider : dividers) {
            stringBuilder.append(divider.isDivisible(num) ? divider.getClass().getAnnotation(Rule.class).name() : "");
        }

        for(String string : strings) {
            for(Replacer replacer : replacers) {
                stringBuilder.append(replacer.isExists(string) ? replacer.getClass().getAnnotation(Rule.class).name() : "");
            }
        }

        String result = stringBuilder.toString();
        System.out.println(num + " -> " + (result.equals("") ? num : result));
    }
}
