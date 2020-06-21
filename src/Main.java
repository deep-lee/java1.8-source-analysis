import java.util.*;

public class Main {

  private static final List<String> VALIDATED_MOVE = Arrays.asList("A", "D", "W", "S");

  public static boolean isValidated(String str) {
    if (str == null || str.length() == 0) return false;
    if (!VALIDATED_MOVE.contains(str.substring(0, 1))) return false;
    for (int i = 1; i < str.length(); i++) {
      if (Character.isLetter(str.charAt(i))) return false;
    }
    return true;
  }

  public static int getMoveCount(String str) {
    int count = 0;
    for (int i = str.length() - 1; i >= 1; i--) {
      count += Integer.parseInt(String.valueOf(str.charAt(i))) * Math.pow(10, str.length() - 1 - i);
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    String[] arr = str.split(";");
    int x = 0, y = 0;
    for (String step : arr) {
      if (!Main.isValidated(step)) continue;
      char move = step.charAt(0);
      int moveCount = Main.getMoveCount(step);
      switch(move) {
        case 'A':
          x -= moveCount;
          break;
        case 'D':
          x += moveCount;
          break;
        case 'W':
          y += moveCount;
          break;
        case 'S':
          y -= moveCount;
          break;
      }
    }

    System.out.println(x + "," + y);
  }
}
