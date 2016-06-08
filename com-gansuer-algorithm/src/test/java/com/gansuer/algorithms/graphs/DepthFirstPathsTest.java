package com.gansuer.algorithms.graphs;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 6/8/16.
 */
public class DepthFirstPathsTest {

    private DepthFirstPaths depthFirstPaths;
    private final String fileName = "graph/tinyG.txt";
    private List<String> lines;
    private int v = 0, e = 0;
    private int root = 5;
    private Graph graph;
    @Before
    public void setUp() throws Exception {
        String path = getClass().getClassLoader().getResource(fileName).getFile();
        lines = FileUtils.readFile(path);
        v = Integer.parseInt(lines.get(0));
        e = Integer.parseInt(lines.get(1));

        graph = new AdjacencyMatrixGraph(v);
        for (int i = 2; i < lines.size(); i++) {
            String[] token = lines.get(i).split(" ");
            graph.addEdge(Integer.parseInt(token[0]),Integer.parseInt(token[1]));
        }

        depthFirstPaths = new DepthFirstPaths(graph,root);
    }

    @Test
    public void hasPathTo() throws Exception {
        Assert.assertEquals(true,depthFirstPaths.hasPathTo(1));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(11));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(9));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(8));
        Assert.assertEquals(false,depthFirstPaths.hasPathTo(7));
        Assert.assertEquals(true,depthFirstPaths.hasPathTo(0));
        Assert.assertEquals(true,depthFirstPaths.hasPathTo(6));
    }

    @Test
    public void pathTo() throws Exception {
        print(1);
        print(6);
        print(2);
        print(3);
        print(4);
        print(5);
    }

    private void print(int target){
        depthFirstPaths.pathTo(target).forEach(item -> System.out.print(item+" "));
        System.out.println();
    }
    @Test
    public void TestToString() throws Exception {
        System.out.println(graph.toString());
    }
}