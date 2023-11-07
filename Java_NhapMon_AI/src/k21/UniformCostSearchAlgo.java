package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new PriorityQueue<Node>();
		List<Node> exploer = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node curment = frontier.poll();
			if (curment.getLabel().equals(goal)) {
				return curment;
			}
			exploer.add(curment);
			List<Edge> children = curment.getChildren();
			for (Edge child : children) {
				if (!frontier.contains(child) && !exploer.contains(child)) {
					frontier.add(child.getEnd());
					child.getEnd().setParent(curment);
					child.getEnd().setPathCost(curment.getPathCost() + child.getWeight());

				} else if (child.getEnd().getPathCost() > (curment.getPathCost() + child.getWeight())) {
						child.getEnd().setPathCost((curment.getPathCost() + child.getWeight()));
						child.getEnd().setParent(curment);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
