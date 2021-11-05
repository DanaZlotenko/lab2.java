import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator{
    public int calc(String exp) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add("\n");
        List<String> input;
        List<String> numbers;

        if(exp.startsWith("//")) {
            input = Arrays.asList(exp.split("\n"));
            delimiters.add(input.get(0).replaceAll("//", ""));
            exp = exp.substring(exp.indexOf('\n')+1);
        }

        for(String d : delimiters) {
            exp = exp.replaceAll(d, ",");
        }

        numbers = Arrays.asList(exp.split(","));
        List<Integer> resultList = new ArrayList<>();

        List<Integer> negativeNumbers = new ArrayList<>();
        for(String s : numbers) {
            int number = Integer.parseInt(s);
            if(number < 0) {
                negativeNumbers.add(number);
            } else {
                resultList.add(Integer.parseInt(s));
            }
        }
        if(!negativeNumbers.isEmpty()) {
            throw new RuntimeException("Negative numbers in the expression: " + negativeNumbers);
        } else {
            int result = 0;
            for (Integer i : resultList) {
                result += i;
            }
            return result;
        }
    }
}