import dataobjects.*;
import linearstructures.*;
import java.util.Scanner;
public class MainClass{
    public static void main (String args[]){
        CQueue CircularQueue = new CQueue(20);
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Add a new Employee");
            System.out.println("2. Add a new Part Timer");
            System.out.println("3. Serve all Employees");
            System.out.println("4. Update the pay of all persons");
            System.out.println("5. List all contents of queue");
            System.out.println("6. Change pay of person");
            System.out.println("7. Exit the program\n");
            
            option = input.nextInt();

            switch(option){
                case 1: 
                System.out.println("Enter Seq No.");
                int seqno = input.nextInt();
                System.out.println("Enter Surname");
                String surn = inputString.nextLine();
                System.out.println("Enter Pay");
                double pay = input.nextDouble();
                boolean resultOfPut = CircularQueue.put(new Employee(seqno,surn,pay));

                if(resultOfPut == true){
                    CircularQueue.listAll();
                    System.out.println("\nEmployee is successfully added to the queue\n");
                }
                else{
                    System.out.println("Failed to add the AnyClass because the queue is full");
                }
                break;
                
                case 2:
                System.out.println("Enter Seq No.");
                int ptseqno = input.nextInt();
                System.out.println("Enter Surname");
                String ptsurn = inputString.nextLine();
                System.out.println("Enter Pay");
                double ptpay = input.nextDouble();
                System.out.println("Enter the amount of hours worked");
                int pthours = input.nextInt();
                resultOfPut = CircularQueue.put(new PartTimer(ptseqno,ptsurn,ptpay,pthours));

                if(resultOfPut == true){
                    CircularQueue.listAll();
                    System.out.println("\nEmployee is successfully added to the queue\n");
                }
                else{
                    System.out.println("Failed to add the AnyClass because the queue is full");
                }
                break;

                case 3:
                AnyClass resultOfServe = CircularQueue.serve();
                System.out.println("\nContents of Cicular Queue: \n");
                if(resultOfServe != null){
                    CircularQueue.listAll();
                    System.out.println(resultOfServe.getData()+"\n");
                }
                else{
                    System.out.println("The circular queue has no contents");
                }
                break; 

                case 4:
                System.out.println("By how much % would you like to update all payments? \n");
                int percent = input.nextInt();
                CircularQueue.changePayOfAll(percent);
                CircularQueue.listAll();
                break;
                
                case 5:
                System.out.println("\nContents of queue: \n");
                CircularQueue.listAll();
                break; 
                
                case 6:
                System.out.println("Enter Seq No. of person to be edited: ");
                int seqNoToBeEdited = input.nextInt();
                CircularQueue.editObject(seqNoToBeEdited);
                CircularQueue.listAll();
                break;
                
                case 7:
                System.exit(0);
                break;
            }
        }
        while(option!=7);
    }
}