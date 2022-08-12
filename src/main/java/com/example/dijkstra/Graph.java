package com.example.dijkstra;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shayan
 * @since 7/24/2022
 */

public class Graph {
    @Setter
    @Getter
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }
}
