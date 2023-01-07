package de.luca.baeck.java.automaton.Transition;

import de.luca.baeck.java.automaton.State.State;

public abstract class AbstractTransition implements Transition {
    
    private State originState;
    private State targetState;
    private char condition;

    AbstractTransition(State origin, State target, char condition) {
        this.originState = origin;
        this.targetState = target;
        this.condition = condition;
    }

    public State getOriginState() {
        return originState;
    }

    public State getTargetState() {
        return targetState;
    }

    public char getCondition() {
        return condition;
    }


}
