class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char result = 0;
        
        for(int i = 0; i < s.length(); i++)
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1 );
        
        for(int i = 0; i < t.length(); i++)
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1 );
        
        for(int i = 0; i < t.length(); i++)
            if(!map1.containsKey(t.charAt(i)) || map1.get(t.charAt(i)) != map2.get(t.charAt(i)))
                result = t.charAt(i);
        
        
        return result;
    }
}