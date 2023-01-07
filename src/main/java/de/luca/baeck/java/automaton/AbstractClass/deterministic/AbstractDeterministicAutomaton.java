package de.luca.baeck.java.automaton.AbstractClass.deterministic;

import java.util.ArrayList;
import java.util.List;

import de.luca.baeck.java.automaton.AbstractClass.AbstractAutomaton;
import de.luca.baeck.java.automaton.Class.deterministic.DeterministicMealyMachine;
import de.luca.baeck.java.automaton.Interface.deterministic.DeterministicAutomaton;
import de.luca.baeck.java.automaton.State.State;
import de.luca.baeck.java.automaton.Transition.BasicTransition;
import de.luca.baeck.java.automaton.Transition.Transition;

public abstract class AbstractDeterministicAutomaton extends AbstractAutomaton implements DeterministicAutomaton {

    protected AbstractDeterministicAutomaton() {
        super();
    }

    public void addTransition(State origin, State target, char condition) {
        if(this instanceof DeterministicMealyMachine){
            throw new RuntimeException ("Automaton is instance of MealyMachine");
        }
        List<Transition> transitionsFromState = transitions.get(origin);
        if(transitionsFromState != null){
            for (Transition trans : transitionsFromState) {
                if(trans.getCondition() == condition) {
                    return;
                }
            }
        }else{
            transitionsFromState = new ArrayList<Transition>();
        }
        Transition newTransition = new BasicTransition(origin, target, condition);
        transitionsFromState.add(newTransition);
        transitions.put(origin, transitionsFromState);
    }

}
