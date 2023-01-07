package de.luca.baeck.java.automaton.AbstractClass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.luca.baeck.java.automaton.Class.deterministic.DeterministicMealyMachine;
import de.luca.baeck.java.automaton.Class.deterministic.DeterministicMooreMachine;
import de.luca.baeck.java.automaton.Class.nondeterministic.NonDeterministicMealyMachine;
import de.luca.baeck.java.automaton.Class.nondeterministic.NonDeterministicMooreMachine;
import de.luca.baeck.java.automaton.Interface.Automaton;
import de.luca.baeck.java.automaton.State.BasicState;
import de.luca.baeck.java.automaton.State.State;
import de.luca.baeck.java.automaton.Transition.Transition;

public abstract class AbstractAutomaton implements Automaton {

    protected State startState;
    protected Map<String, State> states;
    protected Map<State, List<Transition>> transitions;
    protected Set<State> endStates;

    protected AbstractAutomaton() {
        states = new HashMap<String,State>();
        transitions = new HashMap<State, List<Transition>>();
        endStates = new HashSet<State>();
    }

    public void setStartState(String name) {
        startState = getState(name);
    }

    public void setStartState(State state) {
        startState = state;
    }

    public void addTransition(String origin, String target, char condition) throws Exception {
        if(this instanceof DeterministicMealyMachine || this instanceof NonDeterministicMealyMachine){
            throw new Exception("Automaton is instance of MealyMachine");
        }
        State originState = getState(origin);
        State targetState = getState(target);
        addTransition(originState, targetState, condition);
    }

    public State getState(String name) throws RuntimeException {
        State state = states.get(name);
        if(state == null){
            throw new RuntimeException("State not found");
        }else{
            return state;
        }
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }

    public void addState(String name) throws Exception {
        if(this instanceof DeterministicMooreMachine || this instanceof NonDeterministicMooreMachine){
            throw new Exception("Automaton is instance of MooreMachine");
        }
        if(states.get(name) != null) {
            return;
        }
        State newState = new BasicState(name);
        states.put(name, newState);
    }

    public void addFinalState(String name) {
        endStates.add(getState(name));
    }

    public void addFinalState(State state) {
        endStates.add(state);
    }
    
}
