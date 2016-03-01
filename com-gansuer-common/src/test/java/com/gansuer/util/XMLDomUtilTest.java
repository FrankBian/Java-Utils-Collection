package com.gansuer.util;

import com.gansuer.common.util.XMLDomUtil;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * Created by Frank on 5/5/15.
 */
public class XMLDomUtilTest {


    String docStr = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n" +
            "<tags>\n" +
            "\t<teacher></teacher>\n" +
            "\t<course/>\n" +
            "\t<class/>\n" +
            "\t<grade>\n" +
            "\t\t<constraint id=\"1131135572754432\" tag=\"1131156504838144\" time=\"7,21,35,49,63\"/>\n" +
            "\t\t<constraint id=\"1131135572754432\" tag=\"1131167975653376\" time=\"10,24,38,52,66\"/>\n" +
            "\t\t<constraint id=\"1131135572754432\" tag=\"1131167940198400\" time=\"9,23,37,51,65\"/>\n" +
            "\t\t<constraint id=\"1131135572754432\" tag=\"1131156576698368\" time=\"8,22,36,50,64\"/>\n" +
            "\t\t<constraint id=\"1131135572754432\" tag=\"1131168003129344\" time=\"11,25,39,53,67\"/>\n" +
            "\t\t<constraint id=\"1131135572754432\" tag=\"1131168025739264\" time=\"12,26,40,54,68,13,27,41,55,69\"/>\n" +
            "\t</grade>\n" +
            "\t<courseGrade></courseGrade>\n" +
            "</tags>";

    @Test
    public void testDeleteChildNodes() throws Exception {

        Document document = XMLDomUtil.convertStringToDocument(docStr);
        if (document != null) {
            XMLDomUtil.deleteChildNodes(document, "grade", "id", "1131135572754432");
            String tmp = XMLDomUtil.convertDocumentToString(document);
            System.out.println(tmp);
        }
    }
}