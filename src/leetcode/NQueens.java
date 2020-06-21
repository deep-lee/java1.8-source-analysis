package leetcode;

import java.util.Arrays;

public class NQueens {

  private int[] a = new int[4];
  int n = 4, cnt = 0;

  private boolean isConflict(int i) {
    for (int j = 0; j < i; j++) {
      if (a[i] == a[j] || Math.abs(a[i] - a[j]) == Math.abs(i - j)) {
        return true;
      }
    }
    return false;
  }

  public void queen(int k) {
    // 已经摆放好了
    if (k == n) {
      System.out.println("第" + ++cnt + "种情况：");
      System.out.println(Arrays.toString(a));
    } else { // 还没有摆放完
      for (int i = 0; i < n ; i++) {
        a[k] = i;
        if (!isConflict(k)) {
          queen(k + 1); // 不冲突则摆放下一个
        }
      }
    }
  }

  public static void main(String[] args) {
    NQueens queens = new NQueens();
    queens.queen(0);
  }
}
