package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      // 需要和上一次枚举的数不相同
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int value = nums[i];
      List<List<Integer>> list = twoSum(nums, i + 1, value);
      result.addAll(list);
    }
    return result;
  }

  public List<List<Integer>> twoSum(int[] nums, int start, int first) {
    List<List<Integer>> result = new ArrayList<>();
    int i = start;
    int j = nums.length - 1;
    while (i < j) {
      int sum = first + nums[i] + nums[j];
      if (sum < 0) {
        while (i < j && nums[i] == nums[++i]);
      } else if (sum > 0) {
        while ((i < j && nums[j] == nums[--j]));
      } else {
        result.add(Arrays.asList(nums[i], nums[j], first));
        while (i < j && nums[i] == nums[++i]);
        while ((i < j && nums[j] == nums[--j]));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution15 solution15 = new Solution15();
    System.out.println(solution15.threeSum(new int [] {-2, 0, 1, 1, 2}));
  }
}
