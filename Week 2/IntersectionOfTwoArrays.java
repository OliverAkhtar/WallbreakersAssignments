class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for(int i : nums1)
            set1.add(i);
        for(int i : nums2)
            if(set1.contains(i))
                intersect.add(i);
        
        
        int[] result = new int[intersect.size()];
        int i = 0;
        for(int num : intersect)
            result[i++] = num;
        
        return result;
    }
}