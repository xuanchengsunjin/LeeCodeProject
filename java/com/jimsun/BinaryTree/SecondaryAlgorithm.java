package com.jimsun.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SecondaryAlgorithm {
	//二叉树节点
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/*二叉搜索树中第K小的元素
	 *给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
	 *说明：
	 *你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
	 * */
	//中序遍历
    public int kthSmallest(TreeNode root, int k) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode head = root;
    	while(!stack.isEmpty() || head != null) {
    		if(head != null) {
    			stack.push(head);
    			head = head.left;
    		}else {
    			head = stack.pop();
    			if(--k == 0) {
    				return head.val;
    			}
    			head = head.right;
    		}		
    	}
    	return root.val;
    }
    //递归(计算节点数量)
    public int count(TreeNode root){
        if(root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }
    public int kthSmallestImprove(TreeNode root, int k) {
        int num = count(root.left);
        if(num == k-1)
            return root.val;
        if(num > k-1)
            return kthSmallest(root.left,k);
        return kthSmallest(root.right,k - num-1);
    }
    /*二叉树的最近公共祖先
     *输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     *输出: 3
     *解释: 节点 5 和节点 1 的最近公共祖先是节点 3。 
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null || root.val == p.val || root.val == q.val)
    		return root;
    	TreeNode left = lowestCommonAncestor(root.left,p,q);
    	TreeNode right = lowestCommonAncestor(root.right,p,q);
    	if(left != null && right != null)
    		return root;
    	return left != null ? left : right;
    }
    /*二叉树的序列化与反序列化
     *序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
     *同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     *请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
     *你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。 
     * */
    // Encodes a tree to a single string.
    public String serialize() {
       List<Integer> list = new LinkedList<Integer>();
       
       return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
