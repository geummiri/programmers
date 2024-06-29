class Solution {
    public int solution(String[] babbling) {
        
        String[] str = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for(int i=0; i<babbling.length; i++) {
            String word = babbling[i];
            for(int j=0; j<str.length; j++){
                if(word.contains(str[j]))
                    word = word.replaceFirst(str[j],"-");
            }
            word = word.replaceAll("-","");
            if(word.isEmpty()) answer++;
        }
        return answer;
    }
}