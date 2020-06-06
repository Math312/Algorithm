package com.jllsq.common

import spock.lang.Specification

class RBTreeTest extends Specification {
    void testLeftHand() {
        setup:

            /**
             *          2
             *         /
             *        0
             *         \
             *          1
             * 以1为中心左旋，将1变为顶点结果是
             *           2
             *          /
             *         1
             *        /
             *       0
             *
             * */
            RBTree rbTree = new RBTree();
            rbTree.root = new RBTree.RBTreeNode(2,2);
            RBTree.RBTreeNode n1 = new RBTree.RBTreeNode(0,0);
            rbTree.root.left = n1
            n1.parent = rbTree.root
            RBTree.RBTreeNode n2 = new RBTree.RBTreeNode(1,1);
            n2.parent = n1
            n1.right = n2

        /**
         *            2
         *         /    \
         *        0      4
         *         \    /
         *          1  3
         * 以4为中心左旋，将1变为顶点结果是
         *           4
         *         /
         *        2
         *       / \
         *      0  3
         *       \
         *        1
         * */

            RBTree rbTree1 = new RBTree();
            rbTree1.root = new RBTree.RBTreeNode(2,2);
            RBTree.RBTreeNode n3 = new RBTree.RBTreeNode(0,0);
            rbTree1.root.left = n3
            n3.parent = rbTree.root
            RBTree.RBTreeNode n4 = new RBTree.RBTreeNode(1,1);
            n4.parent = n3
            n3.right = n4
            RBTree.RBTreeNode n5 = new RBTree.RBTreeNode(4,4);
            n5.parent = rbTree1.root
            rbTree1.root.right = n5
            RBTree.RBTreeNode n6 = new RBTree.RBTreeNode(3,3);
            n6.parent = n5
            n5.left = n6
        when:
            rbTree.leftHand(rbTree.root.left.right);
            rbTree1.leftHand(n5)
        then:
            rbTree.root.left.key == 1
            rbTree.root.left.left.key == 0
            rbTree1.root.left.key == 2
            rbTree1.root.left.right.key == 3
            rbTree1.root.left.left.key == 0


    }

    void testRightHand() {
    }

    void testPut() {
        setup:
            RBTree rbTree1 = new RBTree()
        when:
            rbTree1.put(1,1);
        then:
            rbTree1.root.key == 1
            !rbTree1.root.color
    }

    void testPut2() {
        setup:
        RBTree rbTree1 = new RBTree()
        when:
        rbTree1.put(0,0);
        rbTree1.put(1,1);
        rbTree1.put(2,2);
        then:
        rbTree1.root.key == 1
        !rbTree1.root.color
        rbTree1.root.right.key == 2
        rbTree1.root.right.color
        rbTree1.root.left.key == 0
        rbTree1.root.left.color
    }

    void testPut3() {
        setup:
        RBTree rbTree1 = new RBTree()
        when:
        rbTree1.put(0,0);
        rbTree1.put(1,1);
        rbTree1.put(2,2);
        rbTree1.put(3,3)
        then:
        rbTree1.root.key == 1
        !rbTree1.root.color
        rbTree1.root.right.key == 2
        !rbTree1.root.right.color
        rbTree1.root.left.key == 0
        !rbTree1.root.left.color
        rbTree1.root.right.right.key == 3
        rbTree1.root.right.right.color
    }

    void testPut4() {
        setup:
        RBTree rbTree1 = new RBTree()
        when:
        rbTree1.put(0,0);
        rbTree1.put(1,1);
        rbTree1.put(2,2);
        rbTree1.put(3,3)
        rbTree1.put(4,4)
        then:
        rbTree1.root.key == 1
        !rbTree1.root.color
        rbTree1.root.right.key == 3
        !rbTree1.root.right.color
        rbTree1.root.left.key == 0
        !rbTree1.root.left.color
        rbTree1.root.right.right.key == 4
        rbTree1.root.right.right.color
        rbTree1.root.right.left.key == 2
        rbTree1.root.right.left.color
    }

    void testPut5() {
        setup:
        RBTree rbTree1 = new RBTree()
        when:
        rbTree1.put(0,0);
        rbTree1.put(1,1);
        rbTree1.put(2,2);
        rbTree1.put(3,3)
        rbTree1.put(4,4)
        rbTree1.put(5,5)
        then:
        rbTree1.root.key == 1
        !rbTree1.root.color
        rbTree1.root.right.key == 3
        rbTree1.root.right.color
        rbTree1.root.left.key == 0
        !rbTree1.root.left.color
        rbTree1.root.right.right.key == 4
        !rbTree1.root.right.right.color
        rbTree1.root.right.left.key == 2
        !rbTree1.root.right.left.color
        rbTree1.root.right.right.right.key == 5
        rbTree1.root.right.right.right.color
    }
}
