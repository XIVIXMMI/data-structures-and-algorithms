package Recursion;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {

    public static class Node {
        private Set<Node> neighbors;

        public Node() {
            this.neighbors = new HashSet<>();
        }

        public Set<Node> getNeighbors() {
            return neighbors;
        }
    }

    public static void main(String[] args) {
        // Your main code here
    }

    public static boolean depthFirstSearch(Node node, Set<Node> visited, Node goal) {
        if (node == null) {
            return false;
        }
        if (node == goal) {
            return true;
        }

        for (Node neighbor : node.getNeighbors()) {
            if (visited.contains(neighbor)) continue;
            visited.add(neighbor);
            boolean isFound = depthFirstSearch(neighbor, visited, goal);

            if (isFound) return true;
        }
        return false;
    }
}
