package com.example.dijkstra;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Shayan
 * @since 7/24/2022
 */

public class Node {
    private String name;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();
    private int distance = Integer.MAX_VALUE;
    private LinkedList<Node> shortestPath = new LinkedList<>();

    public Node(String name) {
        this.name = name;
    }

    public Node() {
    }

    public void addDestination(Node node, int weight) {
        adjacentNodes.put(node, weight);
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public int getDistance() {
        return this.distance;
    }

    public LinkedList<Node> getShortestPath() {
        return this.shortestPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
}
