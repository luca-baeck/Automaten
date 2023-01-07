package de.luca.baeck.java.automaton.AbstractClass.nondeterministic;

import java.util.List;

import de.luca.baeck.java.automaton.AbstractClass.AbstractAutomaton;
import de.luca.baeck.java.automaton.Class.nondeterministic.NonDeterministicMealyMachine;
import de.luca.baeck.java.automaton.Interface.nondeterministic.NonDeterministicAutomaton;
import de.luca.baeck.java.automaton.State.State;
import de.luca.baeck.java.automaton.Transition.BasicTransition;
import de.luca.baeck.java.automaton.Transition.Transition;

public abstract class AbstractNonDeterministicAutomaton extends AbstractAutomaton implements NonDeterministicAutomaton {
    
    protected AbstractNonDeterministicAutomaton() {
        super();
    }

    public void addTransition(State origin, State target, char condition) throws RuntimeException  {
        if(this instanceof NonDeterministicMealyMachine){
            throw new RuntimeException ("Automaton is instance of MealyMachine");
        }
        List<Transition> transitionsFromState = transitions.get(origin);
        for (Transition trans : transitionsFromState) {
            if(trans.getTargetState().getName().equals(target.getName()) && trans.getCondition() == condition) {
                return;
            }
        }
        Transition newTransition = new BasicTransition(origin, target, condition);
        transitionsFromState.add(newTransition);
        transitions.put(origin, transitionsFromState);
    }

    
}
