class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        int missing = 0, duplicate = 0;
        for(int i = 1; i <= nums.length; i++)
            if(map.containsKey(i)){
                if(map.get(i) > 1)
                    duplicate = i;
            }
            else
                missing = i;
            
        return new int[] {duplicate, missing};
    }
}