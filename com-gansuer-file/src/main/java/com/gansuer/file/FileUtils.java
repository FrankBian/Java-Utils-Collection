package com.gansuer.file;

import com.gansuer.debug.Debug;

import java.io.*;
import java.util.List;

/**
 * 文件操作的工具类
 *
 * Created by Frank on 4/17/15.
 */
public class FileUtils {

    private static Debug debug = new Debug();

    /**
     * 创建目录
     * @param dir 目录
     */
    public static boolean mkdir(String dir){
        try{
            String dirTemp = dir ;
            File dirPath = new File(dirTemp);
            if ( !dirPath.exists()){
                dirPath.mkdir();
            }
            return true;
        }catch (Exception e){
            debug.logError(new String("Create directory Error : " + e.getMessage()));
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 新建文件
     * @param fileName String 包含路径的文件名 如： ~/pdf
     * @param content String 文件内容
     */
    public static void createNewFile(String fileName , String content){
        PrintWriter printWriter = null ;
        try {
            String fileNameTemp = fileName ;
            File filePath  = new File(fileNameTemp);
            if ( !filePath.exists()){
                filePath.createNewFile() ;
            }
            printWriter = new PrintWriter(new FileWriter(filePath)) ;
            String string = content ;

            printWriter.println(string);

            printWriter.flush();
        } catch (IOException e) {
            debug.logError(new String("Create new file error : " + e.getMessage()));
            e.printStackTrace();
        } finally {
            if (printWriter != null){
                printWriter.close();
            }
        }
    }

    /**
     * 删除文件加
     * @param folderPath 文件夹路径
     */
    public static void delFolder (String folderPath){

    }

    /**
     * 删除文件
     * @param fileName 包含路径的文件名
     */
    public static void delFile (String fileName) {

    }

    /**
     * 删除文件夹中得所有文件
     * @param path 文件夹路径
     */
    public static void delAllFile (String path){

    }

    /**
     * 复制单个文件
     * @param srcFile 包含路径的源文件
     * @param dirFile 目标文件目录； 若文件目录不存在则自动创建
     */
    public static void copyFile (String srcFile , String dirFile) {

    }

    /**
     * 复制文件夹
     * @param srcFolder string 源文件夹路径
     * @param dirFolder string 目标文件夹路径
     */
    public static void copyFolder (String srcFolder , String dirFolder) {

    }

    /**
     * 移动文件到指定目录
     * @param oldPath 包含路径的文件名
     * @param newPath 目标文件目录
     */
    public static void moveFile (String oldPath ,String newPath){

    }

    /**
     * 移动文件到指定目录，不会删除文件夹
     * @param oldPath 源文件目录
     * @param newPath 目标文件目录
     */
    public static void moveFiles (String oldPath , String newPath){

    }
    /**
     * 移动文件到指定目录，会删除文件夹
     * @param oldPath 源文件目录
     * @param newPath 目标文件目录
     */
    public static void moveFolder (String oldPath ,String newPath){

    }

    /**
     * 解压zip文件
     * @param srcDir 解压前存放的目录
     * @param destDir 解压后存放的目录
     * @throws Exception
     */
    public static void unZipFile (String srcDir ,String destDir) throws Exception {

    }

    /**
     * 压缩文件
     * @param srcDir 压缩前存放的目录
     * @param destDir 压缩后存放的目录
     * @throws Exception
     */
    public static void zipFile(String srcDir ,String destDir) throws Exception {

    }

    /**
     * 读取数据
     * @param inputStream
     * @param charsetName
     * @return
     * @throws Exception
     */
    public static String readData(InputStream inputStream , String charsetName ) throws Exception {
        return null;
    }

    /**
     * 一行一行读取文件 ，适合字符读取 ， 若读取中文字符时 会出现乱码
     * @param path
     * @return
     * @throws Exception
     */
    public static List<String> readFile(String path) throws Exception {
        return null;
    }



}
