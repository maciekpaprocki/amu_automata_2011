package pl.edu.amu.wmi.daut.re;

import java.util.List;

/**
 * @author dyskograf Klasa przechowująca narzędzia do obsługi gramatyk..
 */
public class GrammarUtils {

    /**
     * Metoda sprawdzająca, czy podana gramatyka jest w postaci normalnej
     * Chomsky'ego.
     */
    public boolean isChomsky(Grammar g) {

        List<GrammarRule> rules = g.allRules();

        for (GrammarRule rule : rules) {
            if (rule.getArity() > 2
                    || rule.getArity() == 0
                    || rule.getRhsSecondSymbol().isTerminalSymbol()
                    || (rule.getRhsFirstSymbol().isTerminalSymbol()
                            && !(rule.getRhsSecondSymbol().isTerminalSymbol()))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Główna metoda klasy.
     */
    public boolean isLinear(Grammar g) {
        for (GrammarRule rule : g.allRules()) {

            int terminalSymbols = 0;

            for (GrammarSymbol symbol : rule.getRhsSymbols())
                if (symbol.isTerminalSymbol())
                    terminalSymbols++;

            if (terminalSymbols > 1)
                return false;
        }
        return true;
    }


    public boolean isRightLinear(Grammar g){
        List<GrammarRule> rules = g.allRules();
        for (GrammarRule rule : rules) {
            int i = 1;
            int arity = rule.getArity();
            for (GrammarSymbol symbol : rule.getRhsSymbols()) {
                if ((symbol.isTerminalSymbol()) && !(i == arity)) {
                    return false;
                }
                if (!(symbol.isTerminalSymbol()) && (i == arity)) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public boolean isLeftLinear(Grammar g){
        List<GrammarRule> rules = g.allRules();
        for (GrammarRule rule : rules) {
            if ((rule.getRhsFirstSymbol().isTerminalSymbol())) {
                int terminalSymbols = 0;
                for (GrammarSymbol symbol : rule.getRhsSymbols()) {
                    if (symbol.isTerminalSymbol()) {
                        terminalSymbols++;
                    }
                }
                    if (terminalSymbols > 1) {
                        return false;
                    }
            } else {
                return false;
            }
        }
        return true;
    }
}

