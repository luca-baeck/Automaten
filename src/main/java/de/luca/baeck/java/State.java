package de.luca.baeck.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class State {

    private String name;
    private List<String[]> connections; 

    public State(String name) {
        this.name = name;
        connections = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public List<String[]> getConnections(){
        return connections;
    } 
    
    public boolean addConnection(String target, String condition, boolean unique) {
        String[] connection = new String[2];
        connection[0] = target;
        connection[1] = condition;
        if(unique){
            for (String[] connectionC : connections) {
                if(condition.equals(connectionC[1])) {
                    return false;
                }
            }
        }
        if(findConnection(connection) == null){
            connections.add(connection);
            return true;
        }
        return false;
    }

    private String[] findConnection(String[] connectionP){
        for (String[] connection : connections) {
            if(Arrays.equals(connection, connectionP)){
                return connection;
            }
        }
        return null;
    }

    public void removeConnection(String target, String condition){
        String[] connection = new String[2];
        connection[0] = target;
        connection[1] = condition;
        String[] connectionFound = findConnection(connection);
        connections.remove(connectionFound);
    }  
}