class MyStack {
    
    Queue<Integer> queue1, queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queue2.size() == 0)
            queue1.add(x);
        else
            queue2.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top = 0;
        
        if(queue1.size() > 0){
            while(queue1.size() > 1)
                queue2.add(queue1.remove());
            top = queue1.remove();
        }
        else if(queue2.size() > 0){
            while(queue2.size() > 1)
                queue1.add(queue2.remove());
            top = queue2.remove();
        }
        
        return top;
    }
    
    /** Get the top element. */
    public int top() {
        int top = 0;
        
        if(queue1.size() > 0){
            while(queue1.size() > 1)
                queue2.add(queue1.remove());
            top = queue1.remove();
            queue2.add(top);
        }
        else if(queue2.size() > 0){
            while(queue2.size() > 1)
                queue1.add(queue2.remove());
            top = queue2.remove();
            queue1.add(top);
        }
        
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size() == 0 && queue2.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */