package com.jimsun.LinkedTable;

public class PrimaryAlgorithm {
	//private ListNode head = null;
	//定义链表节点的内部类
	static class ListNode {
		   int val;//节点value
		   ListNode next;//指向下一个节点
		   ListNode(int x) { 
			   val = x; 
		   }
	}
	/*删除链表中的节点
	 *编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
	 *输入: head = [4,5,1,9], node = 5
	 *输出: [4,1,9]
	 *解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
	 * */
	 public void deleteNode(ListNode node) {
	      if(node.next == null || node == null) {
	    	  node = null;
	    	  return;
	      }
	      ListNode next = node.next;
	      node.val = next.val;
	      node.next =next.next;  
	      next =null;
	 }
	 /*删除链表的倒数第N个节点
	  *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	  *给定一个链表: 1->2->3->4->5, 和 n = 2.
	  *当删除了倒数第二个节点后，链表变为 1->2->3->5.
	  *说明：给定的 n 保证是有效的。
	  *进阶：
	  *你能尝试使用一趟扫描实现吗？
	  * */
	  public ListNode removeNthFromEnd(ListNode head, int n) {
		  if(head == null)
			  return head;
		  ListNode node = head;
		  ListNode next = head;
		  while(--n>0 ) {
			  next = next.next;
			  if(next == null)
				  return head;
		  }
		  ListNode preNode=node;
		  while(next != null) {
			  if(next.next != null) {
				  next = next.next;
				  preNode = node;
				  node = node.next;
			  }else {
				  if(preNode == node) {
                      head = node.next;
					  return head;
				  }
				  preNode.next = node.next;
				  node = null;
				  break;
			  }
		  }
		  return head;
	  }
	  public ListNode removeNthFromEndImprove(ListNode head, int n) {
	        ListNode dummyHead = new ListNode(0);
	        dummyHead.next =head;
	        
	        ListNode p = dummyHead;
	        ListNode q = dummyHead;
	        
	        for(int i=0;i<n+1;i++){
	            q=q.next;
	        }
	        while(q!=null){
	            p=p.next;
	            q=q.next;
	        }
	        ListNode del = p.next;
	        p.next = del.next;
	     
	        return dummyHead.next;
	        
	    }
}
