package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution739 {
  public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    Deque<Integer> index = new LinkedList<>();
    for (int i = 0; i < T.length; i++) {
      if (index.isEmpty()) {
        index.push(i);
        continue;
      }

      int topIndex = index.peek();
      while (T[topIndex] < T[i]) {
        result[topIndex] = i - topIndex;
        index.pop();
        if (index.isEmpty()) {
          break;
        }
        topIndex = index.peek();
      }
      index.push(i);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution739 solution739 = new Solution739();
    System.out.println(Arrays.toString(solution739.dailyTemperatures(new int[]{73, 72, 74})));
  }
}
