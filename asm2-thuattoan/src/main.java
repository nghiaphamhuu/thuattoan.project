import java.io.*;
import java.util.Scanner;
import java.util.WeakHashMap;

public class main {
    public static OperationToProduct x = new OperationToProduct();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (n!=0){
            System.out.println("Choose one of this options:");
            System.out.println("Product list:");
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end.");
            System.out.println("3. Display data");
            System.out.println("4. Save product list to file.");
            System.out.println("5. Search by ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Sort by ID.");
            System.out.println("8. Convert to Binary ");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display.");
            System.out.println("Exit:");
            System.out.println("0.Exit");
            int a = sc.nextInt();
            switch (a){
                case 1:
                    x.displayFromFile();
                    break;
                case 2 :
                    x.inputAndAdd();
                    break;
                case 3:
                    x.displayData();
                    break;
                case 4:
                    x.saveToFile();
                    break;
                case 5:
                    x.searchByID();
                    break;
                case 6:
                    x.deleteByID();
                    break;
                case 7:
                    x.sortByID();
                    break;
                case 8:
                    Node<Product> p = x.list.getHead();
                    int num = p.getData().getQuantity();
                    x.convertToBinary(num);
                    System.out.println();
                    break;
                case 9:
                    x.loadToStackAndDisplay();
                    break;
                case 10:
                    x.loadToQueueAndDisplay();
                    break;
            }
            n=a;
        }
    }
}


