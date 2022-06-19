import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        List<Integer> node[] = new ArrayList[n];
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] v = new boolean[n];

        for(int i=0;i<n;i++){
            node[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<wires.length;i++){
            node[wires[i][0] - 1].add(wires[i][1] - 1);
            node[wires[i][1] - 1].add(wires[i][0] - 1);
        }
        
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<node[i].size();j++){  
                queue.add(0);              

                int temp = node[i].get(j);
                int index = 0;
                
                if (temp > i) {
                    node[i].remove(j);
                    index = node[temp].indexOf(Integer.valueOf(i));
                    node[temp].remove(Integer.valueOf(i));

                    while (queue.size() > 0) {
                        int check = queue.pop();
                        v[check] = true;
                        for (int k = 0; k < node[check].size(); k++) {
                            if (!v[node[check].get(k)]) {
                                queue.add(node[check].get(k));
                            }
                        }
                    }

                    for(int cnt=0;cnt<n;cnt++){
                        if(v[cnt]) count++;
                        v[cnt] = false;
                    }

                    answer = Math.min(answer, Math.abs(count*2-n));
                    node[i].add(j, temp);
                    node[temp].add(index, i);
                    count = 0;
                }
            }
            queue.clear();
        }
        return answer;
    }
}