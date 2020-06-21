package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution297 {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }
    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> deque = new LinkedList<>();
    deque.push(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.pollLast();
      if (node == null) {
        list.add(null);
      } else {
        list.add(node.val);
        deque.push(node.left);
        deque.push(node.right);
      }
    }

    return list.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    data = data.substring(1);
    data = data.substring(0, data.length() - 1);
    if (data.length() == 0) {
      return null;
    }
    String[] items = data.split(",");
    Deque<TreeNode> deque = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(items[0].trim()));
    deque.push(root);
    int i = 1;
    while (!deque.isEmpty()) {
      TreeNode node = deque.pollLast();
      if (!"null".equals(items[i].trim())) {
        TreeNode nodeLeft = new TreeNode(Integer.parseInt(items[i].trim()));
        node.left = nodeLeft;
        deque.push(nodeLeft);
      }
      i++;
      if (!"null".equals(items[i].trim())) {
        TreeNode nodeRight = new TreeNode(Integer.parseInt(items[i].trim()));
        node.right = nodeRight;
        deque.push(nodeRight);
      }
      i++;
    }

    return root;
  }

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);

    node1.left = node2;
    node1.right = node3;
    node3.left = node4;
    node3.right = node5;

    Solution297 solution297 = new Solution297();
//    System.out.println(solution297.serialize(node1));
    TreeNode root = solution297.deserialize("[]");
    System.out.println(root.val);
  }
}
