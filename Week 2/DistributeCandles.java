class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<Integer>();
        int kinds = 0;
        
        for(int i = 0; i < candies.length && kinds < candies.length / 2; i++)
            if(set.add(candies[i]))
                kinds++;
        
        return kinds;
    }
}