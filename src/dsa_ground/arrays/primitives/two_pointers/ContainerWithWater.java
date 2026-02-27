package dsa_ground.arrays.primitives.two_pointers;

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
