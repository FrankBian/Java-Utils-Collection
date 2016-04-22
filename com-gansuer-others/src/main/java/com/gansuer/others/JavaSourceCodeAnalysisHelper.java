package com.gansuer.others;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * return the source code hierarchy architecture
 * <p>
 * input : the java source code package path in disk
 * <p>
 * Created by Frank on 6/21/15.
 */
public class JavaSourceCodeAnalysisHelper {

    // the files in the package , true if it's not a directory
    private List<Map<File, Boolean>> files = null;

    /**
     * String : class/interface name extended/implemented by others
     * Map<String, List<String>> : String : extends/implements ---- the flag
     * List<String> : the super class's subclasses or implements' name
     */
    private Map<String, Map<String, Set<String>>> result = null;

    private Map<String, String> exceptions = null;
    // className - classType
    private Map<String, String> classTypeMap = null;

    private static final String KEY1 = "extends";
    private static final String KEY2 = "implements";

    private static final String ABSTRACT = "abstract";
    private static final String CLASS = "class";
    private static final String INTERFACE = "interface";

    /**
     * main method
     *
     * @param packageName
     */
    public void run(String packageName) {

        File target = new File(packageName);

        if (!target.exists()) {
            System.out.println("File Not-Exist !");
            return;
        }
        files = new ArrayList<>();
        File[] subFiles = target.listFiles();
        if (subFiles == null) {
            System.out.println("File is NOT directory");
            return;
        }
        result = new TreeMap<>();
        classTypeMap = new HashMap<>();
        exceptions = new TreeMap<>();
        for (File item : subFiles) {
            Map<File, Boolean> map = new HashMap<>();
            map.put(item, item.isDirectory());
            files.add(map);
            try {
                handleJavaSource(item, result, classTypeMap);
            } catch (Exception e) {
                exceptions.put(item.getName(), e.getMessage());
            }
        }

    }

    /**
     * handle the indicated java file
     *
     * @param item
     * @param result
     * @param classTypeMap
     */
    protected void handleJavaSource(File item, Map<String, Map<String, Set<String>>> result, Map<String, String> classTypeMap) throws Exception {

        if (item.isDirectory()) {
            throw new Exception(item.getName() + " is directory !");
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(item));
        String line = bufferedReader.readLine();
        String classNameLine = "";
        String className = "";
        String extend = "";
        String imple = "";
        while (line != null) {
            // blank-line/ comment-line / package-declare / class-import-line
            if (StringUtils.isNotEmpty(line.trim()) && !line.contains("*") && !line.contains("/")
                    && !line.contains("package") && !line.contains("import")) {
                classNameLine += line + " ";
                if (line.contains("{")) {
                    break;
                }
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        if (StringUtils.isEmpty(classNameLine)) {
            throw new Exception("Can't get classNameLine (classNameLine is EMPTY)");
        }
        classNameLine = classNameLine.trim();
        int index_block = classNameLine.indexOf("{");
        int index_extends = classNameLine.lastIndexOf("extends");
        int index_implements = classNameLine.indexOf("implements");
        int index_class = classNameLine.indexOf("class");
        int index_interface = classNameLine.indexOf("interface");

        if (index_extends > 0) {
            className = classNameLine.substring(index_class > index_interface ? index_class + 5
                    : index_interface + 9, index_extends).trim();
        } else if (index_implements > 0) {
            className = classNameLine.substring(index_class > index_interface ? index_class + 5
                    : index_interface + 9, index_implements).trim();
        } else if (index_block > 0) {
            className = classNameLine.substring(index_class > index_interface ? index_class + 5
                    : index_interface + 9, index_block).trim();
        }

        if (StringUtils.isEmpty(className)) {
            throw new Exception("Can't get className (className is EMPTY)");
        }

        classTypeMap.put(className, index_class > index_interface ?
                (classNameLine.contains(ABSTRACT) ? ABSTRACT : CLASS) : INTERFACE);

        extend = index_extends > 0 ?
                classNameLine.substring(index_extends + 7, index_implements > 0 ?
                        index_implements : index_block).trim() : null;
        imple = index_implements > 0 ?
                classNameLine.substring(index_implements + 10, index_block).trim() : null;

        Map<String, Set<String>> values = null;
        if (StringUtils.isNotEmpty(extend)) {
            if (result.containsKey(extend)) {
                values = result.get(extend);
            } else {
                values = new HashMap<>();
                result.put(extend, values);
            }
            if (values.containsKey(KEY1)) {
                values.get(KEY1).add(className);
            } else {
                Set<String> tmp = new HashSet<>();
                tmp.add(className);
                values.put(KEY1, tmp);
            }
        }

        if (StringUtils.isNotEmpty(imple)) {
            imple = imple.replaceAll("<K,V>", "<KV>");
            String[] imples = imple.split(",");
            for (String string : imples) {
                String key = string.trim();
                if (key.contains("<KV>")) {
                    key = key.replaceAll("<KV>", "<K,V>");
                }
                if (key.contains("Serializable")) {
                    key = "Serializable";
                }
                if (key.contains("Cloneable")) {
                    key = "Cloneable";
                }

                if (result.containsKey(key)) {
                    values = result.get(key);
                } else {
                    values = new HashMap<>();
                    result.put(key, values);
                }
                if (values.containsKey(KEY2)) {
                    values.get(KEY2).add(className);
                } else {
                    Set<String> tmp = new HashSet<>();
                    tmp.add(className);
                    values.put(KEY2, tmp);
                }
            }
        }

    }

    public List<Map<File, Boolean>> getFiles() {
        return files;
    }

    public Map<String, Map<String, Set<String>>> getResult() {
        return result;
    }

    public Map<String, String> getExceptions() {
        return exceptions;
    }

    public Map<String, String> getClassTypeMap() {
        return classTypeMap;
    }
}
