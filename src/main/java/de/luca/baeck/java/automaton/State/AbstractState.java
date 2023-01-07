package de.luca.baeck.java.automaton.State;

public abstract class AbstractState implements State {

    private String name;

    public AbstractState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
