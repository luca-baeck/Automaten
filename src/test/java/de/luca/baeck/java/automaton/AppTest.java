package de.luca.baeck.java.automaton;

import de.luca.baeck.java.automaton.Class.deterministic.DeterministicFiniteAutomaton;
import de.luca.baeck.java.automaton.Class.deterministic.DeterministicFiniteStateMachine;
import de.luca.baeck.java.automaton.Class.deterministic.DeterministicMealyMachine;
import de.luca.baeck.java.automaton.Class.deterministic.DeterministicMooreMachine;

public class AppTest 
{
    public static void main(String[] args) throws Exception{

        DeterministicFiniteStateMachine sm = new DeterministicFiniteStateMachine();
        sm.addState("1");
        sm.addState("2");
        sm.addState("3");
        sm.addState("1");

        sm.setStartState("1");

        sm.addTransition("1", "2", 'a');
        sm.addTransition("1", "2", 'b');
        sm.addTransition("2", "3", 'c');

        System.out.println(sm.process("a"));

        DeterministicFiniteAutomaton fm = new DeterministicFiniteAutomaton();
        fm.addState("1");
        fm.addState("2");
        fm.addState("3");
        fm.addState("1");

        fm.setStartState("1");

        fm.addFinalState("1");
        fm.addFinalState("3");

        fm.addTransition("1", "2", 'a');
        fm.addTransition("1", "2", 'b');
        fm.addTransition("2", "3", 'c');

        System.out.println(fm.check("a"));
        System.out.println(fm.check("bc"));

        DeterministicMealyMachine me = new DeterministicMealyMachine();
        me.addState("1");
        me.addState("2");
        me.addState("3");
        me.addState("1");

        me.setStartState("1");

        me.addFinalState("2");
        me.addFinalState("3");

        me.addTransition("1", "2", 'a', 'p');
        me.addTransition("1", "2", 'b', 'l');
        me.addTransition("2", "3", 'c', 'm');

        System.out.println(me.transduce("a"));
        System.out.println(me.transduce("b"));
        System.out.println(me.transduce("bc"));

        DeterministicMooreMachine mo = new DeterministicMooreMachine();
        mo.addState("1", 'p');
        mo.addState("2", 'l');
        mo.addState("3", 'm');
        mo.addState("1", 'h');

        mo.setStartState("1");

        mo.addFinalState("2");
        mo.addFinalState("3");

        mo.addTransition("1", "2", 'a');
        mo.addTransition("1", "2", 'b');
        mo.addTransition("2", "3", 'c');

        System.out.println(mo.transduce("a"));
        System.out.println(mo.transduce("b"));
        System.out.println(mo.transduce("bc"));
        
    }
}
