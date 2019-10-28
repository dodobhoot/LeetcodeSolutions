class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else{
                switch(c){
                    case ')':
                        if(st.isEmpty() || st.peek() != '(')
                            return false;
                        break;
                    case '}':
                        if(st.isEmpty() || st.peek() != '{')
                            return false;
                        break;
                    case ']':
                        if(st.isEmpty() || st.peek() != '[')
                            return false;
                        break;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}