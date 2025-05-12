package doublePointer;

class Solution27 {

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex;

    }

    public static void main(String[] args) {
        System.out.println(11);

    }
}