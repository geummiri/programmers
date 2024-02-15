import java.util.*;

class Solution {
  public int solution(String numbers) {
        int answer = 0;
        //중복 HashMap

        Map<Integer,Integer> map =  prime(0, new boolean[numbers.length()], numbers, "", new HashMap<>());
        return map.size();

    }
    
    
    private Map<Integer, Integer> prime(int depth, boolean[] visited, String numbers, String num, Map<Integer, Integer> map) {
        if(num != ""){
            if(isPrime(Integer.parseInt(num)))  map.put(Integer.parseInt(num), 0);
        }
        
        //basecase
        if(depth == numbers.length()) return map;

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                prime(depth+1, visited, numbers, num + Character.getNumericValue(numbers.charAt(i)), map);
                visited[i] = false;
            }
        }
        return map;
    }
    
    private boolean isPrime(int num) {
        if(num<2)
            return false;
        if(num==2)
            return true;
        if(num%2==0)
            return false;
        for(int i=3; i<=Math.sqrt(num); i+=2)
            if(num%i==0)
                return false;
        return true;
    }
}