import java.lang.StringBuilder;
import java.lang.Math;
import java.lang.Integer;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        StringBuilder prefix = new StringBuilder("");
        int minLength = Integer.MAX_VALUE;
        
        for(int i = 0; i < strs.length; i++)
            if(strs[i].length() < minLength)
                minLength = strs[i].length();
        
        char c;
        boolean flag = true;
        
        for(int i = 0; i < minLength; i++){
            c = strs[0].charAt(i);
            for(int j = 1; j < strs.length && flag; j++){
                if(strs[j].charAt(i) != c)
                    flag = false;
            }
            if(flag)
                prefix.append(c);
            else
                return prefix.toString();
        }
        
        return prefix.toString();
    }
}