package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2021-09-2021/9/6 22:22
 */
public class Trap {
    public int trap(int[]height){
        if (height == null || height.length == 0)
            return 0;
        int result = 0;
        Stack<Integer>stack = new Stack<>();
        for (int i = 0;i < height.length;i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curIndex = stack.pop();
                while (!stack.isEmpty() && height[curIndex] == height[stack.peek()]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    int stackTop = stack.peek();
                    result += (Math.min(height[stackTop],height[i]) - height[curIndex]) * (i -stackTop-1);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
