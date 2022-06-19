import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String parti : participant) {
            if(map.get(parti) != null) map.put(parti, (int)map.get(parti) + 1);
            else map.put(parti, 1);
        }
        
        for(String comp : completion) { 
            try{
                int index = (int)map.get(comp);
                if(index > 1) {
                    map.put(comp, index-1);
                }
                else {
                    map.remove(comp);
                }
            }
            catch(Exception e) {
                
            }
        }
        
        
        for(String key : map.keySet()){
            answer = key;
        }
        
        return answer;
    }
}