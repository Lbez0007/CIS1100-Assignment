package dataobjects;
import java.util.Scanner;
import javax.swing.JOptionPane; 

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

    }

    /*public int getSeqNo(){
    return seqNo;
    }

    public void setSeqNo(int pSeqNo){
    seqNo = pSeqNo;
    }*/

    public String getID(){
        return null; 
    }

    public double getPay(){
        return 0;
    }


}
