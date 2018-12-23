package linearstructures;
import dataobjects.AnyClass;
import dataobjects.Employee;
import dataobjects.PartTimer;
import linearnodes.*;
import java.util.Scanner;

public class CQueue{

    public Node front;  //first item in circular queue
    public Node rear;   //last item in circular queue
    public boolean isFull;  //indicates whether queue is full or not
    Scanner input = new Scanner(System.in);
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
            System.out.println("Success");//(b)
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
                System.out.println(currentNode.obj.getData());
                currentNode = currentNode.next;
            }while (currentNode != rear.next);
        }
        else{
            System.out.println("The circular queue has no contents"); 
        }
    }
    //(e)
    boolean completed = false;
    public AnyClass editObject(int key){
        Node currentNode = front;
        AnyClass temp = currentNode.obj;;
        if (isFull == true || rear.next != front){
            //Our circular queue contains at least 1 item
            System.out.println("Enter new pay: ");
            int newPay = input.nextInt();
            currentNode = front;
            do{
                temp = currentNode.obj;
                if(temp instanceof Employee && temp.seqNo == key){
                    ((Employee)temp).pay = newPay;
                    completed = true;
                    break;
                }
                else if(temp instanceof PartTimer && temp.seqNo == key){
                    ((PartTimer)temp).pay = newPay;
                    completed = true;
                    break;
                }
                else{
                    completed = false;
                }
                currentNode = currentNode.next;
            }while (currentNode != rear.next||completed==true);
        }
        else{
            System.out.println("\nThe circular queue has no contents\n45"); 
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
                if(temp instanceof Employee){
                    ((Employee)temp).pay = total;
                }
                else{
                    ((PartTimer)temp).pay = total;
                }

                currentNode = currentNode.next;
            }while (currentNode != rear.next);
        }
    }
}

