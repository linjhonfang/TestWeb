package com.testweb.testTree;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {
	
	public static void main(String args[]){
		Node node = Node.getTree();
		Node[] nodes = {node};
		Node.getAllBorther(nodes);
		Node.print(nodes);
	}
}
class Node{
	Node rNode;
	Node lNode;
	String value;
	Node bNode;
	public Node(Node rNode, Node lNode, String value){
		this.rNode = rNode;
		this.lNode = lNode;
		this.value = value;
	}
	public void getBorther(Node fNode){
		if(fNode==null)return;
		if(fNode.rNode!=null){
			if(fNode.rNode == this||fNode.lNode!=null){
				this.bNode = fNode.lNode;
			}
			this.bNode = fNode.rNode;
		}else if(fNode.lNode!=null){
			this.bNode = fNode.lNode;
		}else{
			getBorther(fNode.bNode);
		}
	}
	public static void getAllBorther(Node[] rootNode){
		if(rootNode==null)return;
		for(int i=0;i<rootNode.length;i++){
			if(rootNode[i].rNode!=null){
				rootNode[i].rNode.getBorther(rootNode[i]);
			}
			if(rootNode[i].lNode!=null){
				rootNode[i].lNode.getBorther(rootNode[i]);
			}
		}
		
	}
	
	
	public static Node getTree(){
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
	
	public static void print(Node[] array){
		if(array==null)return;
		List<Node> childList = new ArrayList<Node>();
		for(int i=0;i<array.length;i++){
			System.out.print(array[i].value);
			if(i!=array.length-1){
				System.out.print("      ");
			}
			if(array[i].rNode!=null){
				childList.add(array[i].rNode);
			}
			if(array[i].lNode!=null){
				childList.add(array[i].lNode);
			}
		}

		//print(childList.toArray(new Node[0]));
	}
}
