package doublePointer;

public class Q1 {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]==val){
                for(int j = i;j<size;j++){
                    nums[j]=nums[j+1];
                }
            }
        }
        return size;
    }
}
