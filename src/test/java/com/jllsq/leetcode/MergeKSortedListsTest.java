package com.jllsq.leetcode;

import com.jllsq.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKSortedListsTest {

    private MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

    @Test
    public void mergeKLists1() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode[] nodes = new ListNode[]{node,node1};
        ListNode result = mergeKSortedLists.mergeKLists1(nodes);
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(2,result.val);
        result = result.next;
        assertNull(result);

        node = new ListNode(1);
        node1 = new ListNode(2);
        nodes = new ListNode[]{null,node,null,node1};
        result = mergeKSortedLists.mergeKLists1(nodes);
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(2,result.val);
        result = result.next;
        assertNull(result);

        nodes = new ListNode[]{null,null,null,null};
        result = mergeKSortedLists.mergeKLists1(nodes);
        assertNull(result);

        node = new ListNode(1);
        node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        nodes = new ListNode[]{node,node1,node2};
        result = mergeKSortedLists.mergeKLists1(nodes);
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(1,result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void mergeKLists2() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode[] nodes = new ListNode[]{node,node1};
        ListNode result = mergeKSortedLists.mergeKLists2(nodes);
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(2,result.val);
        result = result.next;
        assertNull(result);

        node = new ListNode(1);
        node1 = new ListNode(2);
        nodes = new ListNode[]{null,node,null,node1};
        result = mergeKSortedLists.mergeKLists2(nodes);
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(2,result.val);
        result = result.next;
        assertNull(result);

        nodes = new ListNode[]{null,null,null,null};
        result = mergeKSortedLists.mergeKLists2(nodes);
        assertNull(result);

        node = new ListNode(1);
        node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        nodes = new ListNode[]{node,node1,node2};
        result = mergeKSortedLists.mergeKLists2(nodes);
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(1,result.val);
        result = result.next;
        assertEquals(1,result.val);
        result = result.next;
        assertNull(result);
    }
}