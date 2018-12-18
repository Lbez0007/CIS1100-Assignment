package non_linearstructures;

import binarynodes.BNode;
import dataobjects.AnyClass;

public class BinSearchTree
{
    public BNode root;  //first node inserted in tree

    public BinSearchTree(){
        root = null;
    }

    public void insertBST (AnyClass newObj){
        BNode newNd = new BNode(newObj);
        insertBST(root, newNd);
    }

    protected void insertBST (BNode parent, BNode newNode){
        if (root == null){
            //we are inserting first node in tree
            root = newNode;
        }

        else if (newNode.obj.seqNo < parent.obj.seqNo){
            if (parent.left == null)
                parent.left = newNode;
            else
                insertBST (parent.left, newNode);
        }

        else {
            //newNode should be placed on the right hand side of the parent
            if (parent.right == null)
            //we can link directly the newNode with parent
                parent.right = newNode;
            else
                insertBST (parent.right, newNode);
        }
    }

    public void inOrderBST(){
        inOrderBST(root);
    }

    /* This uses the recursion technique to display nodes 
    and moves bi-directionally for each node */
    protected void inOrderBST(BNode currentNode){
        if (currentNode != null){
            inOrderBST(currentNode.left);  //moves to left node
            currentNode.show();            //displays data of current node
            inOrderBST(currentNode.right); //moves to right node
        }
    }

    public AnyClass searchSeqNoBST (int keyNum){
        return searchSeqNoBST (root, keyNum);
    }

    protected AnyClass searchSeqNoBST (BNode currentNode, int keyNum){
        if (currentNode != null){
            if (keyNum == currentNode.obj.seqNo){
                return currentNode.obj;
            }
            else if (keyNum < currentNode.obj.seqNo){
                //REPEAT for left hand side
                
                return searchSeqNoBST(currentNode.left, keyNum);
            }
            else{
                return searchSeqNoBST(currentNode.right, keyNum);
            }
        }
        
        return null;
    }
}
