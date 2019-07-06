class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        while(n != 1){
            int num = n, sum = 0;
            while(num != 0){
                sum += Math.pow(num % 10, 2);
                num /= 10;
            }
            if(!set.add(sum))
                return false;
            n = sum;
        }
        
        return true;
    }
}