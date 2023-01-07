package de.luca.baeck.java.automaton.Transition;

import de.luca.baeck.java.automaton.State.State;

public interface Transition {

    public State getOriginState();
    
    public State getTargetState();

    public char getCondition();

}
