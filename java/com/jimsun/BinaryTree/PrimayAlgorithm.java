package com.jimsun.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PrimayAlgorithm {
	//二叉树类节点
	static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	  }
	/*二叉树最大深度
	 *给定一个二叉树，找出其最大深度。
	 *二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	 *说明: 叶子节点是指没有子节点的节点。 
	 * */
	 //递归方式：
	 public int maxDepth(TreeNode root) {
		 if(root == null)
			 return 0;
		 int leftDep = maxDepth(root.left);
		 int rightDep = maxDepth(root.right);
		 return leftDep > rightDep ?  leftDep + 1 :rightDep + 1;
	 }
	 //非递归方式:
	 public int maxDepthImprove(TreeNode root) {
		 return 0;
	 }
	 /*验证二叉搜索树
	  *给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	  *假设一个二叉搜索树具有如下特征：
	  *节点的左子树只包含小于当前节点的数。
	  *节点的右子树只包含大于当前节点的数
	  *所有左子树和右子树自身必须也是二叉搜索树。
	  * */
	  //中序遍历非递归方式：
	  public boolean isValidBST(TreeNode root) {
	       Stack<TreeNode> stack = new Stack<TreeNode>();
	       TreeNode head = root;
	       TreeNode preNode = null;
	       while(!stack.isEmpty() || head!= null) {
	    	   if(head != null) {
	    		   stack.push(head);
	    		   head = head.left;
	    	   }else {
	    		   head = stack.pop();
	    		   if(preNode != null && (preNode.val >= head.val))
	    			   return false;
	    		   preNode = head;
	    		   head = head.right;
	    	   }
	       }
	       return true;
	  }
	  //递归方式：
	  public boolean isValidBSTImprove(TreeNode root) {
	        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	  }
	  boolean isValidBST(TreeNode root, long minVal, long maxVal) {
	        if (root == null) return true;
	        if (root.val >= maxVal || root.val <= minVal) return false;
	        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	  }
	  /*对称二叉树
	   *给定一个二叉树，检查它是否是镜像对称的。
	   * */
	  //递归方式：
	  public boolean isSymmetric(TreeNode root) {
	        if(root == null)
	        	return true;
	        return isSymme(root.left, root.right);	        
	  }
	  boolean isSymme(TreeNode left ,TreeNode right) {
		  if(left == null && right == null)
			  return true;
		  if(left == null || right == null || left.val != right.val) 
			  return false;
		  return isSymme(left.left,right.right) && isSymme(left.right, right.left);
	  }
	  //非递归方式：
	  public boolean isSymmetricImprove(TreeNode root) {
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  if(root == null)
			  return true;
		  stack.push(root.left);
		  stack.push(root.right);
		  while(!stack.isEmpty()) {
			  TreeNode node1 = stack.pop();
			  TreeNode node2 = stack.pop();
			  if(node1 == null && node2 == null)
				  continue;
			  if(node1 == null || node2 == null || node1.val != node2.val)
				  return false;
			  stack.push(node1.right);stack.push(node2.left);
			  stack.push(node1.left);stack.push(node2.right);
		  }
		  return true;
	  }
	  /*二叉树层序遍历
	   *给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
	   * */
	  public List<List<Integer>> levelOrder(TreeNode root) {
		  List<List<Integer>> list = new LinkedList<List<Integer>>(); 
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  if(root == null)
			  return null;
		  queue.add(root);
		  int length =1;
		  int newLength =0;
		  while(!queue.isEmpty()) {
			  List<Integer> container = new LinkedList<Integer>();
			  for(int i = 0;i <length;i++) {
				  TreeNode node = queue.poll();
				  container.add(node.val);
				  if(node.left != null) {
					  ++newLength;
					  queue.add(node.left);
				  }
				  if(node.right != null) {
					  ++newLength;
					  queue.add(node.right);
				  }
			  }
			  list.add(container);
			  container = null;
			  length = newLength;
			  newLength =0;
		  }
		  return list;
	  }
	  /*将有序数组转换为二叉搜索树
	   *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
	   *本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
	   * */
	  public TreeNode sortedArrayToBST(int[] nums) {
		  if(nums.length == 0)
			  return null;
	      return buildTree(nums, 0,nums.length -1);
	  }
	  TreeNode buildTree(int[] arr,int start,int end) {
		  int length = end - start;
		  if(length == 0)
			  return new TreeNode(arr[start]);
		  if(length == 1) {
			  TreeNode node = new TreeNode(arr[end]);
			  node.left = new TreeNode(arr[start]);
			  return node;
		  }
		  TreeNode head = new TreeNode(arr[start + length/2]);
		  head.left = buildTree(arr, start, start + length/2-1);
		  head.right = buildTree(arr, start + length/2+1, end);
		  return head;
	  }
	  //更加简洁的递归方式
	  public TreeNode sortedArrayToBSTImprove(int[] nums) {
	      return build_tree(nums, 0, nums.length);
	  }
	  public TreeNode build_tree(int[] nums, int begin, int end){
	      if(begin == end) return null;
	      int middle = (begin+end)/2;
	      TreeNode node = new TreeNode(nums[middle]);
	      node.left = build_tree(nums, begin, middle);
	      node.right = build_tree(nums, middle+1, end);
	      return node;
	  }
	  /*路径和
	   *给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
	   *说明: 叶子节点是指没有子节点的节点。
	   * */
	  public boolean hasPathSum(TreeNode root, int sum) {
		  if(root == null)
			  return false;
	      if(root.val == sum && root.right == null && root.left == null) 
	          return true; 
	      return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
	    }
	  /*二叉树非递归方式遍历
	   *前序遍历 && 中序遍历　&& 后序遍历
	   * */
	  //前序遍历
	  public List<Integer> preorderTraversal(TreeNode root) {
		  List<Integer> list = new LinkedList<Integer>();
		  if(root == null)
			  return list;  
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  stack.push(root);
		  TreeNode node = null;
		  while(!stack.isEmpty()) {
			  node = stack.pop();
			  list.add(node.val);
			  if(node.right != null)
				  stack.push(node.right);
			  if(node.left != null)
				  stack.push(node.left);
		  }	  
		  return list;
	  }
	  //中序遍历
	  public List<Integer> inorderTraversal(TreeNode root) {
		  List<Integer> list = new LinkedList<Integer>();
		  if(root == null)
			  return list;
		  Stack<TreeNode> stack = new Stack<TreeNode>();
		  while(!stack.isEmpty() || root != null) {
			  if(root != null) {
				 stack.push(root);
				 root = root.left;
			  }else {
				  root = stack.pop();
				  list.add(root.val);
				  root = root.right;
			  }
		  }
		  return list;
	  }
	  //后序遍历
	  public List<Integer> postorderTraversal(TreeNode root) {
		  List<Integer> list = new LinkedList<Integer>();
		  if(root == null)
			  return list;
		  Stack<TreeNode> s1 = new Stack<TreeNode>();
		  Stack<TreeNode> s2 = new Stack<TreeNode>();
		  s1.push(root);
		  while(!s1.isEmpty()) {
			  root = s1.pop();
			  s2.push(root);
			  if(root.left != null)
				  s1.push(root.left);
			  if(root.right != null)
				  s1.push(root.right);
		  }
		  while(!s2.isEmpty()) {
			  list.add(s2.pop().val);
		  }
		  return list;
	  }
	  /*从中序与后序遍历序列构造二叉树
	   *根据一棵树的中序遍历与后序遍历构造二叉树。
	   *注意:
	   *你可以假设树中没有重复的元素。
	   *
	   *例如，给出
	   *中序遍历 inorder = [9,3,15,20,7]
	   *后序遍历 postorder = [9,15,7,20,3] 
	   * */
	  public TreeNode buildTree(int[] inorder, int[] postorder) {
	       TreeNode root = null;
	       int inLength = inorder.length;
	       int postLength = postorder.length;
           if(inLength ==0 || postLength == 0)
              return root;
	       root =bulidNode(inorder,0,inLength-1 ,postorder,0,postLength-1); 
	       return root;
	  }
	  public TreeNode bulidNode(int[] inorder,int start1,int end1 ,int[] postorder,int start2,int end2) {
		  TreeNode node = new TreeNode(postorder[end2]);       
		  int rootIndex =  getRootIndex(inorder,postorder[end2]);
		  int leftLength = rootIndex - start1;
		  int rightLength = end1 - rootIndex;
          TreeNode left = null;
          TreeNode right = null;
          if(leftLength == 1)
              left = new TreeNode(postorder[start2]);
          else if(leftLength > 1)
		      left=bulidNode(inorder,start1,rootIndex-1,postorder,start2,start2+leftLength-1);
          else{}
         
          if(rightLength == 1)
              right = new TreeNode(postorder[end2-1]);
          else if(rightLength > 1)
		      right=bulidNode(inorder,rootIndex+1,end1,postorder,start2+leftLength,end2-1);
          else{}
         
          node.left = left;
		  node.right = right;
		  return node;
	  }
	  public int getRootIndex(int[] arr,int root) {
		  for(int i=0;i<arr.length;i++) {
			  if(arr[i] == root)
				  return i;
		  }
		  return 0;
	  }
}
