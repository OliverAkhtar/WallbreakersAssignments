class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : A.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s : B.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        List<String> result = new ArrayList<String>();
        for(String s : map.keySet())
            if(map.get(s) == 1)
                result.add(s);
        
        return result.toArray(new String[result.size()]);
    }
}