public static int[] solution(String[][] places) {
    int[] answer = new int[places.length];
    for(int i=0;i< answer.length;i++) answer[i] = 1;


    int index = 0;
    for(String[] strs : places){
        for(int i=0;i< strs.length;i++){
            for(int j=0;j<strs[0].length();j++){
                if(strs[i].charAt(j) == 'P'){
                    if((i<strs.length-1 && strs[i+1].charAt(j) == 'P')
                            || (j<strs.length-1 && strs[i].charAt(j+1) == 'P')){
                        answer[index] = 0;
                        break;
                    }
                    else if((i<strs.length-2 && strs[i+2].charAt(j) == 'P' && strs[i+1].charAt(j) == 'O')
                            || (j<strs.length-2 && strs[i].charAt(j+2) == 'P' && strs[i].charAt(j+1) == 'O')) {
                        answer[index] = 0;
                        break;
                    }
                    else if((i>0 && j<strs.length-1 && strs[i-1].charAt(j+1) == 'P' && (strs[i-1].charAt(j) == 'O' || strs[i].charAt(j+1) == 'O'))
                            || (i<strs.length-1 && j<strs.length-1 && strs[i+1].charAt(j+1) == 'P' && (strs[i+1].charAt(j) == 'O' || strs[i].charAt(j+1) == 'O'))){
                        answer[index] = 0;
                        break;
                    }
                }
            }
            if(answer[index] == 0) break;
        }
        index++;
    }
    return answer;
}