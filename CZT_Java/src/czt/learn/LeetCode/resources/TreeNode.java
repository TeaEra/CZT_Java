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
	
	public static TreeNode createDemo2() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = null;
		root.left.right = null;
		
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.left = null;
		root.right.left.right = null;
		root.right.right = new TreeNode(7);
		root.right.right.left = null;
		root.right.right.right = null;
		
		return root;
	}

	// Pre Order Traversal
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
    
    // Post Order Traversal
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
    
    // Level Order Traversal
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        ArrayList<ArrayList<Integer>> outList = new ArrayList<ArrayList<Integer>>();
    	List<TreeNode> currList = new ArrayList<TreeNode>();
        currList.add(root);
    	while (currList.size() != 0) {
    		List<TreeNode> tempList = new ArrayList<TreeNode>();
    		ArrayList<Integer> valList = new ArrayList<Integer>();
    		
    		for (int i=0; i<currList.size(); ++i) {
    			TreeNode currNode = currList.get(i);
    			valList.add(Integer.valueOf(currNode.val));
    			
    			if (currNode.left != null) {
    				tempList.add(currNode.left);
    			}
    			if (currNode.right != null) {
    				tempList.add(currNode.right);
    			}
    		}
    		currList = tempList;
    		outList.add(valList);
    	}
    	return outList;
    }
    
    // Zigzag Level Order Traversal
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<ArrayList<Integer>>();
    	}
    	
    	ArrayList<ArrayList<Integer>> outList = new ArrayList<ArrayList<Integer>>();
    	List<TreeNode> currList = new ArrayList<TreeNode>();
    	currList.add(root);
    	
    	// The traversal direction of child-nodes;
    	boolean isLeftToRight = false;
    	while (currList.size() != 0) {
    		List<TreeNode> tempList = new ArrayList<TreeNode>();
    		ArrayList<Integer> valList = new ArrayList<Integer>();

			for (int i=0; i<currList.size(); ++i) {
    			TreeNode currNode = currList.get(i);
    			valList.add(Integer.valueOf(currNode.val));
			}
			for (int i=currList.size()-1; i>=0; --i) {
        		TreeNode currNode = currList.get(i);
			    
        		// Append child-nodes;
			    if (isLeftToRight) {
	    			if (currNode.left != null) {
	    				tempList.add(currNode.left);
	    			}
	    			if (currNode.right != null) {
	    				tempList.add(currNode.right);
	    			}
			        
			    }
			    else {
	    			if (currNode.right != null) {
	    				tempList.add(currNode.right);
	    			}
	    			if (currNode.left != null) {
	    				tempList.add(currNode.left);
	    			}
			        
			    }
			}
    		
    		isLeftToRight = ! isLeftToRight;
    		
    		currList = tempList;
    		outList.add(valList);
    	}
    	return outList;
    }
	
	public static void main(String[] args) {
		/*TreeNode root = TreeNode.createDemoTreeNode();
		//ArrayList<Integer> list = TreeNode.preorderTraversal(root);
		ArrayList<Integer> list = TreeNode.postorderTraversal(root);
		for (Integer each: list) {
			System.out.println(each);
		}*/
		
		TreeNode root = TreeNode.createDemo2();
		//ArrayList<ArrayList<Integer>> outList = TreeNode.levelOrder(root);
		ArrayList<ArrayList<Integer>> outList = TreeNode.zigzagLevelOrder(root);
		System.out.println("[");
		for (int i=0; i<outList.size(); ++i) {
			ArrayList<Integer> currList = outList.get(i);
			System.out.print("[");
			for (int j=0; j<currList.size(); ++j) {
				System.out.print(currList.get(j));
				if (j != currList.size()-1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
		System.out.println("]");
	}
}
