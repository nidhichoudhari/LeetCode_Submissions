import java.util.Stack;

class Solution {
    private static int[] nextSmaller(int[] heights, int n) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int[] answer = new int[n];
        for(int i=n-1;i>=0;i--) {
            int curr = heights[i];
            while(stk.peek()!= -1 && heights[stk.peek()] >= curr) {
                stk.pop();
            }
            answer[i] = stk.peek();
            stk.push(i);
        }
        return answer;
    }

    private static int[] prevSmaller(int[] heights, int n) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int[] answer = new int[n];
        for(int i=0;i<n;i++) {
            int curr = heights[i];
            while(stk.peek()!= -1 && heights[stk.peek()] >= curr) {
                stk.pop();
            }
            answer[i] = stk.peek();
            stk.push(i);
        }
        return answer;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = nextSmaller(heights,n);

        int[] prev = prevSmaller(heights,n);

        int area = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int length = heights[i];
            if(next[i] == -1) {
                next[i] = n;
            }
            int breadth = next[i] - prev[i] - 1;

            int newarea = length*breadth;
            area = Math.max(area,newarea);
        }
        return area;
    }
}