package com.testweb.testTree;

/**
 * Created by xingxuechao on 16/6/2.
 */
public class BrotherTree {

    class Node{
        Node leftNode;
        Node rightNode;
        Node brotherNode;
        String value;

        public Node(Node leftNode, Node rightNode, Node brotherNode, String value) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.brotherNode = brotherNode;
            this.value = value;
        }

        public Node(Node leftNode, Node rightNode, String value) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.value = value;
        }
    }

    public void traversalOnBro(Node rootNode){
        if(rootNode==null){
            return;
        }
        Node rootLoop = rootNode;
        System.out.print(rootLoop.value+" ## ");
        while(rootLoop.brotherNode!=null){
            System.out.print(rootLoop.brotherNode.value+" ## ");
            rootLoop = rootLoop.brotherNode;
        }
        System.out.println("");
        System.out.println("_____________________________floorNode="+rootNode.value + "  brother="+rootNode.brotherNode);
        if(rootNode.leftNode!=null){
            traversalOnBro(rootNode.leftNode);
        }else if(rootNode.rightNode!=null){
            traversalOnBro(rootNode.rightNode);
        }
    }

    public void traversal(Node[] node){
        Node[] sonNode = new Node[node.length*2];
        int length = 0;
        for (int i = 0; i < node.length && node[i] != null; i++) {
            System.out.print(node[i].value+"("+(node[i].brotherNode!=null?node[i].brotherNode.value:"null")+")"+" ## ");
            if(node[i].leftNode!=null){
                sonNode[length]=node[i].leftNode;
                length++;
            }
            if(node[i].rightNode!=null){
                sonNode[length]=node[i].rightNode;
                length++;
            }
        }
        System.out.println();
        System.out.println("--------------------------");
        if(length==0)return;
        traversal(sonNode);
    }

    public void findBrother(Node rootNode){
        if(rootNode==null){
            return;
        }
        Node traversalNode = rootNode.leftNode;
        Node firstNode = rootNode.leftNode;
        if(rootNode.leftNode!=null) {
            traversalNode = rootNode.leftNode;
            if (rootNode.rightNode != null) {
                rootNode.leftNode.brotherNode = rootNode.rightNode;
                traversalNode = rootNode.rightNode;
            }
        }else if(rootNode.rightNode!=null){
            traversalNode = rootNode.rightNode;
            firstNode = rootNode.rightNode;
        }
        if (traversalNode != null) {
            if (rootNode.brotherNode != null) {
                Node rootLoop = rootNode;
                Node rootLoopBefore = traversalNode;
                while (rootLoop.brotherNode != null) {
                    if (rootLoop.brotherNode.leftNode != null) {
                        rootLoopBefore.brotherNode = rootLoop.brotherNode.leftNode;
                        rootLoopBefore = rootLoopBefore.brotherNode;
                    }
                    if (rootLoop.brotherNode.rightNode != null) {
                        rootLoopBefore.brotherNode = rootLoop.brotherNode.rightNode;
                        rootLoopBefore = rootLoopBefore.brotherNode;
                    }
                    rootLoop = rootLoop.brotherNode;

                }
            }
        }
        if(traversalNode!=null){
            findBrother(firstNode);
        }
    }

    public void findBrother(Node[] nodes) {

        Node[] sonNode = new Node[nodes.length * 2];
        int length = 0;
        for (int i = 0; i < nodes.length && nodes[i] != null; i++) {
            if (i != nodes.length - 1) {
                nodes[i].brotherNode = nodes[i + 1];
            }
            if (nodes[i].leftNode != null) {
                sonNode[length] = nodes[i].leftNode;
                length++;
            }
            if (nodes[i].rightNode != null) {
                sonNode[length] = nodes[i].rightNode;
                length++;
            }
        }
        if(length==0)return;
        findBrother(sonNode);
    }
    public Node getTree(){
        Node node000 = new Node(null,null,"node000");
        Node node001 = new Node(null,null,"node001");
        Node node00 = new Node(node000,node001,"node00");
        Node node0 = new Node(node00,null,"node0");

        Node node110 = new Node(null,null,"node110");
        Node node111 = new Node(null,null,"node111");
        Node node11 = new Node(node110,node111,"node11");
        Node node1 = new Node(null,node11,"node1");

        Node node = new Node(node0,node1,"node");

        return node;
    }

    public static void main(String args[]) {
        BrotherTree brotherTree = new BrotherTree();
        Node rootNode = brotherTree.getTree();
        //brotherTree.findBrother(rootNode);
//        brotherTree.traversalOnBro(rootNode);
        Node[] nodes = new Node[]{rootNode};
//        brotherTree.findBrother(nodes);
//        brotherTree.traversal(nodes);

        brotherTree.findBrother(rootNode);
        brotherTree.traversal(nodes);

    }

}
