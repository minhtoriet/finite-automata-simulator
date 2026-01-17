package deterministicFiniteAtomaton;

import java.util.*;

public class State {
    private String name;
    private boolean accepted;
    private Map<Character,State> transitionMap = new HashMap<>();
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
    
    public Map<Character, State> getTransitionMap() {
        return transitionMap;
    }

    public void setTransitionMap(Map<Character, State> transitionMap) {
        this.transitionMap = transitionMap;
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
