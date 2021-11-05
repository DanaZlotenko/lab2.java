import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator{
    public int calc(String exp) {
        List<String> delimiters = new ArrayList<>();
        //bacis delimiter
        delimiters.add("\n");
        List<String> input;
        List<String> numbers;

        //custom delimiter parsing
        if(exp.startsWith("//")) {
            //getting first line
            input = Arrays.asList(exp.split("\n"));
            //putting parsed delimiter in delimiters list
            delimiters.add(input.get(0).replaceAll("//", ""));
            //removing first line with custom delimiter
            exp = exp.substring(exp.indexOf('\n')+1);
            //in case of multiple characters
            if(delimiters.get(1).contains("[") && delimiters.get(1).contains("]")) {
                //removing brackets
                delimiters.set(1, delimiters.get(1).replaceAll("\\[", ""));
                delimiters.set(1, delimiters.get(1).replaceAll("\\]", ""));
                //getting patter of delimiter
                delimiters.set(1, Character.toString(delimiters.get(1).charAt(0)));
            }
        }

        //replacing all delimiter variations with one ',' sign
        for(String d : delimiters) {
            String regex = "\\\\" + d + "+";
            exp = exp.trim().replaceAll(String.format("\\%s", d), ",");
            exp = exp.trim().replaceAll(",+", ",");
        }

        numbers = Arrays.asList(exp.split(","));
        List<Integer> resultList = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        //putting numbers to result list
        for(String s : numbers) {
            int number = Integer.parseInt(s);
            if(number < 0)
                //negative number going to negativeNumbers list
                negativeNumbers.add(number);
            else if(number > 1000) {
                //eblanim
            }
            else
                //adding to final list
                resultList.add(Integer.parseInt(s));

        }
        //throwing exceptions is there are negative numbers
        if(!negativeNumbers.isEmpty()) {
            throw new RuntimeException("Negative numbers in the expression: " + negativeNumbers);
        } else {
            //finding sum of all numbers in result list
            int result = 0;
            for (Integer i : resultList) {
                result += i;
            }
            return result;
        }
    }
}