package de.luca.baeck.java.automaton.Class.deterministic;

import java.util.List;

import de.luca.baeck.java.automaton.AbstractClass.deterministic.AbstractDeterministicAcceptor;
import de.luca.baeck.java.automaton.State.State;
import de.luca.baeck.java.automaton.Transition.Transition;

public class DeterministicFiniteAutomaton extends AbstractDeterministicAcceptor {
    
    public DeterministicFiniteAutomaton() {
        super();
    }

    public boolean check(String input) {
        String buffer = input;
        State currentState = startState;
        while(!buffer.equals("")) {
            List<Transition> transitionsFromState = transitions.get(currentState);
            boolean check = false;
            if(transitionsFromState != null){
                for(Transition trans : transitionsFromState) {
                    if(trans.getCondition() == buffer.charAt(0)) {
                        currentState = trans.getTargetState();
                        buffer = buffer.substring(1, buffer.length());
                        check = true;
                        break;
                    }
                }
            }
            if(!check){
                return false;
            }
        }
        return endStates.contains(currentState);
    }

}
