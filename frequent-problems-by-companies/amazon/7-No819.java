class Solution {
	//Most Common Word
    public String mostCommonWord(String paragraph, String[] banned) {
		String ns = paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
		String[] words = ns.split("\\s+");
		Set<String> bannedWords = new HashSet<>();
		for(String word : banned){
			bannedWords.add(word);
		}
		Map<String,Integer> wordCount = new HashMap<>();
		for(String word:words){
			if(!bannedWords.contains(word)){
				word.put(word, wordCount.getOrDefault(word, 0) + 1);
			}
		}
		return Collections.max(wordCount.keySet(),Map.Entry.comparingByValue()).getKey();
    }
}