import solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vishal_Mukta on 12/22/2018.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter numbers for first array:");
        Scanner reader = new Scanner(System.in);
        int[] nums1 = getSortedArrayFromInputString(reader.nextLine());
        System.out.println("Enter numbers for second array:");
        int[] nums2 = getSortedArrayFromInputString(reader.nextLine());
        System.out.println("Sorted arrays:");
        print(nums1);
        print(nums2);
        Solution solution = new Solution();
        System.out.println("Median of the 2 sorted arrays: " + solution.findMedianSortedArrays(nums1, nums2));
    }

    private static int[] getSortedArrayFromInputString(String line) {
        int size = 0;
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                size++;
            }
        }
        int[] nums = new int[size];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                nums[j++] = Integer.valueOf(words[i]);
            }
        }
        Arrays.sort(nums);
        return nums;
    }

    private static void print(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(nums[i]);
        }
        System.out.println("]");
    }
}
