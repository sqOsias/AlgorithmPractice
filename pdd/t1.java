package pdd;

import java.util.Scanner;
//T1 推箱子。WASD代表上左下右四个方向，先给一个坐标x, y，
// 然后再给一个字符串，如WAD，说明移动顺序是上左右。
// 最后判断根据要求移动后，能否回到原点0, 0。最后输出YES或NO
public class t1 {
    public static void main(String[] args) {
        Scanner in= new Scanner (System.in);
        int x=in.nextInt();
        int y= in.nextInt();
        if  (in.hasNext()){
            String str=in.next();
            for (char c:str.toCharArray()){
                if (c=='W'){
                    y++;
                }else if (c=='S'){
                    y--;
                }else if (c=='A'){
                    x--;
                }else if (c=='D'){
                    x++;
                }
            }
        }
        System.out.println(x==0&&y==0?"YES":"NO");


        in.close();
    }
}
