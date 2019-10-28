class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        Trie trie = new Trie();
        
        for(int i = 0; i < words.length; i++)
            trie.insert(words[i], i);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++)
            trie.search(words[i], i, res);
        
        return res;
    }
}


class TrieNode{
    TrieNode[] child;
    int index;
    List<Integer> palindromeIndices;
    
    TrieNode(){
        child = new TrieNode[26];
        index = -1;
        palindromeIndices = new ArrayList<>();
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    
    public void insert(String str, int index){
        
        TrieNode crawl = root;
        
        for(int i = str.length() - 1; i >= 0; i--){
            int idx = str.charAt(i) - 'a';
            
            if(crawl.child[idx] == null)
                crawl.child[idx] = new TrieNode();
            
            if(isPalindrome(str, 0, i))
                crawl.palindromeIndices.add(index);
            
            crawl = crawl.child[idx];
        }

        crawl.index = index;
        crawl.palindromeIndices.add(index);
    }
    
    public void search(String str, int i, List<List<Integer>> res){
        
        TrieNode crawl = root;
        
        for (int j = 0; j < str.length(); j++){
            if (crawl.index >= 0 && isPalindrome(str, j, str.length() - 1))
                res.add(Arrays.asList(i, crawl.index));
    		
    	    crawl = crawl.child[str.charAt(j) - 'a'];
      	    if (crawl == null)
                return;
        }
    	
        for (int j : crawl.palindromeIndices){
    	    if (i == j)
                continue;
    	    res.add(Arrays.asList(i, j));
        }
    }
    
    private boolean isPalindrome(String str, int start, int end){
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
}