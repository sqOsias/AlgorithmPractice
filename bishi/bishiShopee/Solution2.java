package bishi.bishiShopee;

public class Solution2 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 
     * @param items int整型 二维数组 
     * @return int整型二维数组
     */
    public int[][] rerankItems(int[][] items) {

        int[][]res=new int[items.length][];
        int fastIndex=0, slowIndex=0;
        while(fastIndex<items.length){
            if(items[fastIndex][1]>0){
                res[slowIndex]=items[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        fastIndex=0;
        while(fastIndex<res.length){
            if(items[fastIndex][1]==0){
                res[slowIndex++]=items[fastIndex];
            }
            fastIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s=new Solution2();
        int[][]items={{2,100},{5,0},{3,200},{4,0}};
        int[][]res=s.rerankItems(items);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }


        int[][]items1={{5,0},{3,200}};
        res=s.rerankItems(items1);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
