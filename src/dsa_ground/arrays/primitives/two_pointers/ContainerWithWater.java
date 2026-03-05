package dsa_ground.arrays.primitives.two_pointers;

//Problem: Given an array of positive integers representing the heights of vertical lines on a graph, find the maximum area of water that can be contained between two lines. The area is calculated as the width between the two lines multiplied by the height of the shorter line.
//Example:
//Input: [1, 8, 6, 2, 5, 4, 8, 3, 7]
//Output: 49 (between lines at index 1 and index 8, width = 7, height = 7)

// Technique: Two pointers

import static java.lang.Math.min;

public class ContainerWithWater {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right) {
            int width = right - left;
            int currentArea = width * min(height[left], height[right]);

            if(area < currentArea) {
                area = currentArea;
            }
            if(height[left] < height[right]) left++;
            else right--;
        }

        System.out.println(area);
    }

}
