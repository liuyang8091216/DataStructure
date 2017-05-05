package 二叉树;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * 实现二叉树的建立以及遍历
 * @author 刘阳阳
 *
 * 2017年2月23日
 */
public class BinaryTreeJZ {
	
	private static Node root; //根节点
	
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
		Scanner sc = new Scanner(new File("E:\\Program Files (x86)\\javaEclipse\\workspace\\DataStructure\\src\\二叉树\\input.txt"));
		BinaryTreeJZ b = new BinaryTreeJZ();
		b.root = b.createBiTree(root, sc);
		b.preOrder(root);
	}
	
	
}

/**
 * 创建一个结点
 * @author 刘阳阳
 *
 * 2017年2月24日
 */
class Node{
	String value;
	Node left;
	Node right;
}
