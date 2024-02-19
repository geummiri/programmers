import java.util.*;
class Solution {
       public String solution(int[] numbers) {
       
        return array(numbers);
    }
        
    private String array(int[] numbers){
        String str = "";
        String[] arrayNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) 
            arrayNum[i] = String.valueOf(numbers[i]);

        Arrays.sort(arrayNum, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(arrayNum[0].equals("0")) return "0";
        
        for(String s : arrayNum)  str+=s;
           
        return str;
    }
      
}