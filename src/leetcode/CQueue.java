package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {

  private Deque<Integer> stack1;
  private Deque<Integer> stack2;

  public CQueue() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }

  public void appendTail(int value) {
    stack1.push(value);
  }

  public int deleteHead() {
    if (!stack2.isEmpty()) {
      return stack2.pop();
    } else {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }

    return stack2.isEmpty() ? -1 : stack2.pop();
  }
}
