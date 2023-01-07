package de.luca.baeck.java.automaton.Interface;

import de.luca.baeck.java.automaton.State.State;

public interface Automaton {

    public void addState(String name) throws Exception;

    public State getState(String name);

    public boolean isEmpty();

    public void addFinalState(String name);

    public void addFinalState(State state);

    public void setStartState(String name);

    public void setStartState(State state);

    public void addTransition(String origin, String target, char condition) throws Exception;

    public void addTransition(State origin, State target, char condition) throws Exception;

}
