class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if(sMap[sChar] != 0 || tMap[tChar] != 0){
                if(sMap[sChar] != tChar || tMap[tChar] != sChar)
                    return false;
            }
            else{
                sMap[sChar] = tChar;
                tMap[tChar] = sChar;
            }
        }
        
        return true;
    }
}