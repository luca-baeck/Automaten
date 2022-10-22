package de.luca.baeck.java;

import java.util.List;

public class DEA extends AbstractAutomat {

    @Override
    public boolean process(String input) {
        if(start == null){
            return false;
        }
        String buf = input;
        State currentState = start;
        outer: while(!buf.equals("")) {
            char currentChar = buf.charAt(0);
            boolean stuck = false;
            List<String[]> connections = currentState.getConnections();
            inner: for (String[] connection : connections) {
                if(Character.toString(currentChar).equals(connection[1])) {
                    currentState = getState(connection[0]);
                    buf = buf.substring(1);
                    stuck = false;
                    break inner;
                }else {
                    stuck = true;
                }
            }
            if(stuck) {
                return false;
            }
        }
        return ends.contains(currentState);
    }

    @Override
    public boolean addConnection(String startState, String endState, String condition) {
        State origin = getState(startState);
        State target = getState(endState);
        if(origin == null || target == null || condition.equals("")) {
            return false;
        }
        boolean res = origin.addConnection(endState, condition, true);
        return res;
    }
    
}

