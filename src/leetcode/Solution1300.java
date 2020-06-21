package leetcode;

import java.util.Arrays;

public class Solution1300 {
  public int findBestValue(int[] arr, int target) {
    Arrays.sort(arr);
    int n = arr.length;
    int left = 0;
    int right = arr[n - 1];
    int resultAbs = Integer.MAX_VALUE;
    int result = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      int sum = sumArr(arr, mid);
      if (resultAbs > Math.abs(sum - target)) {
        resultAbs = Math.abs(sum - target);
        result = mid;
      }

      if (resultAbs == Math.abs(sum - target) && result > mid) {
        result = mid;
      }

      if (sum > target) {
        right = mid - 1;
      } else if (sum < target){
        left = mid + 1;
      } else {
        return mid;
      }
    }

    return result;
  }

  private int sumArr(int[] arr, int mid) {
    int sum = 0;
    for (int item : arr) {
        sum += Math.min(item, mid);
    }
    return sum;
  }

  public static void main(String[] args) {
    Solution1300 solution1300 = new Solution1300();
    System.out.println(solution1300.findBestValue(new int [] {4, 9, 3}, 10));
  }
}
