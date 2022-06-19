import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        Map<String, Integer> idMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        
        for(String id : id_list) {
            idMap.put(id, 0);
            resultMap.put(id, 0);
        }
        
        Iterator iter = reportSet.iterator();
        while(iter.hasNext()){
            String report_id = iter.next().toString();
            String ids[] = report_id.split(" ");
            idMap.put(ids[1], idMap.get(ids[1]) + 1);            
        }
        
        iter = reportSet.iterator();
        while(iter.hasNext()){
            String report_id = iter.next().toString();
            String ids[] = report_id.split(" ");
            
            if(idMap.get(ids[1]) >= k) resultMap.put(ids[0], resultMap.get(ids[0]) + 1);
        }
        
        
        
        for(int i=0;i<id_list.length;i++){
            answer[i] = resultMap.get(id_list[i]);
        }
        
        
        return answer;
    }
}