package com.jllsq.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 最小代价生成树
 *
 * @author Math312
 * @date 2019-04-18 23:28
 **/
public class MinimumCostSpanningTree {

    /**
     * 使用prim算法创建最小代价生成树
     *
     * @param graph 输入图
     * @param index 最小代价生成树头节点
     * @return 最小代价生成树根节点
     * @author Math312
     * @date 2019/4/19
     */
    public List<Integer> prim(int[][] graph, int index) {
        int[] mark = new int[graph.length];
        int[] nearest = new int[graph.length];
        List<Integer> list = new LinkedList<Integer>();
        initMark(mark);
        initNearest(nearest);

        mark[index] = 1;
        updateNearest(mark, nearest, graph);
        list.add(index + 1);

        while (true) {
            int chosen = chooseMin(mark, nearest);
            if (chosen == -1) {
                break;
            } else {
                mark[chosen] = 1;
                updateNearest(mark, nearest, graph);
                list.add(chosen + 1);
            }
        }
        return list;
    }

    private int chooseMin(int[] mark, int[] nearest) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < nearest.length; i++) {
            if (min > nearest[i] && mark[i] == 0) {
                min = nearest[i];
                index = i;
            }
        }
        return index;
    }

    private void updateNearest(int[] mark, int[] nearest, int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (mark[i] == 1 && mark[j] == 0 && graph[i][j] != -1) {
                    if (graph[i][j] < nearest[j]) {
                        nearest[j] = graph[i][j];
                    }
                }
            }
        }
    }

    /**
     * 初始化标识数组
     *
     * @param mark 标识数组
     * @author Math312
     * @date 2019/4/19
     */
    private void initMark(int[] mark) {
        for (int i = 0; i < mark.length; i++) {
            mark[i] = 0;
        }
    }

    /**
     * 初始化已选入生成树到各个节点的最近距离
     *
     * @param nearest 记录已选入生成树到各个节点的最近距离的数组
     * @author Math312
     * @date 2019/4/19
     */
    private void initNearest(int[] nearest) {
        for (int i = 0; i < nearest.length; i++) {
            nearest[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * 检验是否形成完整最小生成树
     *
     * @param mark 标识数组
     * @return boolean 最小生成树是否完成
     * @author Math312
     * @date 2019/4/19
     */
    private boolean checkData(int[] mark) {
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> kruskal(int[][] graph, int index) {
        int[] mark = new int[graph.length];
        List<Integer> result = new ArrayList<Integer>();
        initMark(mark);
        mark[index] = 1;
        result.add(index);
        int sum = 0;
        while (!checkData(mark)) {
            int min = Integer.MAX_VALUE;
            int x = -1;
            int y = -1;
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (graph[i][j] != -1 && graph[i][j] < min && mark[i] == 0 && mark[j] != 0 && graph[i][j] != 0) {
                        min = graph[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            if (x != -1 && y != -1) {
                sum += graph[x][y];
                graph[x][y] = -1;
                result.add(x);
                mark[x] = 1;

            } else {
                break;
            }
        }
        System.out.println(sum);
        return result;
    }

}
