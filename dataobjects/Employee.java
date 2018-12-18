package dataobjects;

public class Employee extends AnyClass   //Inherits from AnyClass
{
    public String surname;
    public double pay;
    
    public Employee(int iSeqNo, String iSurname, double iPay){
        //seqNo = iSeqNo;     (No need due to being done in AnyClass
        super(iSeqNo);         //Calling the constructor of the class being inherited i.e. AnyClass
        surname = iSurname;
        setPay(iPay);
    
    }
    
    public double getSalary(){
        return pay;
    }
    
    public void setPay(double newPay){
        pay = newPay;    
    }
    
    public String getData(){                    //Polymorphic Method            
        return super.getData() + ", Surname: " + surname + ", Pay: " + pay;
        //super.getData() calls getData() method of AnyClass
    }
    
    public String getKey(){
        return surname;
    }
}
