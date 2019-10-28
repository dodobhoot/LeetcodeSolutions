class MinStack {

    private long min;
    private Stack<Long> stack;
    
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x - min);
        if(x < min)
            min = x;
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            long popEle = stack.pop();
            if(popEle < 0)
                min = min - popEle;
        }
    }
    
    public int top() {
        if(stack.peek() > 0)
            return (int)(stack.peek() + min);
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}