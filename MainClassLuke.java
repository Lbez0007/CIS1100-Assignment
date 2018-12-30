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

        String tempChoice = JOptionPane.showInputDialog("What queue size would you like to have? ");
        int choice = Integer.parseInt(tempChoice);
        CQueue CircularQueue = new CQueue(choice);
        BinSearchTree bst = new BinSearchTree();

        do{
            String input = JOptionPane.showInputDialog(
                    "1: Populate Queue with new Employees & Part timers\n"+ //fidejn Mike
                    "2: Show all objects in Queue\n"+ //done
                    "3: Update payment of a respective person\n"+
                    "4: Update payment of all persons by 10%\n"+ //done
                    "5: Populate Binary Search Tree by all Queue objects\n"+ //done
                    "6: Search for a particular Person\n"+ //done
                    "7: Listing of Persons in ascending order\n"+ //done
                    "8: Exit\n"+ //done
                    "Choose 1 option from the menu available: ");

            option = Integer.parseInt(input);
            switch(option){

                case 1:
                /*System.out.println("Enter Seq No.");
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
                }*/
                break;

                case 2:
                JOptionPane.showMessageDialog(null, "Contents of queue: \n");
                CircularQueue.listAll();
                break; 

                case 3:
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

                case 4:
                JOptionPane.showMessageDialog(null, "Updated contents of queue: \n");
                CircularQueue.changePayOfAll(10);
                CircularQueue.listAll();
                break;

                case 5:
                bst.populateFromQueue(CircularQueue);

                case 6:
                String surnSearch = JOptionPane.showInputDialog("Enter Surname");
                AnyClass result = bst.search(surnSearch);
                if (result == null)
                    JOptionPane.showMessageDialog(null, "Not found");
                else
                    JOptionPane.showMessageDialog(null, result.getData());

                case 7:
                bst.listInOrder();                    

                case 8:
                System.exit(0);
                break;
            }
        }
        while(option!=8);
    }
}