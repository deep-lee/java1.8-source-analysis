package leetcode;

public class Solution1014 {
  public int maxScoreSightseeingPair(int[] A) {
    int[] dp = new int[A.length];
    int max = A[0];
    int answer = 0;
    for (int j = 1; j < A.length; j++) {
      dp[j] = A[j] - j + max;
      max = Math.max(max, A[j] + j);
      answer = Math.max(answer, dp[j]);
    }

    return answer;
  }
}
