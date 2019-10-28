class Solution {
    
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();
        
        Set<String> uniqueWords = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                findUtil(i, j, new StringBuilder(""), board, words, uniqueWords);
            }
        }
        
        res.addAll(uniqueWords);
        return res;
    }
    
    public void findUtil(int r, int c, StringBuilder prefix, char[][] board, String[] words, Set<String> uniqueWords){
        
        if(search(prefix.toString(), words))
            uniqueWords.add(prefix.toString());
        
        if(r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] == '#' || !startsWith(prefix.toString(), words)) {
            return;
        }
        
        char ch = board[r][c];
        prefix.append(ch);
        board[r][c] = '#';
        
        for(int dir = 0; dir < dx.length; dir++)
            findUtil(r + dx[dir], c + dy[dir], prefix, board, words, uniqueWords);
        
        board[r][c] = ch;
        prefix.deleteCharAt(prefix.length() - 1);
    }
    
    public boolean search(String prefix, String[] words){
        for(String word : words){
            if(word.equals(prefix))
                return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix, String[] words){
        for(String word : words){
            if(word.startsWith(prefix))
                return true;
        }
        return false;
    }
}