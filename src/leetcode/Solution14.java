package leetcode;

public class Solution14 {
  public String longestCommonPrefix(String[] strs) {
    int count = strs.length;
    if (count == 0) return "";
    if (count == 1) return strs[0];

    String prefix = strs[0];
    for (String str : strs) {
      prefix = longestCommonPrefix(prefix, str);
    }

    return prefix;
  }

  public String longestCommonPrefix(String str1, String str2) {
    int length = Math.min(str1.length(), str2.length());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        sb.append(str1.charAt(i));
      } else {
        break;
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Solution14 solution14 = new Solution14();
    System.out.println(solution14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
  }
}
