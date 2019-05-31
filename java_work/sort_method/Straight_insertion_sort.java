/**
 * @author Wu Xianzhi
 * @reference CSDN
 */
public class Straight_insertion_sort {
  public static void main(String[] args) {
    int arr[] = {3, 1, 5, 7, 2, 4, 8, 6}; // Define an array.
    insertSort(arr);
  }
  // Straight insertion sort
  static void insertSort(int[] a) {
    int Arrlength = a.length;
    for (int i = 1; i < Arrlength; i++) {
      if (a[i] < a[i - 1]) {
        // If the i element is greater than the i-1 element, insert directly.
        // If less than, move an ordered table and insert.
        int j = i - 1;
        int temp = a[i];
        // Copy to the sentinel, which stores the sorted elements.
        a[i] = a[i - 1]; // Move one element back.
        while (temp < a[j]) {
          // Locate the insertion location in an ordered table.
          a[j + 1] = a[j];
          j--; // The element move backward.
          if (j < 0) {
            break;
          }
        }
        a[j + 1] = temp; // Insert into the correct position.
      }
      printLine(a, i); // Print the results of each order.
    }
  }
  // Print the results of each order.
  static void printLine(int[] arr, int i) {
    System.out.println(i + ":");
    int Arrlength = arr.length;
    for (int j = 0; j < Arrlength; j++) {
      System.out.print(arr[j] + "  ");
    }
    System.out.println();
  }
}