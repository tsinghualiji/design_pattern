package com.adobe.www.structure.composite;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 组合模式:
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等
 */
public class CompositeTest {

	Tree tree =  new Tree("A");
	TreeNode nodeB = new TreeNode("B");
	TreeNode nodeC = new TreeNode("C");
}


class Tree{
	
	TreeNode root = null;
	
	public Tree(String name){
	
		root = new TreeNode(name);
		
	}
	
}


class TreeNode{
	
	private String name;

	private TreeNode parent;
	
	private List<TreeNode> children = new ArrayList<TreeNode>();
	
	public TreeNode(String name){
		
		this.name = name;
		
	}
	
	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	public void setName(String name){
		
		this.name = name;
		
	}
	
	public String getName(){
		
		return name;
	}
	
	public void add(TreeNode node){
		
		children.add(node);
		
	}
	
	public void remove(TreeNode node){
		
		children.remove(node);
		
	}
	
}