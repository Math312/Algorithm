package com.jllsq.common

import spock.lang.Specification

import javax.print.attribute.IntegerSyntax

class MinimumCostSpanningTreeTest extends Specification {


    MinimumCostSpanningTree question = new MinimumCostSpanningTree();

    void testPrim() {

        setup:
        int[][] graph = [[0, 6, 1, 5, -1, -1],
                         [6, 0, 5, -1, 3, -1],
                         [1, 5, 0, 5, 6, 4],
                         [5, -1, 5, 0, -1, 2],
                         [-1, 3, 6, -1, 0, 6],
                         [-1, -1, 4, 2, 6, 0]]
        when:
        List<Integer> result = question.prim(graph, 0)
        then:
        result.size() == 6
        result.get(0) == 1
        result.get(1) == 3
        result.get(2) == 6
        result.get(3) == 4
        result.get(4) == 2
        result.get(5) == 5
    }


    void testKruskal() {
        setup:
        int[][] graph = [[0, 6, 1, 5, -1, -1],
                         [6, 0, 5, -1, 3, -1],
                         [1, 5, 0, 5, 6, 4],
                         [5, -1, 5, 0, -1, 2],
                         [-1, 3, 6, -1, 0, 6],
                         [-1, -1, 4, 2, 6, 0]]
        when:
        List<Integer> result = question.kruskal(graph,0)
        then:
        result.size() == 6;

    }

}
