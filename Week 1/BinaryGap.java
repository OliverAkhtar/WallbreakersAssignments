class Solution {
    public int binaryGap(int n) {
        int maxGap = 0, currentGap = 0;
        
        while((n & 1) == 0)
            n >>= 1;
        
        n >>= 1;
        
        while(n > 0){
            if((n & 1) == 0)
                currentGap++;
            else if((n & 1) == 1){
                currentGap++;
                if(currentGap > maxGap)
                    maxGap = currentGap;
                currentGap = 0;
            }
            n >>= 1;
        }
        
        return maxGap;
    }
}