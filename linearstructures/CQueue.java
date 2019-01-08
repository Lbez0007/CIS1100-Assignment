package linearstructures;
import dataobjects.AnyClass;
import dataobjects.Employee;
import dataobjects.PartTimer;
import linearnodes.*;
import java.util.Scanner;
import javax.swing.*; 

public class CQueue{

    public Node front;  //first item in circular queue
    public Node rear;   //last item in circular queue
    public boolean isFull;  //indicates whether queue is full or not

    public CQueue (int maxNoOfNodes){
        for (int i= 0; i<maxNoOfNodes; i++){

            Node newNode = new Node (null);  //creating new empty node

            if (i == 0){
                //first node being put in circular queue
                front = newNode;
                rear = newNode;
            }
            else
            {
                //the nodes put in circular queue which are not the first/initial node
                rear.next = newNode;
                rear = newNode;
            }
        }
        rear.next = front;  //to enofrce queue in behaving as a circular one
        isFull = false;  
    }

    //returns true if the item is successfully put in the circular queue
    public boolean put(AnyClass newObj){

        if (isFull == false){
            //queue is not full 
            rear = rear.next;
            rear.obj = newObj;

            if (rear.next == front){
                //we just filled in circular queue
                isFull = true;
            }

            return true;
        }

        else{ 
            //queue is full
            return false;
        }
    }
    //(c) 
    public AnyClass serve(){
        if (isFull == true || rear.next != front){

            //circular queue contains at least one node, thus we can serve
            Node itemToDelete = front;

            front = front.next;  //Logically, this means item is deleted
            isFull = false;
            JOptionPane.showMessageDialog(null, itemToDelete.obj.getData());
            return itemToDelete.obj;
        }

        else{
            //circular queue is empty
            return null;
        }
    }
    //(d)
    public void listAll(){
        if (isFull == true || rear.next != front){
            //Our circular queue contains at least 1 item
            Node currentNode = front;

            do{
                JOptionPane.showMessageDialog(null, currentNode.obj.getData());
                currentNode = currentNode.next;
            }while (currentNode != rear.next);
        }
        else{
            JOptionPane.showMessageDialog(null, "The circular queue has no contents"); 
        }
    }
    //(e)
    boolean completed = false;
    public AnyClass editObject(String key){
        Node currentNode = front;
        AnyClass temp = currentNode.obj;;
        if (isFull == true || rear.next != front){
            //Our circular queue contains at least 1 item
            String tIdNo = JOptionPane.showInputDialog("Enter ID number: ");

            currentNode = front;
            do{
                temp = currentNode.obj;

                if(temp.getKey().equals(key) && temp.getID().equals(tIdNo)){
                    String tempNewPay = JOptionPane.showInputDialog("Enter new pay: ");
                    double newPay = Integer.parseInt(tempNewPay);
                    ((Employee)temp).pay = newPay;
                    completed = true;
                    JOptionPane.showMessageDialog(null, "Success");
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Person not found");
                    completed = false;
                }

                currentNode = currentNode.next;
            }while (currentNode != rear.next||completed==true);
        }
        else{
            JOptionPane.showMessageDialog(null, "\nThe circular queue has no contents\n45"); 
        }
        return temp;
    }
    //(f)
    public void changePayOfAll(double percent){
        if (isFull == true || rear.next != front){
            Node currentNode = front; 
            do{
                AnyClass temp = currentNode.obj;

                percent = (double) percent;
                double percentage = 1+(percent/100);
                double EmployeePay = ((Employee)temp).pay;
                double total = EmployeePay*percentage;
                if(temp instanceof PartTimer){
                    ((PartTimer)temp).pay = total;
                }
                else{
                    ((Employee)temp).pay = total;
                }

                currentNode = currentNode.next;
            }while (currentNode != rear.next);
        }
    }
}

