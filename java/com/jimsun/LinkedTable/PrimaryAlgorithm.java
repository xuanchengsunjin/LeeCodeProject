package com.jimsun.LinkedTable;

import java.util.Stack;

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
	  /*
	   *反转一个单链表。
	   *输入: 1->2->3->4->5->NULL
	   *输出: 5->4->3->2->1->NULL 
	   *进阶:
	   *你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	   * */
	   public ListNode reverseList(ListNode head) {
	        if(head ==null || head.next == null)
	        	return head;
	        ListNode pre = head;
	        ListNode now = pre.next;
	        ListNode next = now.next;
	        head.next = null;
	        while(true) {
	        	now.next = pre;
	        	pre = now;
	        	now = next;
	        	if(next != null)
	        		next = next.next;
	        	else {
	        		return pre;
	        	}
	        }
	   } 
	   //递归方式：me
	   public ListNode reverseListRecursive(ListNode head) {
		   if(head == null || head.next == null)
	             return head;
	         ListNode now = head.next;
	         head.next = null;
	         return reverse(head,now);    	
	   }
	   public ListNode reverse(ListNode pre ,ListNode now){
	         if(now == null)
	             return pre;
	          ListNode next = now.next;
	          now.next = pre;
	          return reverse(now,next);                                             
	    }
	   //递归方式：other
	   public ListNode reverseListAnother(ListNode head) {
	        if (head == null || head.next == null) return head; //处理最小输入的情况，即空链表和单节点链表
	        ListNode second = head.next; //将即将被调用的下一个节点分离，即将下一个调用的输入存在second里
	        ListNode reverseHead = reverseListAnother(second); //将调用后的结果存储，这个结果就是最终结果。之后利用递归，调用刚才存好的输入
	        second.next = head; //上面一步的调用已经完成以second为首的链表的反转，所以现在second变成了反转完成后的尾节点
            //把这个尾节点的next指向一开始输入的前驱，即head，完成整个链表反转
	        head.next = null; //最开始的头节点要变成尾节点，即在后面补null使链表终结
	        return reverseHead; 
	    }
	    /*合并两个有序链表
	     *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
	     *输入：1->2->4, 1->3->4
	     *输出：1->1->2->3->4->4
	     * */
	     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    	ListNode head = new ListNode(0);
	    	ListNode nodeA = l1;
	    	ListNode nodeB = l2;
	    	ListNode temp = head;
	        while(nodeA != null && nodeB != null) {
	        	if(nodeA.val <= nodeB.val) {
	        		temp.next = nodeA;
	        		temp = nodeA;
	        		nodeA = nodeA.next;
	        	}else {
	        		temp.next = nodeB;
	        		temp = nodeB;
	        		nodeB = nodeB.next;
	        	}
	        }
	        temp.next = nodeA == null ? nodeB :nodeA;
	        return head.next;      
	     } 
	     public ListNode mergeTwoListsImprove(ListNode l1, ListNode l2) {
	         if(l1 == null) return l2;
	         if(l2 == null) return l1;
	         ListNode dummy = new ListNode(0);
	         dummy.next = l1;
	         ListNode cur = dummy;
	         //dummy的next始终指向l1，因此只需调整l2
	         while(l1!=null && l2 != null){
	             if(l1.val<=l2.val){
	                 l1 = l1.next;
	             }else{
	                 ListNode next = l2.next;
	                 
	                 l2.next = cur.next;
	                 cur.next = l2;
	                 
	                 l2 = next;
	             }
	             cur = cur.next;
	         }
	         if(l2!=null){
	             cur.next = l2;
	         }
	         return dummy.next;
	     }
	     /*回文链表
	      *请判断一个链表是否为回文链表。
	      *输入: 1->2
	      *输出: false
	      *
	      *输入: 1->2->2->1
	      *输出: true
	      *进阶：
	      *你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
	      * */
	     public boolean isPalindrome(ListNode head) {
	    	 if(head == null || head.next == null)
	    		 return true;
	         Stack<ListNode> stack = new  Stack<ListNode>();
	         ListNode slow = head;
	         ListNode fast = head;
	         while(fast.next != null) {
	        	 stack.push(slow);
	        	 fast = fast.next.next;
	        	 if(fast == null)
	        		 break;
	        	 slow = slow.next;	 
	         }
	         slow = slow.next; 
	         while(slow != null && !stack.isEmpty()) {
	        	 if(stack.pop().val != slow.val)
	        		 return false;
	        	 slow = slow.next;
	         }
	         return true;
	     }
	     //进阶：反转后半部分链表
	     
	     /*环形链表
	      *给定一个链表，判断链表中是否有环。
	      *为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
	      *如果 pos 是 -1，则在该链表中没有环。
	      *输入：head = [3,2,0,-4], pos = 1
	      *输出：true
	      *解释：链表中有一个环，其尾部连接到第二个节点。
	      * */
	      public boolean hasCycle(ListNode head) {
	    	 if(head == null || head.next ==null) 
	    		 return false;
	         ListNode slow = head;
	         ListNode fast = head;
	         while(fast != null && fast.next != null) {
	        	 slow = slow.next;
	        	 fast = fast.next.next;
	        	 if(slow == fast)
	        		 return true;
	         }
	         return false;
	      } 
	     
}
