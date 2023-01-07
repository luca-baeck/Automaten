package de.luca.baeck.java.automaton.Transition;

import de.luca.baeck.java.automaton.State.State;

public class BasicTransition extends AbstractTransition {

    public BasicTransition(State origin, State target, char condition) {
        super(origin, target, condition);
    }
    
}
