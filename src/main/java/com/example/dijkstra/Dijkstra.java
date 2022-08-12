package com.example.dijkstra;


import java.util.*;

/**
 * @author Shayan
 * @since 7/24/2022
 */


// Solution is copied from https://github.com/eugenp/tutorials/blob/master/algorithms-modules/algorithms-miscellaneous-2/src/main/java/com/baeldung/algorithms/ga/dijkstra/Dijkstra.java

// I don't like this solution because it's changing input graph. But since the values could change by each source node, I believe graph should not be effected
//    I can also create a new Graph instead of using previous one. But it would increase memory usage
public class Dijkstra {
    private static final Comparator<Node> NODE_COMPARATOR = Comparator.comparingInt(Node::getDistance);

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        // add comparator
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(NODE_COMPARATOR);
        Set<Node> visitedNodes = new HashSet<>();
        source.setDistance(0);
        priorityQueue.add(source);
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (visitedNodes.contains(currentNode)) {
                continue;
            }
            visitedNodes.add(currentNode);
            for (Map.Entry<Node, Integer> adjacentNodePair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacentNodePair.getKey();
                int weight = adjacentNodePair.getValue();
                if (visitedNodes.contains(adjacentNodePair.getKey())) {
                    continue;
                }
                if (currentNode.getDistance() + weight < adjacentNode.getDistance()) {
                    adjacentNode.setDistance(currentNode.getDistance() + weight);
                    LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
                    shortestPath.add(currentNode);
                    adjacentNode.setShortestPath(shortestPath);
                }
                priorityQueue.add(adjacentNode);
            }

        }
        return graph;
    }

}

