package lanqiao;

public class NumberCounter {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 20250412; i++) {
            if (containsRequiredDigits(i)) {
                count++;
            }
        }
        System.out.println("满足条件的数字数量: " + count);
    }

    private static boolean containsRequiredDigits(int number) {
        String numStr = Integer.toString(number);
        int count0 = 0, count2 = 0, count5 = 0;

        for (char c : numStr.toCharArray()) {
            if (c == '0') {
                count0++;
            } else if (c == '2') {
                count2++;
            } else if (c == '5') {
                count5++;
            }
        }

        return count0 >= 1 && count2 >= 2 && count5 >= 1;
    }

}
