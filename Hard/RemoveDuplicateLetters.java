class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        
        boolean[] vis = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            freq[idx]--;
            if(vis[idx])
                continue;
            
            while(!st.isEmpty() && s.charAt(i) < st.peek() && freq[st.peek() - 'a'] > 0){
                vis[st.peek() - 'a'] = false;
                st.pop();
            }
            
            st.push(s.charAt(i));
            vis[idx] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        
        return sb.toString();
    }
}