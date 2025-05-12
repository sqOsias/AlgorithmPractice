package singleStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = findIndex(nums2, nums1[i]);
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                } else {
                    res[i] = -1;
                }
            }

        }

        return res;
    }

    public int findIndex(int[] nums2, int target) {
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }

        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[temp.peek()] >= nums2[i]) {
                temp.add(i);
            } else {
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[temp.peek()])) {
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;


    }

    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        int[] res = solution496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
