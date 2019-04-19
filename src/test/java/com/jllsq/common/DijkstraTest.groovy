package com.jllsq.common

import spock.lang.Specification

class DijkstraTest extends Specification {

    Dijkstra question = new Dijkstra();

    void testDijkstra() {
        setup:
        int[][] data = [[0, 6, 1, 5, -1, -1],
                        [6, 0, 5, -1, 3, -1],
                        [1, 5, 0, 5, 6, 4],
                        [5, -1, 5, 0, -1, 2],
                        [-1, 3, 6, -1, 0, 6],
                        [-1, -1, 4, 2, 6, 0]]

        when:
        int[] result = question.dijkstra(data, 0)
        then:
        result[0] == 0
        result[1] == 6
        result[2] == 1
        result[3] == 5
        result[4] == 7
        result[5] == 5

    }
}
