package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedQueue;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;

//Dan Walker
//CS3308
//Mission 03
public class StackScan {

    /**
     * Tests whether the given stack contains the provided element.
     * Implementation should use a queue to scan the stack and reconstruct it
     * when done.
     *
     * @param <E> Type of elements stored in the stack
     * @param stack Stack to be scanned.
     * @param element Element to search the stack for.
     * @return True if the given stack is not null and contains the given
     * element. Returns false if both the stack and element are not null and the
     * stack does not contain the element, if either the stack or element is
     * null, or if the stack is emtpy.
     */
    public static <E> boolean scanStack(final Stack<E> stack, E element) {
        if (stack == null || element == null || stack.isEmpty()) {
            return false;
        }
        else {
            LinkedQueue<E> swap = new LinkedQueue<>();
            boolean answer = false;

            //The first two elements do not follow the rest of the loop logic.
            //stores the first two, and only offers ONE element to the back 12 = 21
            swap.offer(stack.pop());
            swap.offer(stack.pop());
            swap.offer(swap.poll());

            //loop takes one off the stack and then moves elements in the queue to the back
            // 213 = 321. 3214 = 4321 ect.
            while (!(stack.isEmpty())) {

                //will change with each iteration, ensuring for loop works
                int swapSize = swap.size();
                //takes one element from the stack to the queue
                swap.offer(stack.pop());

                //213 -> 132 -> 321.
                for (int i = swapSize; i > 0; i--) {
                    swap.offer(swap.poll());
                }
            }
            //actual logic for the method. as the elements are put back into the stack
            //  check each element to see if it is equal to target element
            while (!(swap.isEmpty())) {
                if (swap.peek() == element) answer = true;
                stack.push(swap.poll());
            }
            return answer;

        }

    }
}
