import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator{
    public int calc(String exp) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add("\n");
        List<String> input;
        List<String> numbers = new ArrayList<>();
        if(exp.startsWith("//")) {
            input = Arrays.asList(exp.split("\n"));
            delimiters.add(input.get(0).replaceAll("//", ""));
            exp = exp.substring(exp.indexOf('\n')+1);
        }
        for(String d : delimiters) {
            exp = exp.replaceAll(d, ",");
        }
        numbers = Arrays.asList(exp.split(","));
        List<Integer> list = new ArrayList<>();
        for(String s : numbers) {
            list.add(Integer.parseInt(s));
        }
        int result = 0;
        for(Integer i : list ) {
            result += i;
        }
        return result;
    }
}