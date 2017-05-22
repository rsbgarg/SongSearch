package com.search;

public class TreeNode {
	
	String data;
	
	public TreeNode first;
	
	public TreeNode sibling;

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TreeNode getFirst() {
		return first;
	}

	public void setFirst(TreeNode first) {
		this.first = first;
	}

	public TreeNode getSibling() {
		return sibling;
	}

	public void setSibling(TreeNode sibling) {
		this.sibling = sibling;
	}
	

}
