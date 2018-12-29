import dataobjects.*;
import linearstructures.*;
import non_linearstructures.*;
import java.util.Scanner;
import javax.swing.*; 

public class MainClassLuke{
    public static void main (String args[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Windows OS look on dialog boxes
        }catch(Exception e){
        }

        //Scanner input = new Scanner(System.in);
        //Scanner inputString = new Scanner(System.in);
        int option;

        do{
            String input = JOptionPane.showInputDialog(
                    "1: Construct empty Queue and Binary Tree\n"+ //done
                    "2: Populate Queue with new Employees & Part timers\n"+ //fidejn Mike
                    "3: Show all objects in Queue\n"+ //done
                    "4: Update payment of a respective person\n"+
                    "5: Update payment of all persons by 10%\n"+ //done
                    "6: Populate Binary Search Tree by all Queue objects\n"+ //done
                    "7: Search for a particular Person\n"+ //done
                    "8: Listing of Persons in ascending order\n"+ //done
                    "9: Exit\n"+ //done
                    "Choose 1 option from the menu available: ");

            option = Integer.parseInt(input);
            switch(option){
                case 1:
                String tempChoice = JOptionPane.showInputDialog("What queue size would you like to have? ");
                int choice = Integer.parseInt(tempChoice);
                CQueue CircularQueue = new CQueue(choice);
                BinSearchTree bst = new BinSearchTree();

                /*case 1: 
                String tempSeqNo = JOptionPane.showInputDialog("Enter Seq No.");
                int seqNo = Integer.parseInt(tempSeqNo); 
                String surn = JOptionPane.showInputDialog("Enter Surname");
                String tempPay = JOptionPane.showInputDialog("Enter Pay");
                double pay = Double.parseDouble(tempPay); 
                boolean resultOfPut = CircularQueue.put(new Employee(seqno,surn,pay));

                if(resultOfPut == true){
                CircularQueue.listAll();
                System.out.println("\nEmployee is successfully added to the queue\n");
                }
                else{
                System.out.println("Failed to add the AnyClass because the queue is full");
                }
                break;*/

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
                JOptionPane.showMessageDialog(null, "Contents of queue: \n");
                CircularQueue.listAll();
                break; 

                case 4:
                String chnSurn = JOptionPane.showInputDialog("Enter surname: ");
                String chnIdNo = JOptionPane.showInputDialog("Enter Id number: ");
                AnyClass chnResult = bst.search(chnSurn);
                if (chnResult == null)
                    JOptionPane.showMessageDialog(null, "Not found");
                else
                    if (chnResult.getID().equals(chnIdNo))
                        chnResult.edit();
                else{
                    JOptionPane.showMessageDialog(null, "ID doesn't match");
                    chnResult = bst.search(chnResult.getKey()); 
                } 
                break;

                case 5:
                JOptionPane.showMessageDialog(null, "Updated contents of queue: \n");
                CircularQueue.changePayOfAll(10);
                CircularQueue.listAll();
                break;

                case 6:
                bst.populateFromQueue(CircularQueue);

                case 7:
                String surnSearch = JOptionPane.showInputDialog("Enter Surname");
                AnyClass result = bst.search(surnSearch);
                if (result == null)
                    JOptionPane.showMessageDialog(null, "Not found");
                else
                    JOptionPane.showMessageDialog(null, result.getData());

                case 8:
                bst.listInOrder();                    

                case 9:
                System.exit(0);
                break;
            }
        }
        while(option!=9);
    }
}