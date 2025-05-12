package greedy;

class Solution45 {
    public int jump(int[] nums) {


        int ans=0;
        int curCover=0;
        int nextCover=0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if(curCover==i){
                curCover=nextCover;
                ans++;
                if(curCover>=nums.length-1){
                    break;
                }
            }
        }
        return ans;
    }
}