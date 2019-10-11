package com.jllsq.leetcode;

import com.jllsq.common.ListNode;

/**
 * 23.合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * */
public class MergeKSortedLists {

    // 堆排+遍历
    // n*logk  时间复杂度
    // k       空间复杂度
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = new ListNode(1);
        ListNode header = result;
        ListNode[] stack = lists;
        while (chooseMin(stack) != -1) {
            result.next = stack[0];
            result = result.next;
            stack[0] = stack[0].next;
        }
        result.next = null;
        return header.next;
    }

    private int chooseMin(ListNode[] stack) {
        int middle  = stack.length / 2 - 1;
        for (int i = middle;i >= 0; i --){
            if (2*i+1 < stack.length && stack[2*i+1] != null) {
                if (stack[i] == null || stack[2*i+1].val < stack[i].val) {
                    ListNode temp = stack[2*i+1];
                    stack[2*i+1] = stack[i];
                    stack[i] = temp;
                }
            }
            if (2*i+2 < stack.length && stack[2*i+2] != null) {
                if (stack[i] == null || stack[2*i+2].val < stack[i].val) {
                    ListNode temp = stack[2*i+2];
                    stack[2*i+2] = stack[i];
                    stack[i] = temp;
                }
            }
        }
        if (stack[0] == null) {
            return -1;
        }
        return 0;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        boolean label = true;
        for (int i = 0;i < lists.length;i ++) {
            if (lists[i] != null) {
                label = false;
            }
        }
        if (label) {
            return null;
        }
        while (!stop(lists)) {
            int index1 = -1,index2 = -1;
            for (int i = 0; i < lists.length; i ++) {
                if (index1 == -1 && lists[i] != null) {
                    index1 = i;
                } else {
                    if (index2 == -1 && lists[i] != null) {
                        index2 = i;
                        lists[index1] = merge2List(lists[index1],lists[index2]);
                        lists[index2] = null;
                        index1 = -1;
                        index2 = -1;
                    }
                }
            }
        }
        for (int i = 0;i < lists.length;i ++) {
            if (lists[i] != null) {
                return lists[i];
            }
        }
        return null;
    }

    private boolean stop(ListNode[] nodes) {
        int num = 0;
        for (int i = 0;i < nodes.length;i ++) {
            if (nodes[i] != null) {
                num ++;
            }
        }
        return num == 1;
    }

    private ListNode merge2List(ListNode node1,ListNode node2) {
        ListNode result = new ListNode(1);
        ListNode header = result;
        while(node1 != null || node2 != null) {
            if (node1 == null) {
                result.next = node2;
                result = result.next;
                node2 = node2.next;
            } else if (node2 == null) {
                result.next = node1;
                result = result.next;
                node1 = node1.next;
            } else {
                if (node1.val < node2.val) {
                    result.next = node1;
                    node1 = node1.next;
                } else {
                    result.next = node2;
                    node2 = node2.next;
                }
                result = result.next;
            }
        }
        return header.next;
    }

}
