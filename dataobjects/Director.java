package dataobjects;

public class Director extends Employee{
    double bonus;
    double finalPay;
    public Director(int iSeqNo, String iIdNo, String iSurname, double iPay, double iBonus){
        super(iSeqNo, iSurname, iPay, iIdNo);  //Calling the constructor of PartTimer class
        bonus  = iBonus;
        finalPay = setPay(iPay,iBonus);
    }
    
    public double setPay(double pay, double bonus){
        double percentageBonus = (100.0 + bonus)/100;
        return (pay*percentageBonus);
    }
    
    public String getData(){ //Polymorphic Method
        return super.getData() + " Bonus: " + bonus + " % " + "Final Pay: " + finalPay;
        //super.getData() calls getData() method of Employee 
    }
}
    