class solution{
	public String[] recorderLogFiles(String[] logs){
		Array.sort(logs, (log1, log2)->{
			String[] s1 = log1.split(" ",2);
			String[] s2 = log2.split(" ",2);
			boolean isD1 = Character.isDigit(s1[1].charAt(0));
			boolean isD2 = Character.isDigit(s2[1].charAt(0));
			if(!isD1&&!isD2){
				int cmp = s1[1].compareTo(s2[1]);
				if(cmp!=0)return cmp;
				return s1[0].compareTo(s2[0]);
			}
			return isD1?(isD2?0:1):-1;
		});
		return logs;
	}
	/*
	//beat 99%
	public String[] reorderLogFiles(String[] logs){
		boolean[] isLetterArr = new boolean[logs.length];   //scan to see if log contains letter
        int lenLetter = 0;
        for(int i = 0;i<logs.length;i++){
            boolean isLetter = Character.isLetter(logs[i].charAt(logs[i].length()-1));
            if(isLetter) lenLetter++;
            isLetterArr[i] = isLetter;
        }
        String[] ans = new String[logs.length];             
        for(int i = 0,j=0,k=lenLetter;i<logs.length;i++){   //two pointer to move log
            if(isLetterArr[i]){                             //move letter in position j
                ans[j] = logs[i];
                j++;
            }else{                                          //move digits in position k
                ans[k] = logs[i];
                k++;
            }
        }
        Arrays.sort(ans,0,lenLetter,new Comparator<String>(){// sort only the log contains letter
            public int compare(String s1, String s2){
                int i1 = s1.indexOf(' '), i2 = s2.indexOf(' ');
                String id1 = s1.substring(0,i1),id2 = s2.substring(0,i2);
                String word1 = s1.substring(i1), word2 = s2.substring(i2);      
                if(!word1.equals(word2)) return word1.compareTo(word2);//if words not the same, compare word1 word2
                else return id1.compareTo(id2);                      //if word is the same, then compare id1, id2
            }
        });
        return ans;
	}
	*/
}