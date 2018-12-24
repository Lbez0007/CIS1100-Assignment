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

}