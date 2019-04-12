package com.jimsun.ClassicProblem;

public class PrimaryAlgorithm {
	static class Node{
		private int val;
		private Node next;
		Node (int val){
			this.val = val;
		}
		void setVal(int num) {
			this.val = num;
		}
		int getVal() {
			return this.val;
		}
		void setNext(Node next) {
			this.next = next;
		}
		Node getNext() {
			return this.next;
		}
		void deleteNode() {
			if(next != null)
			{
				this.val = next.val;
				next = next.next;
			}
		}
	}
	class CircularLinkedList{
		private Node head = null;
		private Node tail = null;
		public void addNode(int data) {
			Node node =new Node(data);
			if(head == null) {
				head = node;
			    head.setNext(head);
			    tail = head;
			}else {		
				tail.setNext(node);
				node.setNext(head);
				tail = node;
			}
		}
	}
	/*约瑟夫环问题
	 * */
	//循环链表方式:
	public void JosephRingLinkedList(int n,int m) {
		if(m < 1 || n <= 0)
			return;
		CircularLinkedList list = new CircularLinkedList();
		for(int i = 1;i <= n;++i)
			list.addNode(i);
		int count = 1 , num = 1;
		Node node  = list.head;
		while(true) {	
			if(num >= m) {
				++count;
			    System.out.print(node.getVal());
			    node.deleteNode();
				num = 1;
				continue;
			}		
			if(count == n)
				break;		
			node = node.getNext();
			++num;
		}
		System.out.println();
		System.out.println(node.getVal());
	}
	//数组方式：
	public void JosephRingArray(int n,int m) {
		if(m < 1 || n <= 0)
			return;
		boolean[] arr = new boolean[n];
		int count = 1 ,num = 0;
		int index = 0;
		int preIndex = index;
		while(true) {
			if(count == n) {
				break;
			}
			if(!arr[index]) {
				++num;
				if(num >= m) {
					num = 0;
					++count;
					System.out.print(index+1);
					arr[index] = true;
				}else {
					preIndex = index;
				}
			}
			++index;
			if(index >= n)
				index = index % n;
		}
		System.out.println();
		System.out.println(preIndex+1);
	}
}
