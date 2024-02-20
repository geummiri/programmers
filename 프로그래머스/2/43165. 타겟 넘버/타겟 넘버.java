class Solution {
    
    public int solution(int[] numbers, int target) {
        return recursion(numbers,target, new boolean[numbers.length], 0, 0);
    }

    private int recursion(int[] numbers ,int target,  boolean[] visited, int depth, int sum) {
        int count = 0;

        if(depth == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

                count += recursion(numbers,target, visited, depth+1, sum+numbers[depth]);
                count += recursion(numbers,target, visited, depth+1, sum-numbers[depth]);
            return count;
    }
}