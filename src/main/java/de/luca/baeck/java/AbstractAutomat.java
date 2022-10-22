package de.luca.baeck.java;


import java.util.ArrayList;
import java.util.List;

abstract class AbstractAutomat implements Automat {
    
    protected State start;
    protected List<State> ends;
    protected List<State> states;

    public AbstractAutomat(){
        ends = new ArrayList<State>();
        states = new ArrayList<State>();
    }
    
    @Override
    public int getSize() {
        return states.size();
    }

    @Override
    public boolean isEmpty() {
        return states.size() == 0;
    }

    @Override
    public boolean setStart(String name) {
        State state = getState(name);
        if(state != null) {
            start = state;
            return true;
        }
        return false;
    }

    @Override
    public boolean addToEnds(String name) {
        State state = getState(name);
        if(state != null) {
            if(!ends.contains(state)){
                ends.add(state);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean createState(String name) {
        State state = getState(name);
        if(state != null) {
            return false;
        }

        State newState = new State(name);
        states.add(newState);
        return true;
    }

    @Override
    public void removeStart() {
        start = null;
    }

    @Override
    public boolean removeEnd(String name) {
        State state = getState(name);
        if(state != null) {
            ends.remove(state);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeState(String name) {
        State state = getState(name);
        if(state != null) {

            removeEnd(state.getName());

            if(start.getName().equals(state.getName())){
                removeStart();
            }
            for (State stateS : states) {
                if(!stateS.getName().equals(state.getName())) {
                    List<String[]> connections = stateS.getConnections();
                    List<String[]> connectionsToRemove = new ArrayList<>();
                    for (String[] connection : connections) {
                        if(connection[0].equals(name)){
                            String[] connectionToRemove = new String[3];
                            connectionToRemove[0] = stateS.getName();
                            connectionToRemove[1] = connection[0];
                            connectionToRemove[2] = connection[1];
                            connectionsToRemove.add(connectionToRemove);                          
                        }
                    }
                    for (String[] connectionToRemove : connectionsToRemove) {
                        removeConnection(connectionToRemove[0], connectionToRemove[1], connectionToRemove[2]);
                    }
                }   
            }
            states.remove(state);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeConnection(String startState, String endState, String condition) {
        State origin = getState(startState);
        State target = getState(endState);
        if(origin == null || target == null || condition.equals("")) {
            return false;
        }
        origin.removeConnection(endState, condition);
        return true;
    }

    protected State getState(String name){
        if(states == null || states.isEmpty()){
            return null;
        }
        for (State state : states) {
            if(state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
