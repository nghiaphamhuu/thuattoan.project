import java.io.*;
import java.util.Scanner;

public class OperationToProduct {
    public static  MyList<Product> list = new MyList<>();
    public static  MyStack<Product> myStack = new MyStack<>();
    public static  MyQueue<Product> myQueue = new MyQueue<>();

    public static void displayFromFile()  {
        try {
            list =new MyList<>();
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String txt[] = line.split("\\|");
                String bcode = txt[0].trim();
                String title = txt[1].trim();
                int quantity = Integer.parseInt(txt[2].trim());
                double price = Double.parseDouble(txt[3].trim());
                list.insertToTail(new Product(bcode,title,quantity,price));
            }
            System.out.println(list.toString());
            br.close();
            fr.close();
        } catch (Exception e){

        }
    }

    public static void inputAndAdd(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input new ID:");
        String code = sc.next();
        System.out.print("Input Product's Name:");
        String title = sc.next();
        System.out.print("Input Product's quantity:");
        int quantity = sc.nextInt();
        System.out.print("Input Product's price:");
        double price = sc.nextDouble();
        list.insertToTail(new Product(code,title,quantity,price));
    }
    public static void displayData(){
        System.out.println(list.toString());
    }
    public static void saveToFile(){
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> p = list.getHead();
            while (p!=null){
                bw.write(p.toString());
                bw.newLine();
                p = p.getNextNode();
            }
            System.out.println("Successfully!");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void searchByID(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the ID to search=");
        String id = sc.next();
        Node<Product> p = list.getHead();
        while (p!=null){
            if(p.getData().getBcode().equals(id)){
                System.out.println("Result: " + p.toString());
            }
            p = p.getNextNode();
        }
    }
    public static void deleteByID(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the bcode to delete= ");
        String id = sc.next();
        Node<Product> p = list.getHead();
        while (p!=null){
            if(p.getData().getBcode().equals(id)){
                list.deleteElement(p.getData());
            }
            p = p .getNextNode();
        }
        System.out.println("Deleted!");
    }
    public static void sortByID(){
        boolean isSwapped = true;
        while (isSwapped){
            isSwapped =false;
            Node<Product> p = list.getHead();
            while (p.getNextNode() != null){
                if(p.getData().getBcode().compareTo(p.getNextNode().getData().getBcode())>0){
                    list.swap(p,p.getNextNode());
                    isSwapped =true;
                }
                p = p.getNextNode();
            }
        }
        System.out.println("Successfully!");
    }
    public static void convertToBinary(int num){
        if(num==0){
            System.out.print("");
        }else {
            convertToBinary(num/2);
            System.out.print(""+num%2);
        }
    }
    public static void loadToStackAndDisplay(){
        try {
            myStack = new MyStack<>();
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String txt[] = line.split("\\|");
                String bcode = txt[0].trim();
                String title = txt[1].trim();
                int quantity = Integer.parseInt(txt[2].trim());
                double price = Double.parseDouble(txt[3].trim());
                myStack.push(new Product(bcode,title,quantity,price));
            }
            String result = "ID |  Title   | Quantity | price\n" +
                    "--------------------------------\n";
            while (!myStack.isEmpty()){
                result += myStack.getTop().toString() +"\n";
                myStack.pop();
            }
            System.out.println(result);
            br.close();
            fr.close();
        } catch (Exception e){

        }
    }
    public static void loadToQueueAndDisplay(){
        try {
            myQueue = new MyQueue<>();
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String txt[] = line.split("\\|");
                String bcode = txt[0].trim();
                String title = txt[1].trim();
                int quantity = Integer.parseInt(txt[2].trim());
                double price = Double.parseDouble(txt[3].trim());
                myQueue.enQueue(new Product(bcode,title,quantity,price));
            }

            String result = "ID |  Title   | Quantity | price\n" +
                    "--------------------------------\n";
            while (!myQueue.isEmpty()){
               result += myQueue.getTail().toString() + "\n";
               myQueue.deQueue();
            }
            System.out.println(result);
            br.close();
            fr.close();
        } catch (Exception e){

        }
    }
}

