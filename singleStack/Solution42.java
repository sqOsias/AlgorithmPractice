package singleStack;

class Solution42 {
    public int trap(int[] height) {
        int sum =0;

        for (int i = 1; i < height.length-1; i++) {
            int r=height[i];
            int l=height[i];

            for (int rr = i+1; rr < height.length; rr++){
                if(height[rr]>r){
                    r=height[rr];
                }

            }
            for (int ll = i-1; ll >=0; ll--){
                if(height[ll]>l){
                    l=height[ll];
                }
            }
            int h=Math.min(r,l)-height[i];
            if (h>0){
                sum+=h;
            }
        }
        return sum;
    }

    public int trap1(int[] height) {
        int sum =0;

        int []maxleft=new int[height.length];
        int []maxright=new int[height.length];
        int size = height.length;

        maxleft[0]=height[0];
        for (int i = 1; i < size; i++) {
            maxleft[i]=Math.max(maxleft[i-1],height[i]);
        }
        maxright[size-1]=height[size-1];
        for (int i = size-2; i >=0 ; i--) {
            maxright[i]=Math.max(maxright[i+1],height[i]);
        }

        for (int i = 0; i < size; i++) {
            int h=Math.min(maxleft[i],maxright[i])-height[i];
            if (h>0){
                sum+=h;
            }
        }

        return sum;
    }


}