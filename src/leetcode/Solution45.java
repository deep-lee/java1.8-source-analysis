package leetcode;

public class Solution45 {
  public int translateNum(int num) {
    String str = String.valueOf(num);
    int[] f = new int[str.length()];
    f[0] = 1;
    if (str.length() > 1) {
      f[1] = (str.substring(0, 2).compareTo("10") >= 0 && str.substring(0, 2).compareTo("25") <= 0) ? 2 : 1;
    }
    for (int i = 2; i < str.length(); i++) {
      f[i] = f[i - 1] + ((str.substring(i - 1, i + 1).compareTo("10") >= 0 && str.substring(i - 1, i + 1).compareTo("25") <= 0) ? f[i - 2] : 0);
    }

    return f[str.length() - 1];
  }

  public static void main(String[] args) {
    Solution45 solution45 = new Solution45();
    System.out.println(solution45.translateNum(624));
  }
}
