package sort;

// https://juejin.im/post/5b4ef681f265da0f4b7a8d44
// 从第二个元素开始，每次循环找到当前元素在前面已排好序的序列中的位置
public class InsertionSort {
  public static void insertionSort(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }

    for (int i = left + 1; i < right; i++) {
      int temp = a[i];
      int j = i - 1;
      while (j >= left && temp < a[j]) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = temp;
    }
  }
}
