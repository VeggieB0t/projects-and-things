import java.util.*;

public class DSAPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = null;   // array is empty until user fills it
        int choice;

        do {
            System.out.println("\n=== DSA Practice Menu ===");
            System.out.println("1. Enter numbers into array");
            System.out.println("2. Sum the array");
            System.out.println("3. Linear search");
            System.out.println("4. Binary search (requires sorted array)");
            System.out.println("5. Sort array");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                // ---------- ENTER NUMBERS ----------
                case 1:
                    System.out.print("How many numbers? ");
                    int size = input.nextInt();
                    numbers = new int[size];

                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        numbers[i] = input.nextInt();
                    }
                    System.out.println("Array stored successfully!");
                    break;

                // ---------- SUM ARRAY ----------
                case 2:
                    if (numbers == null) {
                        System.out.println("Please enter numbers first (option 1).");
                        break;
                    }

                    int sum = 0;
                    for (int num : numbers) {
                        sum += num;
                    }
                    System.out.println("Sum of array = " + sum);
                    break;

                // ---------- LINEAR SEARCH ----------
                case 3:
                    if (numbers == null) {
                        System.out.println("Please enter numbers first (option 1).");
                        break;
                    }

                    System.out.print("Enter number to search for: ");
                    int key = input.nextInt();

                    boolean found = false;
                    int index = -1;

                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == key) {
                            found = true;
                            index = i;
                            break;
                        }
                    }

                    if (found)
                        System.out.println(key + " found at index " + index);
                    else
                        System.out.println(key + " not found.");
                    break;

                // ---------- BINARY SEARCH ----------
                case 4:
                    if (numbers == null) {
                        System.out.println("Please enter numbers first (option 1).");
                        break;
                    }

                    System.out.print("Enter number to binary search: ");
                    key = input.nextInt();

                    int result = Arrays.binarySearch(numbers, key);

                    if (result >= 0)
                        System.out.println(key + " found at index " + result);
                    else
                        System.out.println(key + " not found (binary search).");
                    break;

                // ---------- SORT ARRAY ----------
                case 5:
                    if (numbers == null) {
                        System.out.println("Please enter numbers first (option 1).");
                        break;
                    }

                    Arrays.sort(numbers);
                    System.out.println("Array sorted: " + Arrays.toString(numbers));
                    break;

                // ---------- EXIT ----------
                case 6:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }
}
