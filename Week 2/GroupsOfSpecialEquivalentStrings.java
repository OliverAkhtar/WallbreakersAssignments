class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<String>();
        
        for(String s : A){
            int[] charCounts = new int[52];
            for(int i = 0; i < s.length(); i++)
                charCounts[(s.charAt(i) - 'a') + (26 * (i % 2))]++;
            set.add(Arrays.toString(charCounts));
            
        }
        
        return set.size();
    }
}