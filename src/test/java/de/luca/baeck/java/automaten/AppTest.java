package de.luca.baeck.java.automaten;

import de.luca.baeck.java.Automat;
import de.luca.baeck.java.DEA;

public class AppTest 
{
    public static void main(String[] args){
        Automat automat = new DEA();
        automat.createState("z0");
        automat.createState("z0");
        System.out.println(automat.getSize());
        automat.createState("z1");
        System.out.println(automat.getSize());
        automat.setStart("z0");
        automat.addToEnds("z1");
        automat.addToEnds("z0");
        automat.addConnection("z0", "z0", "b");
        automat.addConnection("z0", "z0", "c");
        automat.addConnection("z0", "z1", "a");
        automat.addConnection("z1", "z1", "a");
        automat.addConnection("z1", "z1", "b");
        automat.removeState("z1");
        System.out.println(automat.getSize());
        System.out.println(automat.process("bbbbbb"));
        System.out.println(automat.process("cbbbbbbbcccccccbc"));
        System.out.println(automat.process("abbb"));
        System.out.println(automat.process("aaabbbaaa"));
        System.out.println(automat.process("bbabba"));
    }
}
