package linearnodes;

import dataobjects.*;

public class Node 
{ 
    public AnyClass obj;
    public Node next;

    public Node(AnyClass newObj){ 
        obj = newObj; 
        next = null;
    }

}