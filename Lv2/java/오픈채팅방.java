import java.util.*;

class Solution {
    static class ListArray{
        private String nickname;
        private List<Integer> indexs = new ArrayList<>();

        public ListArray(String name, int index){
            this.nickname = name;
            this.indexs.add(index);
        }

        public void add(String name, int index){
            this.nickname = name;
            this.indexs.add(index);
        }

        public void addIndex(int index){
            this.indexs.add(index);
        }

        public void changeNickName(String name){
            this.nickname = name;
        }

        public String getNickname(){
            return this.nickname;
        }

        public List<Integer> getIndexs() {
            return this.indexs;
        }
    }

    public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        Map<String, ListArray> map = new HashMap<>();
        int cnt = 0;

        for(int i=0;i<record.length;i++){
            String[] values = record[i].split(" ");

            if(map.get(values[1]) == null){
                ListArray array = new ListArray(values[2], cnt++);
                map.put(values[1], array);
            }
            else {
                if(values[0].equals("Enter")){
                    ListArray array = map.get(values[1]);
                    if(!array.getNickname().equals(values[2])){
                        for(int index : array.getIndexs()) {
                            list.set(index, list.get(index).replace(map.get(values[1]).getNickname(), values[2]));
                        }
                    }
                    array.add(values[2], cnt++);
                    map.put(values[1], array);
                }
                else if(values[0].equals("Leave")){
                    ListArray array = map.get(values[1]);
                    array.addIndex(cnt++);
                    map.put(values[1], array);
                }
                else if(values[0].equals("Change")){
                    ListArray array = map.get(values[1]);
                    List<Integer> indexs = map.get(values[1]).getIndexs();

                    for(int index : indexs) {
                        list.set(index, list.get(index).replace(map.get(values[1]).getNickname(), values[2]));
                    }
                    array.changeNickName(values[2]);
                }
            }

            if(values[0].equals("Enter")){
                list.add(values[2] + "님이 들어왔습니다.");
            }
            else if(values[0].equals("Leave")){
                list.add(map.get(values[1]).getNickname() + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[list.size()]);
    }
}