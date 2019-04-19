package com.jllsq.common;

import java.util.LinkedList;
import java.util.List;

/**
 * 最佳合并问题
 *
 * 给定n个有序文件，每个文件的记录数分别为w1~wn，请给出一种两两合并的方案，使得总合并次数最少。
 *
 * 为保证合并消耗最小，需要将大的文件较后合并，这就变成了哈夫曼编码问题
 *
 * @author Math312
 * @date 2019-04-18 21:13
 **/
public class BestMergeProblem {

    /**
     * 解决方案
     *
     * @param data 传入数据
     * @return List<String> 合并过程
     * @author Math312
     * @date 2019/4/18
     */
    public List<String> solution(int[] data) {
        List<String> result = new LinkedList<String>();
        if (data == null || data.length == 0) {
            return result;
        }
        while (!stop(data)) {
            String oneResult = merge(data);
            result.add(oneResult);
        }
        return result;
    }

    /**
     * 单词哈夫曼编码逻辑（采用堆排实现）
     *
     * @param data 哈夫曼编码单次逻辑
     * @return String 哈夫曼编码过程
     * @author Math312
     * @date 2019/4/18
     */
    private String merge(int[] data) {
        innerHeapSort(data);
        int first = data[0];
        data[0] = Integer.MAX_VALUE;
        innerHeapSort(data);
        int next = data[0];
        int sum = first + next;
        String result = first + " +  " + next + "  =  " + sum;
        data[0] = sum;
        return result;
    }

    /**
     * 一次堆排
     *
     * @param data 堆排数据
     * @author Math312
     * @date 2019/4/18
     */
    private void innerHeapSort(int[] data) {
        int i = data.length / 2 - 1;
        for (; i >= 0; i--) {
            if ((2 * i + 1) < data.length && data[2 * i + 1] < data[i]) {
                int temp = data[i];
                data[i] = data[2 * i + 1];
                data[2 * i + 1] = temp;
            }
            if ((2 * i + 2) < data.length && data[2 * i + 2] < data[i]) {
                int temp = data[i];
                data[i] = data[2 * i + 2];
                data[2 * i + 2] = temp;
            }
        }
    }

    /**
     * 是否应该停止哈夫曼算法
     *
     * @param data 输入数据
     * @return boolean 是否应该停止哈夫曼编码
     * @author Math312
     * @date 2019/4/18
     */
    private boolean stop(int[] data) {
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != Integer.MAX_VALUE) {
                num++;
            }
        }
        return num == 1;
    }
}
