public class Forecast {
    public static int futureValue(int amount, int years) {
        if(years == 0) {
            return amount;
        }
        return futureValue(amount + 1000, years - 1);
    }
    public static void main(String[] args) {
        int result = futureValue(10000, 5);
        System.out.println("Future Value = " + result);
    }
}