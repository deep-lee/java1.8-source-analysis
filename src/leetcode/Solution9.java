package leetcode;

public class Solution9 {
  public boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    int n = s.length();
    for (int i = 0, j = n - 1; i <= j; i++, j--) {
      char ch1 = s.charAt(i);
      char ch2 = s.charAt(j);
      if (ch1 != ch2) {
        return false;
      }
    }

    return true;
  }

  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }

    long r = 0;

    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x = x / 10;
    }

    return x == revertedNumber || x == revertedNumber / 10;
  }
}
