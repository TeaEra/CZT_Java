package czt.learn.LeetCode.resources;

import java.util.ArrayList;
import java.util.List;

// Definition for binary tree
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) { 
		val = x;
	}
	
	public static TreeNode createDemoTreeNode() {
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = null;
		
		return root;
	}

	//
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
    	if (root != null) {
    		int rootVal = root.val;
    		ArrayList<Integer> leftList = TreeNode.preorderTraversal(root.left);
    		ArrayList<Integer> rightList = TreeNode.preorderTraversal(root.right);
    		
    		// Actually, this format is suggested:
    		//   List<Integer> list = new ArrayList<Integer>();
    		ArrayList<Integer> combList = new ArrayList<Integer>();
    		combList.add(Integer.valueOf(rootVal));
    		for (Integer each: leftList) {
    			combList.add(each);
    		}
    		for (Integer each: rightList) {
    			combList.add(each);
    		}
    		return combList;
    	}
    	return new ArrayList<Integer>();
    }
    
    //
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    	if (root != null) {
    		int rootVal = root.val;
    		ArrayList<Integer> leftList = TreeNode.postorderTraversal(root.left);
    		ArrayList<Integer> rightList = TreeNode.postorderTraversal(root.right);
    		
    		// Actually, this format is suggested:
    		//   List<Integer> list = new ArrayList<Integer>();
    		ArrayList<Integer> combList = new ArrayList<Integer>();
    		for (Integer each: leftList) {
    			combList.add(each);
    		}
    		for (Integer each: rightList) {
    			combList.add(each);
    		}
    		combList.add(Integer.valueOf(rootVal));
    		return combList;
    	}
    	return new ArrayList<Integer>();
    }
    
    //???
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        return new ArrayList<ArrayList<Integer>>();
    }
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createDemoTreeNode();
		//ArrayList<Integer> list = TreeNode.preorderTraversal(root);
		ArrayList<Integer> list = TreeNode.postorderTraversal(root);
		for (Integer each: list) {
			System.out.println(each);
		}
	}
}
