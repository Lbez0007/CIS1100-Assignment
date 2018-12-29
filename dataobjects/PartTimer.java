package dataobjects;

public class PartTimer extends Employee      //Inherits from Employee
{
    public int hours;
    
    public PartTimer(int iSeqNo, String iSurname, double iPay, String iIdNo, int iHours){
        super(iSeqNo, iSurname, iPay, iIdNo);  //Calling the constructor of PartTimer class
        hours = iHours;
    }
    
    public String getData(){                       //Polymorphic Method
        return super.getData() + ", Hours Worked: " + hours;
        //super.getData() calls getData() method of Employee
    }
    
    public double getSalary(){
        return pay * hours;          //In the case of part timer, pay is considered as rate/hr
    }
}
