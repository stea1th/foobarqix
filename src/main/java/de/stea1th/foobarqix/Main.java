package de.stea1th.foobarqix;

import de.stea1th.foobarqix.helper.StringHelper;
import de.stea1th.foobarqix.rules.registry.RuleRegistry;
import de.stea1th.foobarqix.rules.Divider;
import de.stea1th.foobarqix.rules.Replacer;

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
            stringBuilder.append(divider.isDivisible(num) ? divider.getDividerName() : "");
        }

        for(String string : strings) {
            for(Replacer replacer : replacers) {
                stringBuilder.append(replacer.isExists(string) ? replacer.getReplacerName() : "");
            }
        }

        String result = stringBuilder.toString();
        System.out.println(num + " -> " + (result.equals("") ? num : result));
    }
}
