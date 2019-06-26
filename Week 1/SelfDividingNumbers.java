class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = left; i <= right; i++){
            int num = i;
            boolean isSelfDividing = true;
            while(num > 0){
                int nextDigit = num % 10;
                if(nextDigit == 0 || i % nextDigit != 0){
                    isSelfDividing = false;
                    break;
                }
                num /= 10;
            }
            if(isSelfDividing)
                result.add(i);
        }
        
        return result;
    }
}