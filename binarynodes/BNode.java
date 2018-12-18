package binarynodes;
import dataobjects.AnyClass;   


public class BNode
{
    public BNode left; //to point to the left node (whose seqNo is less than seqNo of this node)
    public BNode right; //to point to the right node (whose seqNo is greater than seqNo of this node)
    public AnyClass obj;
    
    public BNode (AnyClass newObj){
        obj = newObj;
        left = null;
        right = null;
    }
    
    public void show()
    { 
        System.out.println( obj.getData());
    }
    
    public void editNode(){
        obj.edit();
    }
}
