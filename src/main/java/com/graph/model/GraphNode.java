package com.graph.model;

import static java.util.Objects.requireNonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class GraphNode implements Comparable<GraphNode> {
  
	private String name;
	
	private Set<GraphNode> children;
  
	public GraphNode(String name) {
      this(name, new HashSet<>());
    }

	public GraphNode(String name, Set<GraphNode> children) {
		requireNonNull(name);
		requireNonNull(children);
		
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public Set<GraphNode> getChildren() {
		return children;
	}
  
	public void addChild(GraphNode node) {
		this.children.add(node);
	}
  
	public Stream<GraphNode> flattened() {
		return Stream.concat(
			   Stream.of(this), 
			   children.stream().flatMap(GraphNode::flattened));
	}

	@Override
	public int compareTo(GraphNode that) {
		if (this == that) {
			return 0;
		}

		return this.name.compareTo(that.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof GraphNode)) return false;

		GraphNode that = (GraphNode) obj;
			 
		return Objects.equals(this.name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
  
	@Override
	public String toString() {
		return name;
	}
}