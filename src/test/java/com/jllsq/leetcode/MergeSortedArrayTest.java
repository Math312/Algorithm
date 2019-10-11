package com.jllsq.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedArrayTest {

    private MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @Test
    public void merge() {
        int[] array1 = new int[0];
        int[] array2 = new int[0];
        mergeSortedArray.merge(array1,0,array2,0);
        assertArrayEquals(new int[0],array1);
        array1 = new int[]{0};
        array2 = new int[]{1};
        mergeSortedArray.merge(array1,0,array2,1);
        assertArrayEquals(new int[]{1},array1);
        array1 = new int[]{1,2,3,4,0,0,0,0};
        array2 = new int[]{5,6,7,8};
        mergeSortedArray.merge(array1,4,array2,4);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},array1);
    }
}