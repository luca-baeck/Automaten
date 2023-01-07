package de.luca.baeck.java.automaton.Class.deterministic;

import java.util.ArrayList;
import java.util.List;

import de.luca.baeck.java.automaton.AbstractClass.deterministic.AbstractDeterministicTransducer;
import de.luca.baeck.java.automaton.State.State;
import de.luca.baeck.java.automaton.Transition.MealyTransition;
import de.luca.baeck.java.automaton.Transition.Transition;

public class DeterministicMealyMachine extends AbstractDeterministicTransducer {
    
    public DeterministicMealyMachine() {
        super();
    }

    public void addTransition(String origin, String target, char condition, char output) {
        State originState = getState(origin);
        State targetState = getState(target);
        addTransition(originState, targetState, condition, output);
    }

    public void addTransition(State origin, State target, char condition, char output) {
        List<Transition> transitionsFromState = transitions.get(origin);
        if(transitionsFromState != null){
            for (Transition trans : transitionsFromState) {
                if(trans.getCondition() == condition) {
                    return;
                }
            }
        }else{
            transitionsFromState = new ArrayList<Transition>();
        }
        Transition newTransition = new MealyTransition(origin, target, condition, output);
        transitionsFromState.add(newTransition);
        transitions.put(origin, transitionsFromState);
    }

    public String transduce(String input) {
        String output = "";
        String buffer = input;
        State currentState = startState;
        while(!buffer.equals("")) {
            List<Transition> transitionsFromState = transitions.get(currentState);
            boolean check = false;
            if(transitionsFromState != null){
                for(Transition trans : transitionsFromState) {
                    if(trans.getCondition() == buffer.charAt(0)) {
                        currentState = trans.getTargetState();
                        buffer = buffer.substring(1, buffer.length());
                        MealyTransition mTrans = (MealyTransition)trans;
                        output = output + mTrans.getOutput();
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
