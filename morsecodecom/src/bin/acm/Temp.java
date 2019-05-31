import java.util.*;
public class temp {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] progress = new int[10];
    for (int i = 0; i < 10; i++) {
      progress[i] = input.nextInt();
    }
    for (int j : progress) {
      System.out.println(j);
    }
  }
}