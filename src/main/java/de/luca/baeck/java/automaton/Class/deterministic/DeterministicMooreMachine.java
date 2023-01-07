package de.luca.baeck.java.automaton.Class.deterministic;

import java.util.List;

import de.luca.baeck.java.automaton.AbstractClass.deterministic.AbstractDeterministicTransducer;
import de.luca.baeck.java.automaton.State.MooreState;
import de.luca.baeck.java.automaton.State.State;
import de.luca.baeck.java.automaton.Transition.Transition;

public class DeterministicMooreMachine extends AbstractDeterministicTransducer {
    
    public DeterministicMooreMachine() {
        super();
    }

    public void addState(String name, char output){
        if(states.get(name) != null) {
            return;
        }
        State newState = new MooreState(name, output);
        states.put(name, newState);
    }

    public String transduce(String input) {
        String output = "";
        String buffer = input;
        State currentState = startState;
        output = output + ((MooreState)currentState).getOutput();
        while(!buffer.equals("")) {
            List<Transition> transitionsFromState = transitions.get(currentState);
            boolean check = false;
            if(transitionsFromState != null){
                for(Transition trans : transitionsFromState) {
                    if(trans.getCondition() == buffer.charAt(0)) {
                        currentState = trans.getTargetState();
                        buffer = buffer.substring(1, buffer.length());
                        MooreState mState = (MooreState)currentState;
                        output = output + mState.getOutput();
                        check = true;
                        break;
                    }
                }
            }
            if(!check){
                return "";
            }
        }
        return endStates.contains(currentState)?output:"";
    }

}
