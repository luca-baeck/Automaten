package de.luca.baeck.java.automaton.Transition;

import de.luca.baeck.java.automaton.State.State;

public class MealyTransition extends AbstractTransition {

    private char output;
    
    public MealyTransition(State origin, State target, char condition, char output) {
        super(origin, target, condition);
        this.output = output;
    }

    public char getOutput() {
        return output;
    }

}
