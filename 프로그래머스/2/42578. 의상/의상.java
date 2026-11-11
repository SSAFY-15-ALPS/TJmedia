import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> cony = new HashMap<>();
        
        for (String[] cloth : clothes) {
            cony.put(cloth[1], cony.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (Map.Entry<String, Integer> cnt : cony.entrySet()) {
            answer *= cnt.getValue() + 1;
        }
        
        return answer - 1;
    }
}