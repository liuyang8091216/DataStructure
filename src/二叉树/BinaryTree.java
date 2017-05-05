/*package ������;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

*//**
 * ===================================================
 * ����������ݹ����~~������ʶ�˵ݹ����~�õݹ������ı�����ʵ��̫������
 * ===================================================
 * �������Ķ��壺��Ϊ�գ���ֻ�и��ڵ㣬��������������������5�ֻ�����̬��
 * ���������ʣ�
 * 1���ڶ������ĵ�i����������2^(i-1)����㣨i>=1��
 * 2�����Ϊk�Ķ�����������2^(k) - 1����㣨k>=1��
 * 3�������κ�һ�Ŷ�������������ն˽����Ϊn������Ϊ2�Ľ����Ϊm����n = m + 1
 * 4������n��������ȫ�����������Ϊk = floor(log2(n)) + 1
 * 5���ں���n�����Ķ�����������n+1��������
 * 
 * @author С����
 *����ʱ�䣺2014-08-10
 *//*

public class BinaryTree<T> {

	*//**�������ĸ��ڵ�*//*
	private Node<T> root;
	
	public BinaryTree(){}
	public BinaryTree(Node<T> root){
		this.root = root;
	}
	
	*//**�����������������*//*
	*//**input.txt: - + a # # * # # / e # # f # #
	 * A B D H # # I # # E # J # # C F # K # # G # #
	 * # ����ս��
	 *//*
	public void createBiTree(){
		Scanner scn = null;
		
		try {
			scn = new Scanner(new File("E:\\Program Files (x86)\\javaEclipse\\workspace\\DataStructure\\src\\������\\input.txt"));
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
	
	*//**����ݹ����������*//*
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
	
	
	*//**����ǵݹ����������*//*
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
	
	
	
	*//**����ݹ����������*//*
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
	
	*//**����ǵݹ����������*//*
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
	
	*//**����ݹ����������*//*
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
	
	*//**����ǵݹ����������*//*
	public void nrPostOrderTraverse(){
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		Node<T> preNode = null;	//��¼֮ǰ�������ҽ��
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.getTop();
			
			*//**����ҽ��Ϊ�գ������ҽ��֮ǰ����������ӡ�����*//*
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
	
	
	*//**��α���������*//*
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