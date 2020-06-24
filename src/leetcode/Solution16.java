package leetcode;

import java.util.Arrays;

public class Solution16 {
  public int threeSumClosest(int[] nums, int target) {
    int length = nums.length;
    Arrays.sort(nums);
    int closeSum = 0;
    int distance = Integer.MAX_VALUE;
    for (int i = 0; i < length; i++) {
      // Skip the equal enum
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }
      int j = i + 1;
      int k = length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(target - sum) < distance) {
          distance = Math.abs(target - sum);
          closeSum = sum;
        }

        if (sum == target) {
          return sum;
        } else if (sum < target) {
          // find next unequal num
          int j0 = j + 1;
          while (j0 < k && nums[j0] == nums[j]) {
            j0++;
          }
          j = j0;
        } else {
          // find next unequal num
          int k0 = k - 1;
          while (j < k0 && nums[k] == nums[k0]) {
            k0--;
          }
          k = k0;
        }
      }
    }

    return closeSum;
  }

  public static void main(String[] args) {
    Solution16 solution16 = new Solution16();
    System.out.println(solution16.threeSumClosest(new int[] {4,0,5,-5,3,3,0,-4,-5}, -2));
  }
}
