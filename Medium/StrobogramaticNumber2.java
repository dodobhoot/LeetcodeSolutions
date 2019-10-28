class Solution {
    
    private static final HashMap<Character, Character> hashmap = new HashMap<Character, Character>(){{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};

    public List<String> findStrobogrammatic(int n){
        return recur(n, n);
    }

    private List<String> recur(int n, int maxN){
        
        List<String> numbers = new ArrayList<>();
        
        if(n == 0){
            return numbers;
        }

        if(n == 1){
            for(Character key : hashmap.keySet()){
                if(key == '6' || key == '9')
                    continue;
                numbers.add("" + key);
            }
            return numbers;
        }

        if(n == 2){
            for(Map.Entry<Character, Character> entry : hashmap.entrySet()){
                if(entry.getKey() == '0' && n == maxN)
                    continue;
                numbers.add("" + entry.getKey() + entry.getValue());
            }
            return numbers;
        }

        List<String> middleNumbers = recur(n - 2, maxN);
        
        for(Map.Entry<Character, Character> entry : hashmap.entrySet()){
            if(entry.getKey() == '0' && n == maxN)
                continue;
            for(String num : middleNumbers){
                numbers.add(entry.getKey() + num + entry.getValue());
            }
        }
        return numbers;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<String> numbers = solution.findStrobogrammatic(4);
        for(String number : numbers){
            System.out.println(number);
        }
    }
}