import java.util.*;


public class main{
public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
        HashTable ht = new HashTable();

        System.out.print("Enter phone number: ");
        String number = scan.nextLine();

        ht.insert(number);

        System.out.println("Inserted!");

        System.out.println("\n--- Hash Table Buckets ---");
        ht.display();

        System.out.println("\nSearch for the number...");
        HashEntry found = ht.search(number);

        if (found != null)
            System.out.println("Found → " + found);
        else
            System.out.println("Not found.");

}

}
