/*
Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. 
You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.








I have one input stack, onto which I push the incoming elements, 
and one output stack, from which I peek/pop. 
I move elements from input stack to output stack when needed, i.e., 
when I need to peek/pop but the output stack is empty. When that happens, I move all elements from input to output stack, thereby reversing the order so it's the correct order for peek/pop.

The loop in peek does the moving from input to output stack. 
Each element only ever gets moved like that once, though, and only after we already spent 
time pushing it, so the overall amortized cost for each operation is O(1).
*
 */

class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        peek();
        return popStack.pop();
    }
    
    public int peek() {
        if (popStack.empty())
            while (!pushStack.empty())
                popStack.push(pushStack.pop());
        return popStack.peek();
    }
    
    public boolean empty() {
        return popStack.empty() && pushStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */