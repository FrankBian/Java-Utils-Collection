package com.gansuer.algorithms.graphs.spanningtree;

import com.gansuer.common.util.FileUtils;
import com.gansuer.common.util.StringUtils;

import java.util.List;

/**
 * Created by Frank on 7/7/16.
 */
public class EWGTestBase {

    protected EdgeWeightGraph graph;
    protected int v;
    protected int e;

    public void init() throws Exception {
        List<String> lines = FileUtils.readFile(this.getClass().getClassLoader().getResource
                ("graph/tinyEWG.txt").getFile());
        v = Integer.parseInt(lines.get(0).trim());
        e = Integer.parseInt(lines.get(1).trim());

        graph = new EdgeWeightGraph(v);
        for (int i = 2; i < lines.size(); i++) {
            String[] strs = StringUtils.replaceAllEmptyCharWith(lines.get(i).trim(), " ").split(" ");
            graph.addEdge(new Edge(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]),
                    Double.parseDouble(strs[2])));

        }
        System.out.println(graph);
        System.out.println("--------------graph end------------");
    }
}
