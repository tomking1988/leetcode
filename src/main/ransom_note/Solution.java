package ransom_note;

import java.util.HashMap;

/**
 * Created by xin on 8/14/2016.
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
        for(int i=0; i < magazine.length(); i++){
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++){
            int left = magazineMap.getOrDefault(ransomNote.charAt(i), 0) - 1;
            if(left < 0) {
                return false;
            }
            magazineMap.put(ransomNote.charAt(i), left);
        }
        return true;
    }
}