package de.luca.baeck.java.automaton.Interface;

public interface Acceptor extends Automaton {
    
    public boolean check(String input);

}
