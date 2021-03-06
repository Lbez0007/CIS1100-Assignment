package dataobjects;
import javax.swing.JOptionPane; 
import java.util.regex.Matcher; //for ID matching 
import java.util.regex.Pattern;
import javax.swing.JPanel; //for error messages

public class Employee extends AnyClass   //Inherits from AnyClass
{
    public String surname;
    public String idNo;
    public double pay;

    public Employee(int iSeqNo, String iSurname, double iPay, String iIdNo){
        super(iSeqNo); //Calling the constructor of the class being inherited i.e. AnyClass
        surname = iSurname;
        pay = iPay;
        setID(iIdNo);
        idNo = getID();
    }

    public String getData(){                    //Polymorphic Method            
        return super.getData() + " Surname: " + surname + " ID: " + idNo + " Pay: " + pay;
        //super.getData() calls getData() method of AnyClass
    }

    public String getKey(){
        return surname; //The key used for operations of searching and editing will be surname. 
    }

    public void edit() 
    {
        JOptionPane.showMessageDialog(null, "Current pay is: " + pay);
        String tempPay = JOptionPane.showInputDialog("Enter the new pay: ");
        double pay = Double.parseDouble(tempPay);
    }

    public String getID(){
        return idNo; 
    }

    public void setID(String pIdNo){
        boolean matched = false;
        Matcher i = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]").matcher(pIdNo);
        final JPanel panel = new JPanel();
        do{
            if (i.find() && pIdNo.length() < 9) {
                idNo = pIdNo;
                matched = true;
            } 

            else {
                JOptionPane.showMessageDialog(panel, pIdNo + " is not a valid number ID",  "Error", JOptionPane.ERROR_MESSAGE);
                pIdNo = JOptionPane.showInputDialog("Re-enter ID Card Number: "); 
                setID(pIdNo);
                matched = true;
            }

        }while (matched != true);

    }

    public double getPay(){
        return pay;          
    }

}
