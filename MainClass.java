import dataobjects.*;
import linearstructures.*;
import java.util.Scanner;
import javax.swing.*; 


public class MainClass{
    public static void main (String args[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Windows OS look on dialog boxes
        }catch(Exception e){
        }

        CQueue CircularQueue = new CQueue(20);
        //Scanner input = new Scanner(System.in);
        //Scanner inputString = new Scanner(System.in);
        int option;
        
        do{
            String input = JOptionPane.showInputDialog(
                    "1: Construct empty Queue and Binary Tree\n"+
                    "2: Populate Queue with new Employees & Part timers\n"+
                    "3: Show all objects in Queue\n"+ //done
                    "4: Update payment of a respective person\n"+
                    "5: Update payment of all persons by 10%\n"+ //done
                    "6: Populate Binary Search Tree by all Queue objects\n"+
                    "7: Search for a particular Person\n"+
                    "8: Listing of Persons in ascending order\n"+
                    "9: Exit\n"+
                    "Choose 1 option from the menu available: ");

            
            option = Integer.parseInt(input);

            switch(option){
                case 1: 
                String tempSeqNo = JOptionPane.showInputDialog("Enter Seq No.");
                int seqNo = Integer.parseInt(tempSeqNo); 
                String surn = JOptionPane.showInputDialog("Enter Surname");
                String tempPay = JOptionPane.showInputDialog("Enter Pay");
                double pay = Double.parseDouble(tempPay); 
                boolean resultOfPut = CircularQueue.put(new Employee(seqNo,surn,pay));

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

                case 5:
                CircularQueue.changePayOfAll(10);
                CircularQueue.listAll();
                break;
                
                case 3:
                JOptionPane.showMessageDialog(null, "Contents of queue: \n");
                CircularQueue.listAll();
                break; 
                
                case 4:
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
        while(option!=9);
    }
}