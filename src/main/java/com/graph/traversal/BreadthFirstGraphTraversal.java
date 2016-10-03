package com.graph.traversal;

import static java.util.Objects.requireNonNull;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import com.graph.GraphTraversal;
import com.graph.model.GraphNode;

public class BreadthFirstGraphTraversal implements GraphTraversal {
	
	public BreadthFirstGraphTraversal() { }

	@Override
	public Set<String> walk(Set<GraphNode> nodes) {
		requireNonNull(nodes);
		
		Queue<GraphNode> toTraverse = new LinkedList<>();
		Set<GraphNode> traversed = new HashSet<>();
		
		toTraverse.addAll(nodes);
		
		while (! toTraverse.isEmpty()) {
			GraphNode currentNode = toTraverse.remove();
			
			Set<GraphNode> childrenToVisit = this.visit(currentNode);
			
			traversed.add(currentNode);

			for (GraphNode child : childrenToVisit) {
				if (!traversed.contains(child)) {
					toTraverse.add(child);
				}
			}
		}
		
		return toNodeNames(traversed);
	}

	private Set<GraphNode> visit(GraphNode node) {
		return node.getChildren();  
	}
	
	private Set<String> toNodeNames(Set<GraphNode> nodes) {
		return nodes.stream()
					.map(GraphNode::getName)
					.collect(Collectors.toSet());
	}

}