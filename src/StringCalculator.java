public class StringCalculator{
    public int calc(String exp) {
        String [] numbers = exp.split(",");
        int i = Integer.parseInt(numbers[0]);
        int j= Integer.parseInt(numbers[1]);
        return i + j;
    }
}