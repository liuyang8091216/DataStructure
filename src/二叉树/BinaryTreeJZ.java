package ������;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * ʵ�ֶ������Ľ����Լ�����
 * @author ������
 *
 * 2017��2��23��
 */
public class BinaryTreeJZ {
	
	private static Node root; //���ڵ�
	
	public Node createBiTree(Node node,Scanner sc){
		String temp = sc.next();
		if(temp.trim().equals("#")){
			return null;
		} else {
			node = new Node();
			node.value = temp;
			node.left = createBiTree(node.left,sc);
			node.right = createBiTree(node.right,sc);
			return node;
		}
	}
	

	public void preOrder(Node node){
		if(node !=null){
			System.out.println(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("E:\\Program Files (x86)\\javaEclipse\\workspace\\DataStructure\\src\\������\\input.txt"));
		BinaryTreeJZ b = new BinaryTreeJZ();
		b.root = b.createBiTree(root, sc);
		b.preOrder(root);
	}
	
	
}

/**
 * ����һ�����
 * @author ������
 *
 * 2017��2��24��
 */
class Node{
	String value;
	Node left;
	Node right;
}
