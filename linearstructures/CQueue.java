package linearstructures; 


import linearnodes.Node;
import dataobjects.AnyClass;

public class CQueue{

    public Node front;  //first item in circular queue
    public Node rear;   //last item in circular queue
    public boolean isFull;  //indicates whether queue is full or not

    public CQueue (int maxNumberOfNodes){
        for (int i= 0; i<maxNumberOfNodes; i++){

            Node newNode = new Node (null);  //creating new emptu node

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
            //we can put the item into the circular queue since queue is not yet full
            rear = rear.next;
            rear.obj = newObj;

            if (rear.next == front){
                //we just filled in circular queue
                isFull = true;
            }
            return true;
        }

        else{
            //our queue is already full; thus we cannot put item in circular queue
            return false;
        }
    }

    public void traverseQueue(){
        if (isFull == true || rear.next != front){
            //Our circular queue contains at least 1 item
            Node currentNode = front;

            do{
                currentNode.show();
                currentNode = currentNode.next;
            }while (currentNode != rear.next);
        }
    }

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
}

