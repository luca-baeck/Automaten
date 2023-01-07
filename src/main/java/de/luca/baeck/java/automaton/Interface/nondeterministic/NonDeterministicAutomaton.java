package de.luca.baeck.java.automaton.Interface.nondeterministic;

import de.luca.baeck.java.automaton.State.State;

public interface NonDeterministicAutomaton {
    
    public void addTransition(State origin, State target, char condition);

}
