import java.util.ArrayList;
import java.util.List;

public class StringCalculator{
    public int calc(String exp) {
        String [] numbers = exp.split(",");
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