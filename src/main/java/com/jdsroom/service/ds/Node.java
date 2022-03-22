package com.jdsroom.service.ds;

public class Node {

	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
	}

	public int data() {
		return data;
	}

	public Node next() {
		return next;
	}
}
