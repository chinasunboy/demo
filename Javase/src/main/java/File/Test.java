package File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试");
        //opendir(file);
        //opendir02(file);
        opendir03(file);


    }

    //递归打印目录
    public static void opendir(File file){
        File[] files = file.listFiles();
        for (File s :files){
            if (s.isFile()){
                System.out.println("文件名"+s);
            }
            if (s.isDirectory()){
                System.out.println("目录"+s);
                opendir(s);
            }
        }

    }
//    //搜索文件
//    public static void opendir02(File file) {
//        //使用过滤器接口实现类
//        File[] files = file.listFiles(new util());
//        for (File s : files) {
//            //符合条件的文件打印
//            if (s.isFile()) {
//                System.out.println(s);
//            }
//            //文件夹递归
//            if (s.isDirectory()) {
//                opendir(s);
//            }
//
//        }
//    }
    //搜索文件lambada
    public static void opendir03(File file) {
        //使用过滤器接口实现类
//        File[] files = file.listFiles((File pathname)-> pathname.isDirectory()
//                ||pathname.getName().toLowerCase().endsWith(".java")
//        );
        //第二种接口
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java");
            }
        });
        for (File s : files) {
            //符合条件的文件打印
            if (s.isFile()) {
                System.out.println(s);
            }
            //文件夹递归
            if (s.isDirectory()) {
                opendir(s);
            }

        }
    }
}
