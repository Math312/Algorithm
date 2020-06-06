package com.jllsq.common;

public class RBTree {

    RBTreeNode root;

    private static boolean RED = true;

    private static boolean BLACK = false;

    public static class RBTreeNode {
        RBTreeNode parent;
        int key;
        int content;
        boolean color;
        RBTreeNode left;
        RBTreeNode right;

        public RBTreeNode(int key,int content) {
            this.key = key;
            this.content = content;
        }
    }

    public RBTreeNode findLastNode(int value) {
        if (root == null) {
            return null;
        } else {
            RBTreeNode temp = root;
            while (true) {
                if (value == temp.key) {
                    return temp;
                } else {
                    if (value < temp.key) {
                        if (temp.left == null) {
                            return temp;
                        } else {
                            temp = temp.left;
                        }

                    } else {
                        if (temp.right == null) {
                            return temp;
                        } else {
                            temp = temp.right;
                        }
                    }
                }
            }
        }
    }


    public void put(int key, int value) {
        RBTreeNode node = findLastNode(value);
        if (node == null) {
            RBTreeNode newNode = new RBTreeNode(key,value);
            newNode.color = BLACK;
            this.root = newNode;
            return;
        }
        if (node.key == key) {
            node.content = value;
        } else {
            RBTreeNode newNode = new RBTreeNode(key, value);
            newNode.color = RED;
            newNode.parent = node;
            if (node.key < value) {
                node.right = newNode;
            } else {
                node.left = newNode;
            }
            adjustTree(newNode);
        }
    }

    private void adjustTree(RBTreeNode node) {
        if (node == root) {
            node.color = BLACK;
            return;
        }
        if (node.parent.color == BLACK) {
            return;
        } else {
            RBTreeNode grandFaNode = node.parent.parent;
            RBTreeNode parentNode = node.parent;
            int label = 0;
            RBTreeNode uncleNode = null;
            if (grandFaNode != null) {
                if (grandFaNode.left == parentNode) {
                    uncleNode = grandFaNode.right;
                    label = 1;
                } else {
                    uncleNode = grandFaNode.left;
                    label = 2;
                }
                boolean hasUncleNodeNeedProcessed = false;
                if (uncleNode != null) {
                    if (uncleNode.color == RED) {
                        grandFaNode.color = RED;
                        parentNode.color = BLACK;
                        uncleNode.color = BLACK;
                        adjustTree(grandFaNode);
                    } else {
                        hasUncleNodeNeedProcessed = true;
                    }
                } else {
                    hasUncleNodeNeedProcessed = true;
                }

                if (hasUncleNodeNeedProcessed){
                    int label2 = 0;
                    if (node == parentNode.left) {
                        label2 = 1;
                    } else {
                        label2 = 2;
                    }
                    if (label == 1) {
                        if (label2 == 1) {
                            rightHand(parentNode);
                            parentNode.color = BLACK;
                            grandFaNode.color = RED;
                        } else {
                            leftHand(node);
                            rightHand(parentNode);
                            node.color = BLACK;
                            grandFaNode.color = RED;
                        }
                    } else {
                        if (label2 == 1) {
                            rightHand(node);
                            leftHand(parentNode);
                            node.color = BLACK;
                            grandFaNode.color = RED;
                        } else {
                            leftHand(parentNode);
                            parentNode.color = BLACK;
                            grandFaNode.color = RED;
                        }
                    }
                }
            }
        }
    }

    public void leftHand(RBTreeNode node) {
        if (node == null || node.parent == null) {
            return;
        }
        if (node.parent.left == node) {
            return;
        }
        RBTreeNode parentNode = node.parent;
        RBTreeNode grandFaNode = parentNode.parent;
        if (node.left != null) {
            parentNode.right = node.left;
        }
        if (grandFaNode != null) {
            if (grandFaNode.left == parentNode) {
                grandFaNode.left = node;
                node.parent = grandFaNode;
            } else {
                grandFaNode.right = node;
                node.parent = grandFaNode;
            }
        } else {
            root = node;
            root.parent = null;
        }
        node.left = parentNode;
        parentNode.parent = node;

    }

    public void rightHand(RBTreeNode node) {
        if (node == null || node.parent == null) {
            return;
        }
        if (node.parent.right == node) {
            return;
        }
        RBTreeNode parentNode = node.parent;
        RBTreeNode grandFaNode = parentNode.parent;
        if (node.right != null) {
            parentNode.left = node.right;
        }
        if (grandFaNode != null) {
            if (grandFaNode.left == parentNode) {
                grandFaNode.left = node;
                node.parent = grandFaNode;
            } else {
                grandFaNode.right = node;
                node.parent = grandFaNode;
            }
        } else {
            root = node;
            root.parent = null;
        }
        node.right = parentNode;
        parentNode.parent = node;
    }

}
