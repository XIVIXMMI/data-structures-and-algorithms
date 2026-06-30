import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(dfs(i, adj, visited, inPath))
                return false;
        }
        return true;
    }

    boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] inPath) {

        if (inPath[node] == true)
            return true;
        if (visited[node] == true)
            return false; // no circle detect after loops
        inPath[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visited, inPath)) {
                return true;
            }
        }
        inPath[node] = false;
        visited[node] = true;
        return false;
    }
}