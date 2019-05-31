/**
 * @author Wu Xianzhi
 */
public class Bubble_sort {
  public static void main(String[] args) {
    int[] arr = {4, 3, 5, 2, 6, 1};
    System.out.println("The pre-sorted array is:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    for (int i = 0; i < arr.length - 1; i++) { //The outer loop control sort counts.
      for (int j = 0; j < arr.length - 1 - i;
           j++) { //The inner loop controls how many times each trip is ordered.
        if (arr[j] > arr[j + 1]) {//Compare the two Numbers.
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;//Empty bottle exchange.
        }
      }
    }
    System.out.println();
    System.out.println("The sorted array is:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}