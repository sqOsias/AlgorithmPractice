package bishi.bishiShopee;

public class Q1 {
    public boolean canFormSquare(int[] planks) {
        // 判断planks是否可以形成正方形
        int sum = 0;
        for (int i = 0; i < planks.length; i++) {
            sum += planks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int avg = sum / 4;


        int[] sides = new int[4];
        return backtrack(planks, 0, sides, avg);
    }

    private boolean backtrack(int[] planks, int index, int[] sides, int target) {
        if (index == planks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + planks[index] > target) {
                continue;
            }
            sides[i] += planks[index];
            if (backtrack(planks, index + 1, sides, target)) {
                return true;
            }
            sides[i] -= planks[index];
        }

        return false;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] planks = {1,1,2,2,2};
        System.out.println(q1.canFormSquare(planks)); // 输出: true
    }
}
