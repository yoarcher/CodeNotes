/* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. */

public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int area;
        while(a < b){
            if(height[a] < height[b]){
                area = height[a] * (b - a);
                a++;
            } else {
                area = height[b] * (b - a);
                b--;
            }
            if(area > max){
                max = area;
            }
        }
        return max;
    }
}