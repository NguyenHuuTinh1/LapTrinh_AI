package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	Queue<Node> frontier = new LinkedList<Node>();
	List<Node> exploer = new ArrayList<Node>();

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Node curment = frontier.poll();
		if (curment.getLabel().equals(goal))
			return curment;
		exploer.add(curment);
		List<Node> children = curment.getChildrenNodes();
		for (Node child : children) {
			if (!frontier.contains(child) && !exploer.contains(child)) {
				frontier.add(child);
				child.setParent(curment);
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
