package linearnodes;

import dataobjects.AnyClass;

public class Node
{ 
    public AnyClass obj;
    public Node next;
    
    public Node( AnyClass newObj)
    { 
        obj = newObj;
        next = null;
    }

    public void show()
    { 
        System.out.println( obj.getData());
    }
    
    public void editNode(){
        obj.edit();
    }
}