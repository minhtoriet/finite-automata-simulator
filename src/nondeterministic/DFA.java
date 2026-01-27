package nondeterministic;
import java.util.*;

class NFA {
    private Map<String, State> stateMap = new HashMap<>();
    private Set<Character> alphabetSet = new HashSet<>();
    private State startState;
    NFA(){}

    void addState (State s){
        this.stateMap.put(s.getName(),s);
    }
    void setStartState(State s){
        this.startState = s;
    }
    void addEpsilonTransition(String fromState,String toState){
        stateMap.get(fromState).getEpsilonSet().add(stateMap.get(toState));
    }
    void addTransition(String fromState, char symbol, String toState) {
        if (!alphabetSet.contains(symbol)) {
            System.out.println("The character \"" + symbol + "\" does not belong to the vocabulary list.");
            return;
        }
        State from = stateMap.get(fromState);
        State to = stateMap.get(toState);
        from.getTransitionMap()
            .computeIfAbsent(symbol, k -> new ArrayList<>())
            .add(to);
    }
    private Set<State> epsilonClosure(Set<State> states) {
        Stack<State> stack = new Stack<>();
        Set<State> closure = new HashSet<>(states);

        for (State s : states) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            State current = stack.pop();
            for (State next : current.getEpsilonSet()) {
                if (!closure.contains(next)) {
                    closure.add(next);
                    stack.push(next);
                }
            }
        }
        return closure;
    }
    boolean isAccepted(String input) {
        Set<State> currentStates = new HashSet<>();
        currentStates.add(startState);
        currentStates = epsilonClosure(currentStates);

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            Set<State> nextStates = new HashSet<>();

            for (State state : currentStates) {
                List<State> transitions =
                        state.getTransitionMap().get(symbol);

                if (transitions != null) {
                    nextStates.addAll(transitions);
                }
            }
            currentStates = epsilonClosure(nextStates);
            if (currentStates.isEmpty()) {
                return false;
            }
        }
        for (State state : currentStates) {
            if (state.isAccepted()) {
                return true;
            }
        }
        return false;
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
