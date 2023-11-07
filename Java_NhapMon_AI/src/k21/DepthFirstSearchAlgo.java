package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	Stack<Node> frontier = new Stack<Node>();
	List<Node> exploer = new ArrayList<Node>();

	@Override
	public Node execute(Node root, String goal) {
		Node curment = frontier.pop();
		if (curment.getLabel().equals(goal))
			return curment;
		exploer.add(curment);
		List<Edge> children = curment.getChildren();
		for (Edge child : children) {
			if (!frontier.contains(child.getEnd()) && !exploer.contains(child.getEnd())) {
				frontier.add(child.getEnd());
				child.getEnd().setParent(curment);
			}
		}
		return curment;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
