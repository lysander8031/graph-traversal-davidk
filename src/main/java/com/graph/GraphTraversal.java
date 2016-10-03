package com.graph;

import java.util.Set;

import com.graph.model.GraphNode;

public interface GraphTraversal {
	
	public Set<String> walk(Set<GraphNode> nodes);

}