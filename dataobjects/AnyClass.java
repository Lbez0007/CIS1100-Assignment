package dataobjects;
import java.util.Scanner;

public class AnyClass
{
    public int seqNo;
    public double pay;
    //default constructor
    public AnyClass(){
    }

    public AnyClass(int iSeqno){
        seqNo = iSeqno;
    }

    public String getData(){
        return "SeqNo: " + seqNo;
    }
    
    public String getKey(){
        return String.valueOf(seqNo);
    }

    public void edit() 
    {
        System.out.println("Current seqNo is: " + seqNo);
        System.out.println("Enter the new seqNo: ");
        Scanner keyboard = new Scanner(System.in);
        seqNo = keyboard.nextInt();
    }

    public int getSeqNo(){
        return seqNo;
    }

    public void setSeqNo(int pSeqNo){
        seqNo = pSeqNo;
    }
     
   

}
