package deterministicFiniteAtomaton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            DFA testDFA = new DFA();
            //System.out.println("plz define your DFA as followed: the DFA's alphabet,the number of states, list of states, num of transitions, transitions, start state, num of accepted states, and list of accepted states\n");
            //System.out.println("DFA's alphabet (number of characters, list of chars)");
            int charNum = sc.nextInt();
            for (int i = 0; i < charNum; i++) {
                testDFA.getAlphabetSet().add(sc.next().charAt(0));
            }
            //System.out.println("DFA's states: number of states, list of states");
            int stateNum = sc.nextInt();
            for (int i = 0; i < stateNum; i++) {
                String s = sc.next();
                testDFA.addState(new State(s));
            }
            //System.out.println("DFA's transitions: list of transitions (start state, symbol, end state)");
            //the number of transitions should be (size of alphabet)*(number of states)
            for (int i = 0; i < stateNum*(testDFA.getAlphabetSet().size()); i++) {
                testDFA.addTransition(sc.next(), sc.next().charAt(0), sc.next());
            }
            // System.out.println("Start state:");
            String start = sc.next();
            testDFA.setStartState(testDFA.getStateMap().get(start));
            //System.out.println("Accepted states: number of accepted states, list of accepted states");
            int acceptNum = sc.nextInt();
            for (int i = 0; i < acceptNum; i++) {
                String str = sc.next();
                testDFA.getStateMap().get(str).setAccepted(true);
            }
            //System.out.println("Input:");
            String input = sc.next();
            testDFA.isAccepted(input);
        }
    }
    /*
    2 a b
    5 s q1 q2 r1 r2
    q1 a q1
    q1 b q2
    q2 a q1
    q2 b q2
    r1 a r2
    r1 b r1
    r2 a r2
    r2 b r1
    s a q1
    s b r1
    s
    2 q1 r1
    aabba
    */
}
