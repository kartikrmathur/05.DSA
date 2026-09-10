package Questions;

import java.util.*;

public class TopologicalSortAlgorithm {

    // find the indegree of a node by adding in-edge count
    public static <T> Map<T, Integer> findInDegree(Map<T, List<T>> graph) {
        Map<T, Integer> inDegree = new HashMap<>();
        graph.keySet().forEach(node -> {
            inDegree.put(node, 0);
        });
        // loop through every node and add 1 in-edge count to its neighbors
        graph.entrySet().forEach(entry -> {
            for (T neighbor : entry.getValue()) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        });
        return inDegree;
    }

    // topological sort the list
    public static <T> List<T> topoSort(Map<T, List<T>> graph) {
        // return a list of the topological sorted list
        List<T> res = new ArrayList<>();
        // make a queue that we will use for our solution
        Queue<T> q = new ArrayDeque<>();
        // loop through all nodes and add all nodes that have 0 in-degree
        Map<T, Integer> inDegree = findInDegree(graph);
        inDegree.entrySet().forEach(entry -> {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        });
        // perform bfs with queue, mostly the same as template bfs
        while (!q.isEmpty()) {
            T node = q.poll();
            // add node to list to keep track of topological order
            res.add(node);
            for (T neighbor : graph.get(node)) {
                // subtract one from every neighbour
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                // once the in-degree reaches 0 you add it to the queue
                if (inDegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }
        // check for cycle
        return (graph.size() == res.size()) ? res : null;
    }

}