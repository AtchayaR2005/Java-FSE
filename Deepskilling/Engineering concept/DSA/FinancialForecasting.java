package DSA;

public class FinancialForecasting {

    static double futureValue(double amount,int year){

        if(year==0)
            return amount;

        return futureValue(amount*1.10,year-1);

    }

    public static void main(String args[]){

        double value=futureValue(10000,5);

        System.out.println("Future Value = "+value);

    }

}
