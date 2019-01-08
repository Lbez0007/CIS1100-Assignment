import dataobjects.*;
import linearstructures.*;
import non_linearstructures.*;
import java.util.Scanner;
import javax.swing.*; 

public class MainClass{
    public static CQueue CircularQueue;
    static boolean resultOfPut = false;
    public static void main (String args[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Windows OS look on dialog boxes
        }catch(Exception e){
        }

        //Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        int option;

        String tempChoice = JOptionPane.showInputDialog("Please enter the size of the queue required");
        int choice = Integer.parseInt(tempChoice);
        CircularQueue = new CQueue(choice);
        BinSearchTree bst = new BinSearchTree();

        JOptionPane.showMessageDialog(null, "Please enter the details of the director:");
        String DSeqNo = JOptionPane.showInputDialog("Enter Seq No: ");
        int dSeqNo = Integer.parseInt(DSeqNo);
        String DSurn = JOptionPane.showInputDialog("Enter surname: ");
        String DId = JOptionPane.showInputDialog("Enter ID: ");
        String DSal = JOptionPane.showInputDialog("Enter Salary: ");
        double Dsal = Double.parseDouble(DSal);
        double bonus = 15.0;
        resultOfPut = CircularQueue.put(new Director(dSeqNo,DId, DSurn, Dsal, bonus));
        
        do{
            String input = JOptionPane.showInputDialog(
                    "1: Populate Queue with new Employee\n"+ //works
                    "2: Populate Queue with new Part timer\n"+ // works
                    "3: Show all objects in Queue\n"+ //works
                    "4: Serve person from queue\n"+ //works
                    "5: Update the pay of a particular person\n"+ // i need to do
                    "6: Update the pay of all persons\n"+ //works
                    "7: Populate Binary Search Tree by all Queue objects\n"+ //works
                    "8: Search for a particular Person\n"+ //works
                    "9: Listing of Persons in ascending order\n"+ //worls
                    "10: Exit\n"+ //works 
                    "Choose 1 option from the menu available: ");

            option = Integer.parseInt(input);
            switch(option){

                case 1:
                staticPut("e");

                if(resultOfPut == true){
                    JOptionPane.showMessageDialog(null, "Success");
                    //CircularQueue.listAll();

                }
                else{
                    JOptionPane.showMessageDialog(null, "Error! The queue is full");
                }
                break;

                case 2:
                staticPut("pt");
                if(resultOfPut == true){
                    JOptionPane.showMessageDialog(null, "Success");
                    //CircularQueue.listAll();

                }
                else{
                    JOptionPane.showMessageDialog(null, "Error! The queue is full");
                }
                break;

                case 3:
                JOptionPane.showMessageDialog(null, "Contents of queue: \n");
                CircularQueue.listAll();
                break; 

                case 4:

                CircularQueue.serve();

                break;

                case 5:
                String surn = JOptionPane.showInputDialog("Enter surname: ");
                CircularQueue.editObject(surn); 

                break;

                case 6:
                String percent = JOptionPane.showInputDialog("Enter percentage: ");
                JOptionPane.showMessageDialog(null, "Updated contents of queue: \n");
                int percentage = Integer.parseInt(percent);
                CircularQueue.changePayOfAll(percentage);
                CircularQueue.listAll();
                break;

                case 7:
                bst.populateFromQueue(CircularQueue);
                break;

                case 8:
                String surnSearch = JOptionPane.showInputDialog("Enter Surname");
                AnyClass result = bst.search(surnSearch);
                if (result == null)
                    JOptionPane.showMessageDialog(null, "Not found");
                else
                    JOptionPane.showMessageDialog(null, result.getData());
                break;

                case 9:
                bst.listInOrder(); 
                break;

                case 10:
                System.exit(0);
                break;
            }
        }
        while(option!=10);
    }

    public static boolean staticPut(String objType){
        //Scanner input = new Scanner (System.in);
        //Scanner inputString = new Scanner (System.in);
        String seqNo = JOptionPane.showInputDialog("Enter Seq No: ");
        int SeqNo = Integer.parseInt(seqNo);
        String surn = JOptionPane.showInputDialog("Enter surname: ");

        String id = JOptionPane.showInputDialog("Enter ID: ");
        //String id = inputString.nextLine();
        if(objType == "e"){
            String pay = JOptionPane.showInputDialog("Enter Pay: ");
            double Pay = Double.parseDouble(pay);
            resultOfPut = CircularQueue.put(new Employee(SeqNo,surn,Pay,id));
        }  
        else if (objType == "pt"){
            String sal = JOptionPane.showInputDialog("Enter Salary: ");
            double ptSal = Double.parseDouble(sal);
            String hrs = JOptionPane.showInputDialog("Enter Hours worked: ");
            int ptHours = Integer.parseInt(hrs);
            resultOfPut = CircularQueue.put(new PartTimer(SeqNo,id, surn, ptSal, ptHours));
        }

        return resultOfPut;
    }
}
