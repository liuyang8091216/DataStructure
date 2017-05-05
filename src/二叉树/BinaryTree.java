/*package 二叉树;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

*//**
 * ===================================================
 * 二叉树经典递归设计~~重新认识了递归和树~用递归解决树的遍历，实在太方便了
 * ===================================================
 * 二叉树的定义：或为空，或只有根节点，或有左子树和右子树（5种基本形态）
 * 二叉树性质：
 * 1、在二叉树的第i层上至多有2^(i-1)个结点（i>=1）
 * 2、深度为k的二叉树至多有2^(k) - 1个结点（k>=1）
 * 3、对于任何一颗二叉树，如果其终端结点数为n，度数为2的结点数为m，则n = m + 1
 * 4、具有n个结点的完全二叉树的深度为k = floor(log2(n)) + 1
 * 5、在含有n个结点的二叉链表中有n+1个空链域
 * 
 * @author 小菜鸟
 *创建时间：2014-08-10
 *//*

public class BinaryTree<T> {

	*//**二叉树的根节点*//*
	private Node<T> root;
	
	public BinaryTree(){}
	public BinaryTree(Node<T> root){
		this.root = root;
	}
	
	*//**先序遍历创建二叉树*//*
	*//**input.txt: - + a # # * # # / e # # f # #
	 * A B D H # # I # # E # J # # C F # K # # G # #
	 * # 代表空结点
	 *//*
	public void createBiTree(){
		Scanner scn = null;
		
		try {
			scn = new Scanner(new File("E:\\Program Files (x86)\\javaEclipse\\workspace\\DataStructure\\src\\二叉树\\input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.root = createBiTree(root, scn);
	}
	
	private Node<T> createBiTree(Node<T> node, Scanner scn) {
		
		String temp = scn.next();
		//System.out.println("----->>>" + temp);
		if(temp.trim().equals("#")){
			return null;
		}
		else{
			node = new Node<T>((T)temp);
			node.setLeft(createBiTree(node.getLeft(), scn));
			node.setRight(createBiTree(node.getRight(), scn));
			return node;
		}
	}
	
	*//**先序递归遍历二叉树*//*
	public void preOrderTraverse(){
		preOrderTraverse(root);
	}
	private void preOrderTraverse(Node<T> node) {
		if(node != null){
			System.out.println(node.getValue());
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}
	
	
	*//**先序非递归遍历二叉树*//*
	public void nrPreOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				System.out.println(node.getValue());
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			node = node.getRight();
		}
	}
	
	
	
	*//**中序递归遍历二叉树*//*
	public void inOrderTraverse(){
		inOrderTraverse(root);
	}
	private void inOrderTraverse(Node<T> node) {
		if(node != null){
			inOrderTraverse(node.getLeft());
			System.out.println(node.getValue());
			inOrderTraverse(node.getRight());
		}
	}
	
	*//**中序非递归遍历二叉树*//*
	public void nrInOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			System.out.println(node.getValue());
			node = node.getRight();
		}
	}
	
	*//**后序递归遍历二叉树*//*
	public void postOrderTraverse(){
		postOrderTraverse(root);
	}
	private void postOrderTraverse(Node<T> node) {
		if(node != null){
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.println(node.getValue());
		}
	}
	
	*//**后序非递归遍历二叉树*//*
	public void nrPostOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		Node<T> preNode = null;	//记录之前遍历的右结点
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.getTop();
			
			*//**如果右结点为空，或者右结点之前遍历过，打印根结点*//*
			if(node.getRight() == null || node.getRight() == preNode){
				System.out.println(node.getValue());
				node = stack.pop();
				preNode = node;
				node = null;
			}
			else{
				node = node.getRight();
			}
		}
	}
	
	
	*//**层次遍历二叉树*//*
	public void levelTraverse(){
		levelTraverse(root);
	}
	private void levelTraverse(Node<T> node) {
		Queue<Node<T>> queue = new Queue<Node<T>>();
		queue.push(node);
		while(!queue.isEmpty()){
			node = queue.pop();
			if(node != null){
				System.out.println(node.getValue());
				queue.push(node.getLeft());
				queue.push(node.getRight());
			}
		}
	}
	
	
	public static void main(String[] args){
		BinaryTree<String> bt = new BinaryTree<String>();
		bt.createBiTree();
		bt.preOrderTraverse();
		//bt.inOrderTraverse();
		//bt.postOrderTraverse();
		
		
		
		//bt.nrPreOrderTraverse();
		//bt.nrInOrderTraverse();
		//bt.nrPostOrderTraverse();
		//bt.levelTraverse();
	}
}

class Node<T>{
	private T value;
	private Node<T> left;
	private Node<T> right;
	
	public Node(){
	}
	public Node(Node<T> left, Node<T> right, T value){
		this.left = left;
		this.right = right;
		this.value = value;
	}
	public Node(T value){
		this(null, null, value);
	}
	
	public Node<T> getLeft(){
		return this.left;
	}
	public void setLeft(Node<T> left){
		this.left = left;
	}
	public Node<T> getRight(){
		return this.right;
	}
	public void setRight(Node<T> right){
		this.right = right;
	}
	public T getValue(){
		return this.value;
	}
	public void setValue(T value){
		this.value = value;
	}
}

*/