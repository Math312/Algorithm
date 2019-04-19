package com.jllsq.common;

/**
 * 背包问题
 *
 * 有一个背包，最多放M kg的物体（物体大小不限）；
 * 有n个物体，每个物体的重量为Wi，每个物体完全放入背包后可获得收益Pi。问：如何放置能获得最大的收益？
 *
 * @author Math312
 * @date 2019-04-18 20:02
 **/
public class Package {


    /**
     * 一般背包问题
     *
     * 物体可拆分
     *
     * @param product 二维数组，第一维度表示物体的个数，第二维度表示物体的价值。
     * @param weight  背包最大放入物体质量
     * @return 最大收益
     * @author Math312
     * @date 2019/4/18
     */
    public double commonPackage(double[][] product, int weight) {
        if (!checkData(product, weight)) {
            return -1;
        }
        double[] perValue = new double[product.length];
        // 算出每个物体的性价比
        for (int i = 0; i < product.length; i++) {
            if (product[i][0] != 0) {
                perValue[i] = product[i][1] / product[i][0];
            } else {
                perValue[i] = 0;
            }
        }
        double leftWeight = weight;
        double result = 0;
        double max = Double.MIN_VALUE;
        int maxIndex = -1;
        while (leftWeight > 0) {
            // 找出每次性价比最高的物体
            for (int i = 0; i < perValue.length; i++) {
                if (max < perValue[i] && product[i][0] > 0) {
                    maxIndex = i;
                }
            }
            // 放入最多的该物体
            if (leftWeight - product[maxIndex][0] > 0) {
                result += product[maxIndex][1];
                leftWeight -= product[maxIndex][0];
            } else {
                result += leftWeight * perValue[maxIndex];
                leftWeight = 0;
            }
        }
        return result;
    }

    /**
     * 检验传入数据正确性
     *
     * @param product 二维数组，第一维度表示物体重量，第二维度表示物体价值
     * @param weight  背包最大放入物体质量
     * @return 输入数据是否正确
     * @author Math312
     * @date 2019/4/18
     */
    private boolean checkData(double[][] product, double weight) {
        if (product == null || weight < 0) {
            return false;
        }
        for (int i = 0; i < product.length; i++) {
            if (product[i].length != 2 || product[i][0] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 01背包问题
     *
     * @param product 二维数组，第一维度表示物体重量，第二维度表示物体价值
     * @param weight  背包最大放入物体质量
     * @return 最大收益
     * @author Math312
     * @date 2019/4/18
     */
    public double package01(double[][] product, double weight) {
        if (!checkData(product, weight)) {
            return -1;
        }
        int[] label = new int[product.length];
        for (int i = 0; i < label.length; i++) {
            label[i] = 0;
        }
        return maxPackage(product, weight, label, 0);
    }

    /**
     * 选取最优解决方案
     *
     * @param product 二维数组，第一维度表示物体重量，第二维度表示物体价值
     * @param weight  背包最大放入物体质量
     * @param label   标记
     * @param sum     和
     * @return
     * @author Math312
     * @date 2019/4/18
     */
    private double maxPackage(double[][] product, double weight, int[] label, double sum) {
        double max = sum;
        for (int i = 0; i < label.length; i++) {
            if (label[i] == 0) {
                int[] temp = copyArray(label);
                if (weight >= product[i][0]) {
                    temp[i] = 1;
                    sum = sum + product[i][1];
                    weight = weight - product[i][0];
                    sum += maxPackage(product, weight, temp, sum);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 拷贝数组
     *
     * @param array 数组
     * @return int[] 拷贝结果
     * @author Math312
     * @date 2019/4/18
     */
    private int[] copyArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

}
