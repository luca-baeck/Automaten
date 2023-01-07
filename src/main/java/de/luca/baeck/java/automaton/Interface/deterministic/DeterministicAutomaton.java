package de.luca.baeck.java.automaton.Interface.deterministic;

import de.luca.baeck.java.automaton.State.State;

public interface DeterministicAutomaton {
    
    public void addTransition(State origin, State target, char condition);

}
