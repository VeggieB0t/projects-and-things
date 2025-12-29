import java.util.*;

public class DSAPractice{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        System.out.print (" How many numbers are in your Array?");
        int size = input.nextInt();

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
    }
}