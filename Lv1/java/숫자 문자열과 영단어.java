import java.util.*;

class Solution {

    static class WordIndex{

        private List<Character> endList = new ArrayList<>();
        private List<Integer> lengthList = new ArrayList<>();

        private List<Integer> indexList = new ArrayList<>();

        public WordIndex(char end, int length, int index){
            endList.add(end);
            lengthList.add(length);
            indexList.add(index);
        }

        public List<Character> getEndList(){
            return endList;
        }

        public List<Integer> getLengthList(){
            return lengthList;
        }

        public List<Integer> getindexList(){
            return indexList;
        }

        public void addEndList(char end){
            endList.add(end);
        }

        public void addLengthList(int length){
            lengthList.add(length);
        }

        public void addIndexList(int index){
            indexList.add(index);
        }

    }

    public int solution(String s) {
        int answer = 0;
        String ans = "";
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<Character, WordIndex> words = new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            if(words.get(numbers[i].charAt(0)) == null){
                WordIndex wdIndex = new WordIndex(numbers[i].charAt(numbers[i].length()-1), numbers[i].length(), i);
                words.put(numbers[i].charAt(0), wdIndex);
            }
            else{
                WordIndex wdIndex = words.get(numbers[i].charAt(0));
                wdIndex.addEndList(numbers[i].charAt(numbers[i].length()-1));
                wdIndex.addLengthList(numbers[i].length());
                wdIndex.addIndexList(i);
                words.put(numbers[i].charAt(0), wdIndex);
            }
        }

        for(int i=0;i<s.length();i++){
            if(words.get(s.charAt(i)) != null){
                WordIndex wdIndex = words.get(s.charAt(i));
                for(int j=0;j<wdIndex.getEndList().size();j++){
                    if(s.length() >= (i+wdIndex.getLengthList().get(j))
                            && s.substring(i, i+wdIndex.getLengthList().get(j)).equals(numbers[wdIndex.getindexList().get(j)])){
                        ans += wdIndex.getindexList().get(j).toString();
                        i+=(wdIndex.getLengthList().get(j)-1);
                    }
                }
            }
            else {
                ans += s.substring(i, i+1);
            }
        }

        return Integer.parseInt(ans);
    }
}