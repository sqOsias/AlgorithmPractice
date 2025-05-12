package leetCode热题100;

class Solution4 {
    public void moveZeroes(int[] nums) {
        int slowIndex=0;
        int fastIndex=0;
        while (fastIndex<nums.length){
            if(nums[fastIndex]!=0){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        while (slowIndex<nums.length){
            nums[slowIndex]=0;
            slowIndex++;
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {0, 1, 0, 3, 12};
        solution4.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}