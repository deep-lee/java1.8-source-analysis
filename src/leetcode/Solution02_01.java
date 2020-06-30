package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution02_01 {
  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return null;
    }
    List<Integer> exitsValues = new ArrayList<>();
    ListNode p = head;
    if (p.next == null) {
      return head;
    }
    ListNode q = head.next;
    exitsValues.add(p.val);
    while (q != null) {
      if (exitsValues.contains(q.val)) {
        // remove q
        p.next = q.next;
      } else {
        exitsValues.add(q.val);
        p = q;
      }
      q = q.next;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(2);
    ListNode listNode6 = new ListNode(1);

    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    Solution02_01 solution02_01 = new Solution02_01();
    System.out.println(solution02_01.removeDuplicateNodes(listNode1));

  }
}
