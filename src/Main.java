import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
      int[] a = {9, 4, 5, 7, 3, 1, 2};
//      MergeSort.mergeSort(a, a.length);
      InsertionSort.insertionSort(a, 0, a.length);
      System.out.println(Arrays.toString(a));
  }
}
