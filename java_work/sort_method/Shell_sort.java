/**
 * @author Wu Xianzhi
 * Reduced incremental ordering.
 */
/**
 * Hill sort is a certain incremental grouping of records by subscript,
 * which is sorted by direct insertion sort algorithm for each group.
 * As the increment decreases, each group contains more and more keywords,
 * and when the increment is reduced to 1,
 * the entire file is divided into one group,
 * and the algorithm terminates.
 */
public class Shell_sort {
  public static void Shellsort(int[] data) {
    int j = 0;
    int temp = 0;
    for (int increment = data.length / 2; increment > 0; increment /= 2) {
      for (int i = increment; i < data.length; i++) {
        temp = data[i];
        for (j = i; j >= increment; j -= increment) {
          if (temp > data[j - increment]) {
            data[j] = data[j - increment];
          } else {
            break;
          }
        }
        data[j] = temp;
      }
    }
  } // The whole ordered sequence is divided into several small sub-sequences
    // respectively for insertion sort.
  public static void main(String[] args) {
    int[] data = new int[] {5, 2, 6, 7, 1, 3, 4};
    System.out.println("Before the Shell Sort ordering.");
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i] + " ");
    }
    Shellsort(data);
    System.out.println("\nAfter the Shell Sort ordering.");
    for (int i = 0; i < data.length; i++)
      System.out.print(data[i] + " ");
  }
}