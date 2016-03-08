package com.gansuer.common.util;


import com.gansuer.common.debug.Debug;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作的工具类
 * <p>
 * Created by Frank on 4/17/15.
 */
public class FileUtils {

    private static final int BUFFER_LENGTH = 4096;
    private static Debug debug = new Debug();

    /**
     * 创建目录
     *
     * @param dir 目录
     */
    public static boolean mkdir(String dir) {
        try {
            String dirTemp = dir;
            File dirPath = new File(dirTemp);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            return true;
        } catch (Exception e) {
            Debug.logError(new String("Create directory Error : " + e.getMessage()));
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 新建文件
     *
     * @param fileName String 包含路径的文件名 如： ~/pdf
     * @param content  String 文件内容
     */
    public static void createNewFile(String fileName, String content) {
        PrintWriter printWriter = null;
        try {
            String fileNameTemp = fileName;
            File filePath = new File(fileNameTemp);
            if (!filePath.exists()) {
                filePath.createNewFile();
            }
            printWriter = new PrintWriter(new FileWriter(filePath));
            String string = content;

            printWriter.println(string);

            printWriter.flush();
        } catch (IOException e) {
            Debug.logError(new String("Create new file error : " + e.getMessage()));
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }


    /**
     * 删除文件
     *
     * @param fileName 包含路径的文件名
     */
    public static void delFile(String fileName) {

        try {
            File delfile = new File(fileName);
            delfile.delete();
        } catch (Exception e) {
            Debug.logError("delete file error : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 删除文件夹
     *
     * @param folderPath 文件夹路径
     */
    public static void delFolder(String folderPath) {

        try {
            delAllFile(folderPath);
            File folder = new File(folderPath);
            //删除空文件夹
            folder.delete();
        } catch (Exception e) {
            Debug.logError("delete folder error : " + e.getMessage());
            e.printStackTrace();
        }

    }


    /**
     * 删除文件夹中的所有文件
     *
     * @param path 文件夹路径
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }

        String[] children = file.list();
        File temp = null;
        for (String child : children) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + child);
            } else {
                temp = new File(path + File.separator + child);
            }

            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(temp.getPath()); // 删除文件夹下所有的文件
                delFolder(temp.getPath());  // 删除空文件夹
            }
        }

    }

    /**
     * 复制单个文件
     *
     * @param srcFile 包含路径的源文件
     * @param dirFile 目标文件目录； 若文件目录不存在则自动创建
     */
    public static void copyFile(String srcFile, String dirFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            mkdir(dirFile);
            fos = new FileOutputStream(new File(dirFile + File.separator + new File(srcFile).getName()));
            int len = 0;
            byte[] buffer = new byte[BUFFER_LENGTH];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            fis.close();
        } catch (Exception e) {
            Debug.logError("Copy file error : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    Debug.logError("File Stream Error : " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    Debug.logError("File Stream Error : " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 复制文件夹
     *
     * @param srcFolder string 源文件夹路径
     * @param dirFolder string 目标文件夹路径
     */
    public static void copyFolder(String srcFolder, String dirFolder) {
        try {
            mkdir(dirFolder);

            File file = new File(srcFolder);
            if (!file.exists()) {
                Debug.logError("Copy folder error : source folder is not existed ! ");
                return;
            }
            String[] children = file.list();
            if (dirFolder.endsWith(File.separator)) {
                dirFolder = dirFolder.substring(0, dirFolder.length() - 1);
            }
            File temp = null;

            FileInputStream fis = null;
            FileOutputStream fos = null;
            byte[] buffer = null;
            for (String child : children) {
                if (srcFolder.endsWith(File.separator)) {
                    temp = new File(srcFolder + child);
                } else {
                    temp = new File(srcFolder + File.separator + child);
                }

                if (temp.isFile()) {
                    fis = new FileInputStream(temp);
                    fos = new FileOutputStream(dirFolder + File.separator + child);
                    buffer = new byte[BUFFER_LENGTH];
                    int len = 0;
                    while ((len = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    fos.close();
                    fis.close();
                }

                if (temp.isDirectory()) {
                    copyFolder(temp.getPath(), dirFolder + File.separator + child);
                }

            }

        } catch (Exception e) {
            Debug.logError("Copy folder error : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 移动文件到指定目录
     *
     * @param oldPath 包含路径的文件名
     * @param newPath 目标文件目录
     */
    public static void moveFile(String oldPath, String newPath) {
        copyFile(oldPath, newPath);
        delFile(oldPath);
    }

    /**
     * 移动文件到指定目录，不会删除文件夹
     *
     * @param oldPath 源文件目录
     * @param newPath 目标文件目录
     */
    public static void moveFiles(String oldPath, String newPath) {
        copyFolder(oldPath, newPath);
        delAllFile(oldPath);
    }

    /**
     * 移动文件到指定目录，会删除文件夹
     *
     * @param oldPath 源文件目录
     * @param newPath 目标文件目录
     */
    public static void moveFolder(String oldPath, String newPath) {
        copyFolder(oldPath, newPath);
        delFolder(oldPath);
    }

    /**
     * 解压zip文件
     *
     * @param srcDir  解压前存放的目录
     * @param destDir 解压后存放的目录
     * @throws Exception
     */
    public static void unZipFile(String srcDir, String destDir) throws Exception {

    }

    /**
     * 压缩文件
     *
     * @param srcDir  压缩前存放的目录
     * @param destDir 压缩后存放的目录
     * @throws Exception
     */
    public static void zipFile(String srcDir, String destDir) throws Exception {

    }

    /**
     * 读取数据
     *
     * @param inputStream
     * @param charsetName
     * @return
     * @throws Exception
     */
    public static String readData(InputStream inputStream, String charsetName) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_LENGTH];
        int len = -1;
        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        byte[] data = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        inputStream.close();
        return new String(data, charsetName);
    }

    /**
     * 一行一行读取文件 ，适合字符读取 ， 若读取中文字符时 会出现乱码
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static List<String> readFile(String path) throws Exception {

        List<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        reader.close();
        return lines;
    }


}
