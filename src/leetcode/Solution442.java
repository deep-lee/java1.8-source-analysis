package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
  // 因为数组元素都在[1,N], N是数组长度，
  // 对于第i个元素，我们可以将num[i] -1下标处的元素取反，如果对应下标处的元素是负的，说明是重复的数
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      int loc = Math.abs(nums[i]) - 1;
      if (nums[loc] < 0) {
        result.add(loc + 1);
      }
      nums[loc] = -nums[loc];
    }

    return result;
  }

  public static void main(String[] args) {
    Solution442 solution442 = new Solution442();
    System.out.println(solution442.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
  }
}
