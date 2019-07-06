class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        
        for(String s : cpdomains){
            int spaceIndex = s.indexOf(' ');
            int count = Integer.parseInt(s.substring(0, spaceIndex));
            String domain = s.substring(spaceIndex + 1);
            
            map.put(domain, map.getOrDefault(domain, 0) + count);
            
            for(int i = 0; i < domain.length(); i++)
                if(domain.charAt(i) == '.'){
                    String sub = domain.substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + count);
                }
        }
        
        List<String> result = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry : map.entrySet())
            result.add(entry.getValue() + " " + entry.getKey());
        
        return result;
    }
}