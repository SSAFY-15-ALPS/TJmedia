import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] array = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        
        if (array[0].equals("0")) {
            return "0";
        }
        
        for (String s : array) {
            sb.append(s);
        }
        
        answer = sb.toString();
        return answer;
    }
}