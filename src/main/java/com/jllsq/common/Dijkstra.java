package com.jllsq.common;

/**
 * 迪杰斯特拉算法
 *
 * @author Math312
 * @date 2019-04-19 16:57
 **/
public class Dijkstra {

    /**
     * 迪杰斯特拉算法实现
     *
     * @param graph 图
     * @param index 初始节点
     * @return 最短距离
     * @author Math312
     * @date 2019/4/19
     */
    public int[] dijkstra(int[][] graph, int index) {
        int[] mark = new int[graph.length];
        initMark(mark);
        int[] nearest = new int[graph.length];
        initNearest(nearest);
        mark[index] = 1;
        nearest[index] = 0;
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] != -1) {
                nearest[i] = graph[index][i];
            }

        }
        int temp = index;
        while (true) {
            temp = chooseMin(mark, nearest);
            if (temp == -1) {
                break;
            } else {
                mark[temp] = 1;
                for (int i = 0; i < graph[temp].length; i++) {
                    if (graph[temp][i] + nearest[temp] < nearest[i] && mark[i] == 0 && graph[temp][i] != -1) {
                        nearest[i] = graph[temp][i] + nearest[temp];
                    }
                }
            }
        }
        return nearest;
    }

    /**
     * 初始化标记数组
     *
     * @param mark 标记数组
     * @author Math312
     * @date 2019/4/19
     */
    private void initMark(int[] mark) {
        for (int i = 0; i < mark.length; i++) {
            mark[i] = 0;
        }
    }

    /**
     * 初始化最短距离数组
     *
     * @param nearest 最短距离数组
     * @author Math312
     * @date 2019/4/19
     */
    private void initNearest(int[] nearest) {
        for (int i = 0; i < nearest.length; i++) {
            nearest[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * 选择最短路径
     *
     * @param mark    标记数组
     * @param nearest 距离数组
     * @return int 最短结果
     * @author Math312
     * @date 2019/4/19
     */
    private int chooseMin(int[] mark, int[] nearest) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < mark.length; i++) {
            if (min > nearest[i] && mark[i] == 0) {
                index = i;
                min = nearest[i];
            }
        }
        return index;
    }

}
