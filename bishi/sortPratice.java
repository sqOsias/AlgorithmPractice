package bishi;

import java.util.*;

public class sortPratice {
    public static void main(String[] args) {

        int[]array={10,2,3,4,5,6,7,8,9};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(10);
        objects.add(2);
        objects.add(3);

        Collections.sort(objects,Collections.reverseOrder());
        System.out.println(objects);

        Integer[]array1={10,2,3,4,5,6,7,8,9};
        Arrays.sort(array1,Collections.reverseOrder());
        System.out.println(Arrays.toString(array1));

        Integer []array2={10,2,3,4,5,6,7,8,9};
        Arrays.sort(array2, (o1, o2) -> o2-o1);
        System.out.println(Arrays.toString(array2));


        char[] data={'a','b','c','d','e'};
        String s = String.valueOf(data);
        System.out.println(s);
        int[]data1={1,2,3,4,5};
        String s1 = Arrays.toString(data1);
        System.out.println(s1.charAt(0));

        int data3=123;
        String s2 = String.valueOf(data3);
        char[] charArray = s2.toCharArray();

        System.out.println(charArray);

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        queue.offer(1);
        queue.poll();
        map.put(1,1);
        map.remove(1);
    }
}
