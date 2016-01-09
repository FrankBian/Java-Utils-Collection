package com.gansuer.xml;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML 文件的增删改查操作
 * <p>
 * Created by Frank on 2014/11/8.
 */
public class XMLDomUtil {
    /**
     * dom转化成string
     *
     * @param dom xml文档
     * @return
     */
    public static String convertDocumentToString(Document dom) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(dom), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * domStr转化为dorm
     *
     * @param domStr 待转化为xml文档的字符串
     * @return
     */
    public static Document convertStringToDocument(String domStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(domStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到节点属性值，适用于无子节点的节点
     *
     * @param dom      xml文档
     * @param nodeName 节点名称
     * @return map
     */
    public static Map<String, String> getNodeAttributes(Document dom, String nodeName) {
        NodeList nl = dom.getElementsByTagName(nodeName);
        if (nl != null && nl.getLength() > 0) {
            NamedNodeMap nnm = nl.item(0).getAttributes();
            //除去噪音
            if (nnm != null) {
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 0; i < nnm.getLength(); i++) {
                    Node attribute = nnm.item(i);
                    map.put(attribute.getNodeName(), attribute.getNodeValue());
                }
                return map;
            }
        }
        return null;
    }

    /**
     * 设置节点属性值，适用于无子节点的节点
     *
     * @param dom      xml文档
     * @param nodeName 节点名称
     * @param map      节点属性值
     */
    public static void setNodeAttributes(Document dom, String nodeName, Map<String, String> map) {
        NodeList nl = dom.getElementsByTagName(nodeName);
        if (nl != null && nl.getLength() > 0) {
            NamedNodeMap nnm = nl.item(0).getAttributes();
            //除去噪音
            if (nnm != null) {
                for (int i = 0; i < nnm.getLength(); i++) {
                    Node attribute = nnm.item(i);
                    if (map.containsKey(attribute.getNodeName())) {
                        attribute.setNodeValue(map.get(attribute.getNodeName()));
                    }
                }
            }
        }
    }

    /**
     * 添加节点
     *
     * @param doc
     * @param nodeName
     * @param map
     */
    public static void createAttribute(Document doc, String nodeName, Map<String, String> map) {
        Node node = doc.getElementsByTagName(nodeName).item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                element.setAttribute(entry.getKey(), entry.getValue());
            }
            //TransformerFactory factory = TransformerFactory.newInstance();
            //Transformer former = factory.newTransformer();
            //former.transform(new DOMSource(doc), new StreamResult(new File("src/shuiguo.xml")));
        }
    }

    /**
     * 得到所有子节点的属性值，使用于有子节点的节点
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     * @return
     */
    public static List<Map<String, String>> getChildNodesAttributes(Document dom, String parentNodeName) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            Node parent = nl.item(0);
            //得到父节点下所有的子节点
            NodeList childNodeList = parent.getChildNodes();
            if (childNodeList != null && childNodeList.getLength() > 0) {
                List<Map<String, String>> list = new ArrayList<Map<String, String>>();
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    Map<String, String> map = new HashMap<String, String>();
                    Node childNode = childNodeList.item(i);
                    NamedNodeMap nnm = childNode.getAttributes();
                    //除去噪音
                    if (nnm != null) {
                        for (int j = 0; j < nnm.getLength(); j++) {
                            Node attribute = nnm.item(j);
                            map.put(attribute.getNodeName(), attribute.getNodeValue());
                        }
                        list.add(map);
                    }
                }
                return list;
            }
        }
        return new ArrayList<Map<String, String>>();
    }

    /**
     * 得到子节点
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     * @param nodePKName     子节点关键属性名
     * @param nodePKValue    子节点关键属性值
     */
    public static Map<String, String> getChildNodeAttributes(Document dom, String parentNodeName, String nodePKName, String nodePKValue) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            //父节点
            Node parentNode = nl.item(0);
            NodeList childNodeList = parentNode.getChildNodes();
            if (childNodeList != null && childNodeList.getLength() > 0) {
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    Node childNode = childNodeList.item(i);
                    //找到待删除的子节点
                    NamedNodeMap tempNNM = childNode.getAttributes();
                    //除去噪音
                    if (tempNNM != null) {
                        //得到子节点主键值
                        String tempId = tempNNM.getNamedItem(nodePKName).getNodeValue();
                        if (tempId.equals(nodePKValue)) {
                            Map<String, String> map = new HashMap<String, String>();
                            for (int j = 0; j < tempNNM.getLength(); j++) {
                                Node attribute = tempNNM.item(j);
                                map.put(attribute.getNodeName(), attribute.getNodeValue());
                            }
                            return map;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 设置节点属性值，适用于子节点
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     * @param nodePKName     子节点主键名称
     * @param map            子节点属性值
     */
    public static void setChildNodeAttributes(Document dom, String parentNodeName, String nodePKName, Map<String, String> map) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            //找到父节点
            Node parentNode = nl.item(0);
            NodeList childNodeList = parentNode.getChildNodes();
            if (childNodeList != null && childNodeList.getLength() > 0) {
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    Node childNode = childNodeList.item(i);
                    //找到待修改的子节点
                    NamedNodeMap tempNNM = childNode.getAttributes();
                    //除去噪音
                    if (tempNNM != null) {
                        //得到子节点主键值
                        String tempId = tempNNM.getNamedItem(nodePKName).getNodeValue();
                        if (map.get(nodePKName).equals(tempId)) {
                            for (int j = 0; j < tempNNM.getLength(); j++) {
                                Node attribute = tempNNM.item(j);
                                if (map.containsKey(attribute.getNodeName())) {
                                    attribute.setNodeValue(map.get(attribute.getNodeName()));
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 加入新的子节点到父节点
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     * @param nodeName       子节点名称
     * @param map            子节点属性值
     */
    public static void appendChildNode(Document dom, String parentNodeName, String nodeName, Map<String, String> map) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            //父节点
            Node parentNode = nl.item(0);
            Element insertElement = dom.createElement(nodeName);
            parentNode.appendChild(insertElement);
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                insertElement.setAttribute(stringStringEntry.getKey(), stringStringEntry.getValue());
            }
        }
    }

    /**
     * 批量加入新的子节点到父节点
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     * @param nodeName       子节点名称
     * @param mapList        多个子节点属性值
     */
    public static void appendChildNodes(Document dom, String parentNodeName, String nodeName, List<Map<String, String>> mapList) {
        if (mapList != null) {
            NodeList nl = dom.getElementsByTagName(parentNodeName);
            if (nl != null && nl.getLength() > 0) {
                //父节点
                Node parentNode = nl.item(0);
                for (int i = 0; i < mapList.size(); i++) {
                    //逐条插入
                    Element insertElement = dom.createElement(nodeName);
                    parentNode.appendChild(insertElement);
                    Map<String, String> map = mapList.get(i);
                    for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                        insertElement.setAttribute(stringStringEntry.getKey(), stringStringEntry.getValue());
                    }
                }
            }
        }
    }

    /**
     * 删除子节点
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     * @param nodePKName     子节点关键属性名
     * @param nodePKValue    子节点关键属性值
     */
    public static void deleteChildNode(Document dom, String parentNodeName, String nodePKName, String nodePKValue) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            //父节点
            Node parentNode = nl.item(0);
            NodeList childNodeList = parentNode.getChildNodes();
            if (childNodeList != null && childNodeList.getLength() > 0) {
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    Node childNode = childNodeList.item(i);
                    //找到待删除的子节点
                    NamedNodeMap tempNNM = childNode.getAttributes();
                    //除去噪音
                    if (tempNNM != null) {
                        //得到子节点主键值
                        String tempId = tempNNM.getNamedItem(nodePKName).getNodeValue();
                        if (tempId.equals(nodePKValue)) {
                            parentNode.removeChild(childNode);
                            break;
                        }
                    }
                }
            }
        }
    }

//    /**
//     * 删除所有符合条件的子节点  TODO: 这个删除方法有问题,但是测试用例里面 两个方法表现都正常
//     * @param dom
//     * @param parentNodeName
//     * @param nodePKName
//     * @param nodePKValue
//     */
//    public static void deleteChildNodes(Document dom, String parentNodeName, String nodePKName, String nodePKValue) {
//        NodeList nl = dom.getElementsByTagName(parentNodeName);
//        if (nl != null && nl.getLength() > 0) {
//            //父节点
//            Node parentNode = nl.item(0);
//            NodeList childNodeList = parentNode.getChildNodes();
//            if (childNodeList != null && childNodeList.getLength() > 0) {
//                for (int i = 0; i < childNodeList.getLength(); i++) {
//                    Node childNode = childNodeList.item(i);
//                    //找到待删除的子节点
//                    NamedNodeMap tempNNM = childNode.getAttributes();
//                    //除去噪音
//                    if (tempNNM != null) {
//                        //得到子节点主键值
//                        String tempId = tempNNM.getNamedItem(nodePKName).getNodeValue();
//                        if (tempId.equals(nodePKValue)) {
//                            parentNode.removeChild(childNode);
//                        }
//                    }
//                }
//            }
//        }
//    }

    /**
     * 删除所有符合条件的子节点
     *
     * @param dom
     * @param parentNodeName
     * @param nodePKName
     * @param nodePKValue
     */
    public static void deleteChildNodes(Document dom, String parentNodeName, String nodePKName, String nodePKValue) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            //父节点
            Node parentNode = nl.item(0);
            NodeList childNodeList = parentNode.getChildNodes();
            if (childNodeList != null && childNodeList.getLength() > 0) {
                List<Node> tmp = new ArrayList<>();
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    Node childNode = childNodeList.item(i);
                    //找到待删除的子节点
                    NamedNodeMap tempNNM = childNode.getAttributes();
                    //除去噪音
                    if (tempNNM != null) {
                        //得到子节点主键值
                        String tempId = tempNNM.getNamedItem(nodePKName).getNodeValue();
                        if (tempId.equals(nodePKValue)) {
//                            parentNode.removeChild(childNode); //这样有问题
                            tmp.add(childNode);
                        }
                    }
                }
                for (Node item : tmp) {
                    parentNode.removeChild(item);
                }
            }
        }
    }

    /**
     * 删除所有子节点, 父节点存在返回true，不存在返回false
     *
     * @param dom            xml文档
     * @param parentNodeName 父节点名称
     */
    public static boolean deleteChildNodes(Document dom, String parentNodeName) {
        NodeList nl = dom.getElementsByTagName(parentNodeName);
        if (nl != null && nl.getLength() > 0) {
            //父节点
            Node parentNode = nl.item(0);
            while (parentNode.getChildNodes() != null && parentNode.getChildNodes().getLength() > 0) {
                parentNode.removeChild(parentNode.getFirstChild());
            }

            return true;
        }

        return false;
    }
}
