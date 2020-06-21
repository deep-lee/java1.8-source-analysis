package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1028 {

  // 中左右
  public TreeNode recoverFromPreorder(String S) {
    Deque<TreeNode> deque = new LinkedList<>();

    for (int i = 0; i < S.length(); ) {
      int level = 0;
      int val = 0;
      while (i < S.length() && !Character.isDigit(S.charAt(i))) {
        level++;
        i++;
      }

      while (i < S.length() && Character.isDigit(S.charAt(i))) {
        val = val * 10 + Integer.parseInt(String.valueOf(S.charAt(i)));
        i++;
      }

      TreeNode node = new TreeNode(val);
      if (deque.isEmpty()) {
        deque.push(node);
      } else {
        if (deque.size() == level) {
          deque.peek().left = node;
        } else {
          while (deque.size() != level) {
            deque.pop();
          }
          deque.peek().right = node;
        }

        deque.push(node);
      }
    }

    while (deque.size() != 1) {
      deque.pop();
    }

    return deque.pop();
   }

  public static void main(String[] args) {
    Solution1028 solution1028 = new Solution1028();
    solution1028.recoverFromPreorder("1-401--349---90--88");
  }
}
