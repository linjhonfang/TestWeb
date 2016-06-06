package com.testweb.testTree;

/**
 * Created by xingxuechao on 16/6/3.
 */
public class ReverseTree {

    class Node{
        Node l;
        Node r;
        String v;

        public Node(Node l, Node r, String v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }
    }

    public void reverseTree(Node node){
        if(node==null){
            return ;
        }
        Node tmp = node.l;
        node.l = node.r;
        node.r = tmp;
        reverseTree(node.l);
        reverseTree(node.r);
    }

    public void println(Node[] nodes){
        Node[] nodes1 = new Node[nodes.length*2];
        int length = 0;
        for(int i = 0 ;i<nodes.length&&nodes[i]!=null;i++){
            System.out.print(nodes[i].v+" ## ");
            if(nodes[i].l!=null){
                nodes1[length++] = nodes[i].l;
            }
            if(nodes[i].r!=null){
                nodes1[length++] = nodes[i].r;
            }
        }
        System.out.println();
        System.out.println("____________________________");
        if(length==0)return ;
        println(nodes1);
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

    public static void main(String args[]){
        ReverseTree reverseTree = new ReverseTree();
        Node rootNode = reverseTree.getTree();
        Node[] nodes = new Node[]{rootNode};
        reverseTree.println(nodes);
        reverseTree.reverseTree(rootNode);
        reverseTree.println(nodes);
    }
}
