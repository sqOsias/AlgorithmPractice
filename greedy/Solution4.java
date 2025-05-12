package greedy;

public class Solution4 {
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        int result=0;
        for(int i=0;i<=result;i++){
            result = Math.max(result,i+nums[i]);
            if (result>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}