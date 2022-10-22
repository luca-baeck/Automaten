package de.luca.baeck.java;

public interface Automat {

    boolean process(String input);

    boolean isEmpty();

    int getSize();

    boolean setStart(String name);

    boolean addToEnds(String name);

    boolean createState(String name);

    boolean addConnection(String startState, String endState, String condition);

    void removeStart();

    boolean removeEnd(String name);

    boolean removeState(String name);

    boolean removeConnection(String startState, String endState, String condition);

}
