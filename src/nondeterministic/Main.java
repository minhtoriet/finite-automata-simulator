package nondeterministic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            NFA testNFA = new NFA();
            //System.out.println("plz define your DFA as followed: the DFA's alphabet,the number of states, list of states, num of transitions, transitions, start state, num of accepted states, and list of accepted states\n");
            //System.out.println("DFA's alphabet (number of characters, list of chars)");
            int charNum = sc.nextInt();
            for (int i = 0; i < charNum; i++) {
                testNFA.getAlphabetSet().add(sc.next().charAt(0));
            }
            //System.out.println("DFA's states: number of states, list of states");
            int stateNum = sc.nextInt();
            for (int i = 0; i < stateNum; i++) {
                String s = sc.next();
                testNFA.addState(new State(s));
            }
            //System.out.println("DFA's transitions: list of transitions (start state, symbol, end state)");
            //the number of transitions should be (size of alphabet)*(number of states)
            charNum = sc.nextInt();
            for (int i = 0; i < charNum; i++) {
                testNFA.addTransition(sc.next(), sc.next().charAt(0), sc.next());
            }
            // System.out.println("Start state:");
            String start = sc.next();
            testNFA.setStartState(testNFA.getStateMap().get(start));
            //System.out.println("Accepted states: number of accepted states, list of accepted states");
            int acceptNum = sc.nextInt();
            for (int i = 0; i < acceptNum; i++) {
                String str = sc.next();
                testNFA.getStateMap().get(str).setAccepted(true);
            }
            //System.out.println("Epsilon: number of epsilon transitions, from state, to state");
            for (int i = 0; i < stateNum; i++) {
                stateNum = sc.nextInt();
            }
            testNFA.addEpsilonTransition(sc.next(), sc.next());
            //System.out.println("Input:");
            String input = sc.next();
            System.out.println(testNFA.isAccepted(input)? "String accepted" : "String rejected");
        }
    }
}
/*
2 0 1
4 q1 q2 q3 q4
7
q1 0 q1
q1 1 q1
q1 1 q2
q2 0 q3
q3 1 q4
q4 0 q4
q4 1 q4
q1
1 q4
1 q2 q3
1010
*/

