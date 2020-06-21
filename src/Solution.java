import java.util.Stack;

class Solution {

  public int largestRectangleArea(int[] heights) {
    int length = heights.length;
    int[] maxh = new int[length];
    int[] maxw = new int[length];
    int[] fmax = new int[length];

    maxh[0] = heights[0];
    maxw[0] = 1;
    fmax[0] = maxh[0] * maxw[0];

    for (int i = 1; i < length; i++) {
      int area1 = heights[i];
      int area2 = Math.min(heights[i], maxh[i - 1]) * (maxw[i - 1] + 1);
      if (area1 > area2) {
        maxh[i] = heights[i];
        maxw[i] = 1;
        fmax[i] = area1;
      } else {
        maxh[i] = Math.min(heights[i], maxh[i - 1]);
        maxw[i] = (maxw[i - 1] + 1);
        fmax[i] = area2;
      }
    }

    int result = 0;
    for (int i = 0; i < length; i++) {
      result = Math.max(result, fmax[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.largestRectangleArea(new int[] {1, 2, 3, 4, 5}));
  }
}