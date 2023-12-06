package com.company.POCU;

class Solution {

    static class Node {
        private int data;

        private Node left;
        private Node right;

        private Node parent;

        public void setChilds(Node node) {
            left = node.left;
            right = node.right;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public boolean hasChild() {
            return left != null || right != null;
        }

        public static void print(Node node) {

            if (node == null) {
                return;
            }

            print(node.left);
            System.out.print(node.data + " ");
            print(node.right);
        }

        public static Node insertRecursive(Node node, final Node parent, int data) {

            if (node == null) {
                Node newNode = new Node(data);
                newNode.parent = parent;
                return newNode;
            }

            if (data < node.data) {
                node.left = insertRecursive(node.left, node, data);

            } else {
                node.right = insertRecursive(node.right, node, data);

            }

            return node;
        }

        public static void removeRecursive(final Node node, int data) {

            if (node == null) {
                throw new RuntimeException("삭제할 노드가 없습니다.");
            }

            if (node.left != null && node.left.data == data) {
                if(!node.left.hasChild()){
                    node.left = null;
                }else{
                    Node.remove(node.left);
                }
                return;
            } else if (node.right != null && node.right.data == data) {
                if(!node.right.hasChild()){
                    node.right = null;
                }else{
                    Node.remove(node.right);
                }
                return;
            }

            if (node.data > data) {
                removeRecursive(node.left, data);
            } else {
                removeRecursive(node.right, data);
            }
        }

        public static void remove(Node target) {

            if (target.left != null) {

                Node removeNode = target.left;

                while (removeNode.right != null) {
                    removeNode = removeNode.right;
                }

                target.data = removeNode.data;
                removeNode.parent.left = null;
            } else if (target.right != null) {

                Node removeNode = target.right;

                while (removeNode.left != null) {
                    removeNode = removeNode.left;
                }

                target.data = removeNode.data;
                removeNode.parent.right = null;
            }


            System.out.println("왼쪽노드 제거완료");
        }
    }

    public int solution() {
        int answer = 0;


        Node root = new Node(50);

        Node.insertRecursive(root, null, 24);
        Node.insertRecursive(root, null, 42);
        Node.insertRecursive(root, null, 33);
        Node.insertRecursive(root, null, 22);

        Node.insertRecursive(root, null, 55);
        Node.insertRecursive(root, null, 52);
        Node.insertRecursive(root, null, 57);

        int num = root.getData();

        Node.print(root);
        System.out.println();
        Node.removeRecursive(root, 42);

        Node.print(root);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        T.solution();
    }
}