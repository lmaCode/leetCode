public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if (isConcatenated(set, word)) ret.add(word);
        }
        return ret;
    }
    
    private boolean isConcatenated(Set<String> set, String s) {
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                String rightStr = s.substring(i);
                if (set.contains(rightStr) || isConcatenated(set, rightStr))
                    return true;
            }
        }
        return false;
    }
}