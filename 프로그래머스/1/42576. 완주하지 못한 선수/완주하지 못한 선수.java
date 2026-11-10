import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> runner = new HashMap<>();
        
        for (String name: participant) {
            runner.put(name, runner.getOrDefault(name, 0) + 1);
        }
        
        for (String name2: completion) {
            if (runner.get(name2) > 1) {
                runner.put(name2, runner.get(name2) - 1);
            }
            else { // 1일 때
                runner.remove(name2);
            }
        }
        for (String key : runner.keySet()) {
            answer = key;
        }
        return answer;
    }
}