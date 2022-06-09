/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

 */

/**
Core Idea:

1.Minimum value is always followed by the second minimum value 
(duplicate value of the second minimum value, to ensure that when pop function removes the 2nd min, 
it does not disrupt the stack order).

2.And while popping you pop min and 2nd min so that, you get the correct min value for the 
remaining stack and the remaining stack top also points to the right place.

 */



class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
int min = Integer.MAX_VALUE; (so, it is +2,147,483,647)
        if(x <= min){          
                   stack.push(min);
                   min=x;
                            }
          stack.push(x);
let's assume we have stack.push(x)

            x: (1, -3, 5, -2, -5)
first it compares "1" with min (MAX_VALUE) if it is the case then stack.push(min) and min = 1;
so in stack (MAX_VALUE)
when we leave the if case, stack(x);
so in stack(MAX_VALUE, 1)
and other cases go ...

at the end:
stack(MAX_VALUE, 1, -3, 5, -2, -3, -5)

so, there are 7 values in stack space.

When we use two stacks:

        stack<int>s1,s2;
        s1.push(x);
        if (s2.empty() || x<=s2.top()) 
          {
               s2.push(x)
          }
if use the examples in one stacks:

             for x: (1, -3, 5, -2, -5)

 then:

             s1 = (1,-3,5,-2,-5)
             s2 = (1,-3,-5)
In one stack 7 spaces have been used for 5 values
In two stack 8 spaces.
Almost close, right. It may varies, depending on cases
 */