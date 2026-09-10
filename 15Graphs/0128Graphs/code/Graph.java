// REFERENCE ONLY — see the note in 0120's Reference_ivanzykov_LinkedList.java for how to use this.
// Source: https://github.com/ivan-zykov/udemy-dsa-barrett
// File: src/main/java/net/ivanzykov/datastructures/graph/Graph.java
// Fetched 2026-06-20.
//
// Confirms the corrected GAPS_AND_ROADMAP.md note: this is structural CRUD only (add/remove
// vertex/edge over an adjacency list) — no BFS/DFS on the graph itself. This student's repo
// doesn't have graph traversal either, consistent with the real course curriculum.
//
// No package statement here on purpose — this file isn't nested under matching package folders
// in your project.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    /*Graph:- Add Vertex*/
    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    /*Graph:- Add Edge*/
    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    /*Graph:- Remove Vertex*/
    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex: adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    /*Graph:- Remove Edge*/
    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }
}
