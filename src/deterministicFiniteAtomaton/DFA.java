package deterministicFiniteAtomaton;
import java.util.*;

class DFA {
    private Map<String, State> stateMap = new HashMap<>();
    private Set<Character> alphabetSet = new HashSet<>();
    private State startState;
    DFA(){}

    void addState (State s){
        this.stateMap.put(s.getName(),s);
    }
    void setStartState(State s){
        this.startState = s;
    }
    void addTransition(String fromState, char symbol, String toState){
        if (!alphabetSet.contains(symbol)){
            System.out.println("The character \""+symbol+"\" does not belong to the vocabulary list.");
        }
        stateMap.get(fromState).getTransitionMap().put(symbol, stateMap.get(toState));
    }
    boolean isAccepted(String input){
        StringBuilder sb = new StringBuilder();
        State currenState = startState;
        sb.append(currenState.getName());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!alphabetSet.contains(c)){
                System.out.println("The character \""+c+"\" does not belong to the vocabulary list.");
                return false;
            }
            currenState = currenState.getTransitionMap().get(c);
            sb.append("->").append(currenState.getName());
        }
        System.out.println(currenState.isAccepted()?"input accepted with following state change: " + sb:"input rejected with following state change: "+ sb );
        return currenState.isAccepted();
    }

    public Map<String, State> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, State> stateMap) {
        this.stateMap = stateMap;
    }

    public Set<Character> getAlphabetSet() {
        return alphabetSet;
    }

    public void setAlphabetSet(Set<Character> alphabetSet) {
        this.alphabetSet = alphabetSet;
    }

    public State getStartState() {
        return startState;
    }
    
}
