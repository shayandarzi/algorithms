package com.example;

import java.util.*;

/**
 * @author Shayan
 * @since 6/3/2021
 */
public class Graph {
    //    Set<Node> vertices = new HashSet<>();
    private Map<Integer, Node> verticesMap = new HashMap<>();

//    public boolean addVertex(int data) {
//        Node newVertex = new Node(data);
//        if (vertices.contains(newVertex)) {
//            return false;
//        }
//        vertices.add(newVertex);
//        return true;
//    }

    public Node addVertex(int data) {
        if (verticesMap.containsKey(data)) {
            throw new RuntimeException("There is already a vertex with this data");
        }
        Node newVertex = new Node(data);
        verticesMap.put(data, newVertex);
        return newVertex;
    }

    public void addEdge(int a, int b) {
        Node firstNode = verticesMap.get(a);
        if (firstNode == null) {
            firstNode = addVertex(a);
        }
        Node secondNode = verticesMap.get(b);
        if (secondNode == null) {
            secondNode = addVertex(b);
        }
        firstNode.children.add(secondNode);
    }

    public List<Integer> dfs(Integer startNodeData) {
        List<Integer> result = new ArrayList<>();
        Node startNode = verticesMap.get(startNodeData);
        if (startNode != null) {
            dfsHelper(startNode, result);
        }
        return result;
    }

    private void dfsHelper(Node node, List<Integer> result) {
        if (!node.visited) {
            result.add(node.data);
            node.visited = true;
            if (node.children != null) {
                for (Node child : node.children) {
                    dfsHelper(child, result);
                }
            }

        }
    }
}

class Node {
    int data;
    boolean visited;
    List<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
