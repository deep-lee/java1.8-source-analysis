package leetcode;

public class Solution990 {
  int[] prev = new int[26];

  public boolean equationsPossible(String[] equations) {
    for (int i = 0; i < 26; i++) {
      prev[i] = i; // 默认上级就是自己
    }

    // 所有的等式构成并查集
    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        int index1 = equation.charAt(0) - 'a';
        int index2 = equation.charAt(3) - 'a';
        unoin(index1, index2);
      }
    }

    // 便利所有的不等式，如果能连通，return false
    for (String equation : equations) {
      if (equation.charAt(1) == '!') {
        int index1 = equation.charAt(0) - 'a';
        int index2 = equation.charAt(3) - 'a';
        if (find(index1) == find(index2)) {
          return false;
        }
      }
    }

    return true;
  }

  // 找到index的掌门
  private int find(int index) {
    int r = index;
    while (prev[r] != r) {
      r = prev[r];
    }
    return r;
  }

  private void unoin(int index1, int index2) {
    prev[find(index1)] = find(index2);
  }

  public static void main(String[] args) {
    Solution990 solution990 = new Solution990();
    System.out.println(solution990.equationsPossible(new String[] {"c==c","b==d","x!=z"}));
  }
}
