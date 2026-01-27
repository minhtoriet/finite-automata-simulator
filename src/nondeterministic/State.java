package nondeterministic;

import java.util.*;

public class State {
    private String name;
    private boolean accepted;
    private Map<Character,List<State>> transitionMap = new HashMap<>();
    private Set<State> epsilonSet = new HashSet<>();
    State(String name){
        this.name = name;
    }
    
    String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    void setName(String name) {
        this.name = name;
    }

     boolean isAccepted() {
        return accepted;
    }
    
     void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    public Map<Character, List<State>> getTransitionMap() {
        return transitionMap;
    }


    public Set<State> getEpsilonSet() {
        return epsilonSet;
    }
    /*Transition*/
    // static class Transition{
    //     private char symbol;
    //     private State s;

    //     public Transition(char symbol, State s) {
    //         this.symbol = symbol;
    //         this.s = s;
    //     }

    //     public char getSymbol() {
    //         return symbol;
    //     }

    //     public void setSymbol(char symbol) {
    //         this.symbol = symbol;
    //     }

    //     public State getEndState() {
    //         return s;
    //     }

    //     public void setEndState(State s) {
    //         this.s = s;
    //     }

        
    // }

    //  List<Transition> getTransitionList() {
    //     return transitionList;
    // }

    

    


}
