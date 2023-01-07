package de.luca.baeck.java.automaton.State;

public class MooreState extends AbstractState {
    
    private char output;

    public MooreState(String name, char output) {
        super(name);
        this.output = output;
    }

    public char getOutput() {
        return output;
    }

}
