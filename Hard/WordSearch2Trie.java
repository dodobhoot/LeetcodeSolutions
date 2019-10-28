class Solution {
    
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();
        
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        Set<String> uniqueWords = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                findUtil(i, j, "", board, trie, uniqueWords);
            }
        }
        
        res.addAll(uniqueWords);
        return res;
    }
    
    public void findUtil(int r, int c, String prefix, char[][] board, Trie trie, Set<String> uniqueWords){
        
        if(trie.search(prefix))
            uniqueWords.add(prefix);
        
        if(r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] == '#' || !trie.startsWith(prefix)) {
            return;
        }
        
        char ch = board[r][c];
        String newPrefix = prefix + ch;
        board[r][c] = '#';
        
        for(int dir = 0; dir < dx.length; dir++)
            findUtil(r + dx[dir], c + dy[dir], newPrefix, board, trie, uniqueWords);
        
        board[r][c] = ch;
    }    
}

class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        isEnd = false;
        children = new TrieNode[26];
    }
}

class Trie{
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word){
        int len = word.length();
        TrieNode crawl = root;
        for(int i = 0; i < len; i++){
            int idx = word.charAt(i) - 'a';
            if(crawl.children[idx] == null){
                crawl.children[idx] = new TrieNode();
            }
            crawl = crawl.children[idx];
        }
        crawl.isEnd = true;
    }
    
    public boolean search(String word){
        int len = word.length();
        TrieNode crawl = root;
        for(int i = 0; i < len; i++){
            int idx = word.charAt(i) - 'a';
            if(crawl.children[idx] == null){
                return false;
            }
            crawl = crawl.children[idx];
        }
        if(crawl != null && crawl.isEnd)
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix){
        int len = prefix.length();
        TrieNode crawl = root;
        for(int i = 0; i < len; i++){
            int idx = prefix.charAt(i) - 'a';
            if(crawl.children[idx] == null){
                return false;
            }
            crawl = crawl.children[idx];
        }
        if(crawl != null)
            return true;
        return false;
    }
}
