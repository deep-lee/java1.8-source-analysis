package sort;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
  public void quickSort(int[] nums, int low, int high) {
    if (low >= high) {
      return;
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

    nums[i] = index;
    quickSort(nums, low, i - 1);
    quickSort(nums, i + 1, high);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    int[] arr = new int[] {4, 3, 5, 6, 1, 2};
    quickSort.quickSort(arr, 0, 5);
    System.out.println(Arrays.toString(arr));
  }
}
