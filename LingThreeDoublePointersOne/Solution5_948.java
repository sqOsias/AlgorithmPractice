package LingThreeDoublePointersOne;

import java.util.Arrays;

class Solution5_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int score = 0;
        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left];
                score++;
                left++;
            }else if(left!=right && score>0){
                power+=tokens[right];
                score--;
                right--;
            }else{
                break;
            }
        }
        return score;
    }
    public static void main(String[] args){
        Solution5_948 solution5948 = new Solution5_948();
        System.out.println(solution5948.bagOfTokensScore(new int[]{100,200,300,400},200));
    }
}