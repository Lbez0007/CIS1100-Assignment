package dataobjects;

import java.util.Scanner;

public class AnyClass
{
    public int seqNo;

    //default constructor
    public AnyClass(){
    }

    //non-default constructor
    public AnyClass(int iSeqno){
        //System.out.println(iSeqno);
        seqNo = iSeqno;

    }

    public String getData(){
        return "SeqNo: " + seqNo;
    }

    public void edit() 
    {
        System.out.println("Current seqNo is: " + seqNo);
        System.out.println("Enter the new seqNo: ");
        Scanner keyboard = new Scanner(System.in);
        seqNo = keyboard.nextInt();
    }

    public String getKey(){
        return "";                     //Actually, we can return whatever we want as String
    }

}
