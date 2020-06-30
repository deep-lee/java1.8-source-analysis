package sort;

import java.util.Arrays;

public class TimSort {

  private static int RUN = 2;

  public static void merge(int arr[], int l, int m, int r)
  {
    // original array is broken in two parts
    // left and right array
    int len1 = m - l + 1, len2 = r - m;
    int left[] = new int[len1];
    int right[] = new int[len2];
    for (int i = 0; i < len1; i++)
      left[i] = arr[l + i];
    for (int i = 0; i < len2; i++)
      right[i] = arr[m + 1 + i];

    int i = 0;
    int j = 0;
    int k = l;

    // after comparing, we merge those two array
    // in larger sub array
    while (i < len1 && j < len2)
    {
      if (left[i] <= right[j])
      {
        arr[k] = left[i];
        i++;
      }
      else
      {
        arr[k] = right[j];
        j++;
      }
      k++;
    }

    // copy remaining elements of left, if any
    while (i < len1)
    {
      arr[k] = left[i];
      k++;
      i++;
    }

    // copy remaining element of right, if any
    while (j < len2)
    {
      arr[k] = right[j];
      k++;
      j++;
    }
  }

  public static void timSort(int[] a, int n) {
    // First, we use sort.InsertionSort to sort individual subarrays
    for (int i = 0; i < n; i += RUN) {
      InsertionSort.insertionSort(a, i, Math.min(i + RUN, n));
    }

    for (int size = RUN; size < n; size = 2 * size) {
      for (int left = 0; left < n; left += 2 * size) {
        int mid = left + size - 1;
        int right = Math.min((left + 2*size - 1), (n-1));

        merge(a, left, mid, right);
      }
    }
  }

}
