package com.graph.traversal;

import static java.util.Objects.requireNonNull;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.graph.GraphTraversal;
import com.graph.model.GraphNode;

public class FunctionalGraphTraversal implements GraphTraversal {
	
	public FunctionalGraphTraversal() { }

	@Override
	public Set<String> walk(Set<GraphNode> nodes) {
		requireNonNull(nodes);
		
		return walk.apply(nodes);
	}
	
	private Function<Set<GraphNode>, Set<String>> walk =  (nodes) -> 
		nodes.stream()
	     	 .flatMap(each -> each.flattened())
	     	 .map(GraphNode::getName)
	     	 .collect(Collectors.toSet());
}