package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import com.gansuer.common.util.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 7/1/16.
 */
public class AdjacencyListDigraphTest {

    private Digraph digraph;
    private final String defaultFileName = "graph/tinyDG.txt";
    private List<String> lines;
    protected int vertices = 0, edge = 0;

    @Before
    public void setUp() throws Exception {
        String path = getClass().getClassLoader()
                .getResource(defaultFileName).getFile();
        lines = FileUtils.readFile(path);
        vertices = Integer.parseInt(lines.get(0));
        edge = Integer.parseInt(lines.get(1));

        digraph = new AdjacencyListDigraph(vertices);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = StringUtils.replaceAllEmptyCharWith(lines.get(i).trim(), " ")
                    .split(" ");
            digraph.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        }
        System.out.println(digraph.toString());
        System.out.println("------------- graph end -------------");
    }

    @Test
    public void addEdge() throws Exception {
        digraph.adj(0).forEach(item -> Assert.assertTrue(item == 1 || item == 5));
        digraph.adj(2).forEach(item -> Assert.assertTrue(item == 0 || item == 3));
        digraph.adj(7).forEach(item -> Assert.assertTrue(item == 6 || item == 9));
        digraph.adj(9).forEach(item -> Assert.assertTrue(item == 10 || item == 11));
        digraph.adj(11).forEach(item -> Assert.assertTrue(item == 4 || item == 12));
        digraph.adj(12).forEach(item -> Assert.assertTrue(item == 9));
    }

    @Test
    public void adj() throws Exception {
        addEdge();
    }

    @Test
    public void reverse() throws Exception {
        Digraph res = digraph.reverse();
        Assert.assertNotNull(res);
        System.out.println(res.toString());
    }

}