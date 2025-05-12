package MyThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyThread2 extends Thread{
    String url;
    String fileName;
    public MyThread2(String url,String fileName){
        this.url=url;
        this.fileName=fileName;
    }
    @Override
    public void run() {
        utility.download(url,fileName);
        System.out.println(fileName+"success");
    }

    public static void main(String[] args) {
       MyThread2 myThread21= new MyThread2("https://tse3-mm.cn.bing.net/th/id/OIP-C.lv2PFfFnZdMzsPcMwyo3yAHaEJ?w=316&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7","1.png");
        MyThread2 myThread22= new MyThread2("https://tse3-mm.cn.bing.net/th/id/OIP-C.lv2PFfFnZdMzsPcMwyo3yAHaEJ?w=316&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7","2.png");
        MyThread2 myThread23= new MyThread2("https://tse3-mm.cn.bing.net/th/id/OIP-C.lv2PFfFnZdMzsPcMwyo3yAHaEJ?w=316&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7","3.png");
        myThread21.start();
        myThread22.start();
        myThread23.start();
    }


}

 class utility{
    //根据url下单文件
    public static void download(String url,String fileName){
        //下载文件
        try {
            // 创建URL对象
            URL downloadUrl = new URL(url);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) downloadUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // 获取输入流
            InputStream inputStream = connection.getInputStream();

            // 创建文件输出流
            File file = new File(fileName);
            FileOutputStream outputStream = new FileOutputStream(file);

            // 创建缓冲区
            byte[] buffer = new byte[4096];
            int length;

            // 读取数据并写入文件
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            // 关闭流
            outputStream.close();
            inputStream.close();
            connection.disconnect();

            System.out.println("文件下载完成: " + fileName);

        } catch (IOException e) {
            System.err.println("下载文件时发生错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
