public class Main {
    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();
        int result = calc.calc("//;\n1,2;3\n4;5;-6,-12");
        System.out.println(result);
    }
}


