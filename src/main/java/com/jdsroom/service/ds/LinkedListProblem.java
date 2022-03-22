package com.jdsroom.service.ds;

public class LinkedListProblem {

	public static void main(String[] args) {
		// creating a singly linked list
		SinglyLinkedList.Node head = new SinglyLinkedList.Node(1);
		SinglyLinkedList linkedlist = new SinglyLinkedList(head);
		// adding node into singly linked list
		linkedlist.add(new SinglyLinkedList.Node(2));
		linkedlist.add(new SinglyLinkedList.Node(3));
		// printing a singly linked list
		linkedlist.print();
		// reversing the singly linked list
		linkedlist.reverse();
		// // printing the singly linked list again
		linkedlist.print();
	}
}
