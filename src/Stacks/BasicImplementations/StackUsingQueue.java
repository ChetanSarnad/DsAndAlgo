package Stacks.BasicImplementations;

/*

We will discuss two ways of implementing a stack using queue

1. Using only one queue, by performing rotations
2. Using two queues, the costly push operation

Lets discuss each approach in detail

1. Using only one queue, by performing rotations
-------------------------------------------------

Here we use only a single queue, we know queue is FIFO and stack is LIFO
We can mimic the stack operations by performing rotations on the Queue during each push.
Let us see how.

Consider a queue

front [ 1 ]  ---> 1 is at front, calculate size of queue before push.

Push 2 now

front [1, 2] ---> Now perform queue size(pre push calculated size) number of rotation.

Now pre push size is one, deque and enqueue once

front [2] dequeue once
front [2, 1] enqueue once

Now if you see the last enqueued element is at the front and available for deque, same as LIFO of stack

Let us add another element,

front [2, 1]      ---> pre push size is 2
front [2, 1, 3]   ---> push 3
front [1, 3, 2]   ---> rotate once
front [3, 2, 1]   ---> rotate twice

Now 3 is at the front, the last element enqueued, so again LIFO, same as stack

Space complexity : n, for one queue
Time complexity :
Push : Each push, needs n rotations, so O(n)
Pop : O(1)


2. Using two queues, the costly push operation
-----------------------------------------------

Another approach is using two queues.
Bit similar to the above approach, but we will use two queues, say Q1 and Q2.

We always add new element to Q2, empty out element from Q1 to Q2, move everything from Q2 to Q1.
The elements are always popped from Q1, it always pops out the last inserted.
Let us see how.

Q1 :
Q2 :

Add element 1

Q1 :
Q2 : 1

Empty all element from Q1 to Q2 (Currently there is nothing, so maintains same status)

Q1 :
Q2 : 1

Move all elements from Q2 to Q1

Q1 : 1
Q2 :

Lets add one more element, this makes things clearer

Q1 : 1
Q2 : 2

Empty all element from Q1 to Q2

Q1 :
Q2 : 2, 1

Move all elements from Q2 to Q1

Q1 : 2, 1
Q2 :

Pops are always done from Q1, so 2 will be popped, the last inserted, i.e. LIFO like a Stack

Space complexity : Two queues = n + n = 2n = O(n)
Time complexity:
Insert = Insert in Q2 + Empty Q1 + Move all from Q2 to Q1
       = 1 + n + n = 1 + 2n + O(n)
Pop = Remove from Q1 = O(1)
 */

public class StackUsingQueue {
}
