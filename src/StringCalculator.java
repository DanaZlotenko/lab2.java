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
            //checking if we have multiple delimiters / delimiters with multiple characters
            if(input.get(0).contains("[")) {
                //putting 1 line with delimiters in allDelimiters var
                String allDelimiters = input.get(0);
                //parsing it
                allDelimiters = allDelimiters.replaceAll("//", "");
                //putting different delimiters in array
                String[] delPatterns = allDelimiters.split("]");
                for (String s : delPatterns) {
                    s = s.replaceAll("\\[", "");
                    //getting delimiter pattern
                    delimiters.add(Character.toString(s.charAt(1)));
                }
            }
            //removing first line with custom delimiter
            exp = exp.substring(exp.indexOf('\n')+1);
            //in case of multiple characters
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