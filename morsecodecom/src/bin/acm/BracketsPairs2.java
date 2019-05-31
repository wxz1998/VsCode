package bin.acm;
import java.util.Scanner;
public class bracketspairs2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] s1 = new int[100];
    char[] s2 = new char[100];
    int j;
    while (N-- != 0) {
      j = 0;
      s1[0] = 0;
      String str1 = in.nextLine();
      for (int m = 0; m < str1.length(); m++) {
        s2[m] = str1.charAt(m);
      }
      int len = s2.length;
      for (int i = 0; i < len; i++) {
        int a = s2[i];
        if (a == s1[i] + 1 || a == s1[i] + 2) {
          s1[j] = 0;
          if (j != 0) {
            j--;
          }
        } else {
          if (s1[j] != 0) {
            j++;
          }
          s1[j] = a;
        }
      }
      if (s1[0] == 0)
        System.out.println("Yes");
      else
        System.out.println("No");
    }
  }
}