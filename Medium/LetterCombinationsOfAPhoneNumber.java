class Solution {
    
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();
        
        if(digits.length() == 1){
            List<String> ans = new ArrayList<>();
            String value = phone.get(digits);
            for(int j = 0; j < value.length(); j++)
                ans.add("" + value.charAt(j));
            return ans;
        }
        
        List<String> ans = new ArrayList<>();
        List<String> sub = letterCombinations(digits.substring(1));
        
        for(int i = 0; i < sub.size(); i++){
            String value = phone.get("" + digits.charAt(0));
            for(int j = 0; j < value.length(); j++)
                ans.add("" + value.charAt(j) + sub.get(i));
        }
        
        return ans;
    }
}