package de.stea1th.foobarqix;

import de.stea1th.foobarqix.performers.Performer;
import de.stea1th.foobarqix.printers.Printer;
import de.stea1th.foobarqix.rules.registry.RuleRegistry;

public class Main {

    public static void main(String[] args) {
        String number = "51";
        Printer printer = new Printer(number);
        RuleRegistry ruleRegistry = new RuleRegistry();
        Performer performer = new Performer(ruleRegistry);
        String result = performer.compute(number);
        printer.print(result);
    }
}
