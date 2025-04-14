package gts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 *  There are two containers one is 5 litre and 3 litre and result  need to get 4 litre.
 * 
 * */
public class Q043_WaterJugProblem {

    static class State {
        int jug1, jug2;
        String path;
 
        State(int jug1, int jug2, String path) {
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.path = path;
        }
 
        @Override
        public int hashCode() {
            return Objects.hash(jug1, jug2);
        }
 
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)) return false;
            State other = (State) obj;
            return this.jug1 == other.jug1 && this.jug2 == other.jug2;
        }
    }
 
    public static void solveWaterJug(int capacity1, int capacity2, int target) {
    	Queue<State> queue = new java.util.LinkedList<>();
 
    	
    	
        Set<State> visited = new HashSet<>();
 
        queue.add(new State(0, 0, "Initial state: [0, 0]\n"));
 
        while (!queue.isEmpty()) {
            State curr = queue.poll();
 
            if (curr.jug1 == target || curr.jug2 == target) {
                System.out.println("Solution Found:\n" + curr.path +
                        String.format("Final Result: [Jug1: %dL, Jug2: %dL]", curr.jug1, curr.jug2));
                return;
            }
 
            if (visited.contains(curr)) continue;
            visited.add(curr);
 
            List<State> nextStates = new ArrayList<>();
            nextStates.add(new State(capacity1, curr.jug2, curr.path + "Fill Jug1 → ["
                    + capacity1 + ", " + curr.jug2 + "]\n"));
            nextStates.add(new State(curr.jug1, capacity2, curr.path + "Fill Jug2 → ["
                    + curr.jug1 + ", " + capacity2 + "]\n"));
            nextStates.add(new State(0, curr.jug2, curr.path + "Empty Jug1 → [0, " + curr.jug2 + "]\n"));
            nextStates.add(new State(curr.jug1, 0, curr.path + "Empty Jug2 → [" + curr.jug1 + ", 0]\n"));
 
            int pourToJug2 = Math.min(curr.jug1, capacity2 - curr.jug2);
            nextStates.add(new State(curr.jug1 - pourToJug2, curr.jug2 + pourToJug2,
                    curr.path + "Pour Jug1 → Jug2 → [" + (curr.jug1 - pourToJug2) + ", "
                            + (curr.jug2 + pourToJug2) + "]\n"));
 
            int pourToJug1 = Math.min(curr.jug2, capacity1 - curr.jug1);
            nextStates.add(new State(curr.jug1 + pourToJug1, curr.jug2 - pourToJug1,
                    curr.path + "Pour Jug2 → Jug1 → [" + (curr.jug1 + pourToJug1) + ", "
                            + (curr.jug2 - pourToJug1) + "]\n"));
 
            queue.addAll(nextStates);
        }
 
        System.out.println("❌ No solution exists for the given jug sizes and target.");
    }
 
    public static void main(String[] args) {
        int jug1Capacity = 5;
        int jug2Capacity = 3;
        int target = 4;
 
        System.out.printf("🔍 Trying to measure %dL using [%dL, %dL] jugs...\n\n",
                target, jug1Capacity, jug2Capacity);
        solveWaterJug(jug1Capacity, jug2Capacity, target);
    }
}