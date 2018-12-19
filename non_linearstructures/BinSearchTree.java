package non_linearstructures;

import binarynodes.BNode;
import dataobjects.AnyClass;
import linearstructures.*;

public class BinSearchTree
{
    public BNode root;  //first node inserted in tree

    public BinSearchTree(){
        root = null;
    }

    //(a)
    public void insert (AnyClass newObj){
        BNode newNd = new BNode(newObj);
        root = insertBST(root, newNd);  //creating link between roots (root = parent)
    }

    protected BNode insertBST (BNode parent, BNode newNode){
        if (parent == null){
            //we are inserting first node in tree
            parent = newNode;
        }

        else if (newNode.obj.getKey().compareTo(parent.obj.getKey())<0){
            //inserting left of parent node due to having a lesser key than parent
            parent.left = insertBST (parent.left, newNode);
        }

        else {
           //inserting right of parent node due to having a lesser key than parent
            parent.right = insertBST (parent.right, newNode);
        }
        return parent;
    }

    //(b)
    public AnyClass search (String key){
        AnyClass obj = searchBST(root, key);
        if (obj != null)
            return obj;
        else
            return null;
    }

    protected AnyClass searchBST (BNode currentNode, String pKey){
        if (currentNode != null){
            if (pKey == currentNode.obj.getKey()){
                return currentNode.obj;
            }
            else if (pKey.compareTo(currentNode.obj.getKey())<0){
                //REPEAT for left hand side
                return searchBST(currentNode.left, pKey);
            }
            else{
                //REPEAT for right hand side
                return searchBST(currentNode.right, pKey);
            }
        }
        else
            return null;
    }
    
    //(c)
    public void listInOrder(){ //listing in ascending order
        inOrderBST(root);      //for InOrder sorting to start from root/parent of BST
    }

    /* This uses the recursion technique to display nodes 
    and moves bi-directionally for each node */
    protected void inOrderBST(BNode parent){   //Inorder = left, then root, then right
        if (parent != null){ //when null, no data is to be shown, thus moving a step back in the recursive algorithm
            inOrderBST(parent.left);  //moves to left node
            parent.obj.getData();     //displays data of current node
            inOrderBST(parent.right); //moves to right node
        }
    }
    
    //(d)
    public void populateFromQueue(CQueue que){
        
        while(que.front != que.rear.next){
            AnyClass obj = que.serve();  //serving from queue and emptying it in the process
            insert(obj);                 //populating BST from queue
        }
    }
}
