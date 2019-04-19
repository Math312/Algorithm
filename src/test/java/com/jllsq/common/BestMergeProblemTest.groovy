package com.jllsq.common

import spock.lang.Specification

class BestMergeProblemTest extends Specification {

    BestMergeProblem question = new BestMergeProblem();

    void testSolution() {
        setup:
            int[] data = [30, 30, 20, 5, 10]
        when:
            List<String> list = question.solution(data)
        then:
            list.size() == 4
            print(list)
    }

}
