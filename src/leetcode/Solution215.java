package leetcode;

public class Solution215 {
  public int findKthLargest(int[] nums, int k) {
    k = nums.length - k;
    return quickSelect(nums, 0, nums.length - 1, k);
  }

  private int quickSelect(int[] nums, int low, int high, int k) {
    if (low >= high) {
      return nums[low];
    }

    int index = nums[low];
    int i = low;
    int j = high;
    while (i < j) {
      while (i < j && nums[j] >= index) {
        j--;
      }
      if (i < j) {
        swap(nums, i, j);
        i++;
      }
      while (i < j && nums[i] < index) {
        i++;
      }
      if (i < j) {
        swap(nums, i, j);
        j--;
      }
    }

    if (i == k) return nums[i];
    else if (i < k) {
      return quickSelect(nums, i + 1, high, k);
    } else {
      return quickSelect(nums, low, i - 1, k);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    Solution215 solution215 = new Solution215();
    System.out.println(solution215.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
  }
}
