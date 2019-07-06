class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s.length() < p.length())
            return result;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < p.length(); i++)
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        
        int left = 0, right = 0, count = 0;
        
        while(right < s.length()){
            char rc = s.charAt(right);
            if(map.containsKey(rc)){
                if(map.replace(rc, map.get(rc) - 1) == 1)
                    count++;
            }
            
            right++;
            
            if(count == map.size())
                result.add(left);
            
            if(right - left == p.length()){
                char lc = s.charAt(left);
                if(map.containsKey(lc)){
                    if(map.replace(lc, map.get(lc) + 1) == 0)
                        count--;
                }
                left++;
            }
        }
        
        return result;
    }
}