//package com.example;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
///**
// * @author Elham
// * @since 6/3/2021
// */
//public class GraphTest {
//    private Graph graph;
//
//    @BeforeEach
//    public void setUp() {
//        graph = new Graph();
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 0);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 3);
//        graph.addEdge(4, 5);
//    }
//
//    @Test
//    public void testDfs() {
//        List<Integer> result = graph.dfs(1);
//        result.forEach(value -> System.out.println(value));
//    }
//}
