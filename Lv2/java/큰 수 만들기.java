class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int size = number.length(), index = 1, tmpK = k;
        char[] temp = number.toCharArray();
        char[] ans = new char[size-k];

        ans[0] = temp[0];

        for(int i = 1; i<size; i++){
            if(index < size - tmpK && index < size-k && ans[index - 1] >= temp[i]){
                ans[index++] = temp[i];
            }
            else if(index <= size-k){
                for(int j=index-1; j>=0;j--){
                    if(k > 0 && temp[i] > ans[j]){
                        ans[j] = 0;
                        index--;
                        k--;
                    }
                    else break;
                }
                if(index < size - tmpK) ans[index++] = temp[i];
            }
        }

        return String.valueOf(ans);
    }
}