package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Deque<String> deque = new LinkedList<>();
    deque.add(beginWord);
    boolean[] visited = new boolean[wordList.size()];
    int layer = 1;
    while (!deque.isEmpty()) {
      layer++;
      int size = deque.size();
      while (size-- > 0) {
        String str = deque.poll();
        for (int i = 0; i < wordList.size(); i++) {
          if (!visited[i]) {
            String world = wordList.get(i);
            if (canChange(str, world)) {
              if (endWord.equals(world)) return layer;
              deque.add(world);
              visited[i] = true;
            }
          }
        }
      }
    }

    return 0;
  }

  private boolean canChange(String source, String dest) {
    int len = source.length();
    int dif = 0;
    for (int i = 0; i < len; i++) {
      if (source.charAt(i) != dest.charAt(i))
        dif++;
    }

    return dif == 1;
  }

  // 双向BFS
  public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }
    Deque<String> dequeBegin = new LinkedList<>();
    Deque<String> dequeEnd = new LinkedList<>();
    dequeBegin.add(beginWord);
    dequeEnd.add(endWord);
    boolean[] visited = new boolean[wordList.size()];
    int layer = 1;
    while (!dequeBegin.isEmpty() && !dequeEnd.isEmpty()) {
      layer++;
      if (dequeBegin.size() > dequeEnd.size()) {
        Deque<String> temp = new LinkedList<>();
        temp = dequeBegin;
        dequeBegin = dequeEnd;
        dequeEnd = temp;
      }
      int size = dequeBegin.size();
      while (size-- > 0) {
        String str = dequeBegin.poll();
        for (int i = 0; i < wordList.size(); i++) {
            String world = wordList.get(i);
            if (canChange(str, world)) {
              if (dequeEnd.contains(world)) return layer;
              if (!visited[i]) {
                dequeBegin.add(world);
                visited[i] = true;
              }
            }
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    Solution127 solution127 = new Solution127();
    System.out.println(solution127.ladderLength2("a", "b", Arrays.asList("a","b","c")));

  }
}
