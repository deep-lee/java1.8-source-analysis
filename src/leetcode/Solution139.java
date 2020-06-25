package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution139 {

  //动态规划
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s.isEmpty()) {
      return true;
    }

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i < s.length() + 1; i++) {
      for (int j = 0; j < i; j++) {
        String subString = s.substring(j, i);
        dp[i] = dp[j] && wordDict.contains(subString);
        if (dp[i]) {
          break;
        }
      }
    }

    return dp[s.length()];
  }

  // 递归+优化解法
  public boolean wordBreak2(String s, List<String> wordDict) {
    return wordBreakHelper(s, wordDict, new ArrayList<>());
  }

  private boolean wordBreakHelper(String s, List<String> wordDict, List<String> excludeList) {
    if (s.isEmpty()) {
      return true;
    }
    int length = s.length();
    boolean result = false;
    for (int i = 0; i < length; i++) {
      String subString = s.substring(0, i + 1);
      if (wordDict.contains(subString)) {
        String left = s.substring(i+1);
        if (excludeList.contains(left)) {
          continue;
        }
        result = wordBreak(left, wordDict);
        if (result) {
          break;
        } else {
          excludeList.add(left);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution139 solution139 = new Solution139();
    System.out.println(solution139.wordBreak("applepie", Arrays.asList("pie","pear","apple","peach")));
  }
}
