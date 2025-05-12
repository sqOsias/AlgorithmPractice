package bishi.huawei;

import java.util.*;

public class solution1 {
    public static void main(String[] args) {
        int k,n;
        long[] car = new long[2];

        Scanner scanner = new Scanner(System.in);
        k=scanner.nextInt();
        n=scanner.nextInt();
        long[][] arr=new long[n][2];
        Map<Integer,Long>distance=new HashMap<>();
        List<List<Long>>res=new ArrayList<>();

        car[0]=scanner.nextLong();
        car[1]=scanner.nextLong();
        for (int i = 0; i < n; i++){
            arr[i][0]=scanner.nextLong();
            arr[i][1]=scanner.nextLong();
//            distance[i]=arr[i][0]-car[0]+arr[i][1]-car[1];
            distance.put(i,arr[i][0]-car[0]+arr[i][1]-car[1]);
        }
        //如何拿到map的key值



        distance.entrySet().stream().sorted(Map.Entry.comparingByValue());
        Set<Map.Entry<Integer, Long>> entries = distance.entrySet();
//        for (int i = 0; i < k; i++){
//            res.add(Arrays.asList(entries[i].getKey(), arr[Math.toIntExact(distance.get(i))][0]-car[0],arr[Math.toIntExact(distance.get(i))][1]-car, arr[Math.toIntExact(distance.get(i))][0],arr[Math.toIntExact(distance.get(i))][1]));
//        }
    }
}
