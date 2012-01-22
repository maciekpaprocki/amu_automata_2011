
package pl.edu.amu.wmi.daut.re;

import java.util.ArrayList;
import pl.edu.amu.wmi.daut.base.NondeterministicAutomatonByThompsonApproach;
import junit.framework.TestCase;
import pl.edu.amu.wmi.daut.re.AnyCharOperator.Factory;

/**
 * Test klasy AnycharOperator.
 */
public class TestAnyCharOperator extends TestsCase {
/**
* Test konstruktora AnyCharOperator.
*/
        public void testAnyCharOperator() {
        AnyCharOperator operator = new AnyCharOperator();
    }
/**
* Testuje automat.
*/
public final void testcreateFixedAutomaton() {

        AnyCharOperator spec2 = new AnyCharOperator();
        NondeterministicAutomatonByThompsonApproach automaton2 =
                new NondeterministicAutomatonByThompsonApproach(spec2.createFixedAutomaton());

        assertFalse(automaton2.accepts("ala"));
        assertTrue(automaton2.accepts("m"));
        assertTrue(automaton2.accepts("a"));
        assertFalse(automaton2.accepts("kota"));
        assertFalse(automaton2.accepts("kot"));
        assertFalse(automaton2.accepts("ma"));
        assertFalse(automaton2.accepts("ale"));
        assertTrue(automaton2.accepts("l"));
        assertTrue(automaton2.accepts("k"));
    }

    /**
     * Test fabryki.
     */
    public final void testFactory() {
        Factory factory = new Factory();
        ArrayList<Char> params = new ArrayList<Char>();
        assertEquals(factory.createOperator(params).getClass(),
                new AnyCharOperator().getClass());
    }

}
