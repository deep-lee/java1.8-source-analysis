package leetcode;

public class Solution67 {
  public String addBinary(String a, String b) {
    int lengthA = a.length();
    int lengthB = b.length();

    int i = lengthA - 1, j = lengthB - 1;
    StringBuilder stringBuilder = new StringBuilder();
    int add = 0;
    while (i >= 0 && j >= 0) {
      int v1 = Integer.parseInt(String.valueOf(a.charAt(i)));
      int v2 = Integer.parseInt(String.valueOf(b.charAt(j)));
      int sum = add + v1 + v2;
      add = addToResult(stringBuilder, sum);
      i--;
      j--;
    }

    while (i >= 0) {
      int v1 = Integer.parseInt(String.valueOf(a.charAt(i)));
      int sum = add + v1;
      add = addToResult(stringBuilder, sum);
      i--;
    }

    while (j >= 0) {
      int v2 = Integer.parseInt(String.valueOf(b.charAt(j)));
      int sum = add + v2;
      add = addToResult(stringBuilder, sum);
      j--;
    }

    if (add == 1) {
      stringBuilder.insert(0, 1);
    }

    return stringBuilder.toString();
  }

  private int addToResult(StringBuilder stringBuilder, int sum) {
    int add = 0;
    if (sum < 2) {
      stringBuilder.insert(0, sum);
    } else {
      add = sum / 2;
      stringBuilder.insert(0, sum % 2);
    }

    return add;
  }

  public static void main(String[] args) {
    Solution67 solution67 = new Solution67();
    System.out.println(solution67.addBinary("11", "1"));
  }
}
