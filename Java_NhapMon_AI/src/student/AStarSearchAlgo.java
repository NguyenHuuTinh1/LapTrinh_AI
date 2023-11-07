package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> exploer = new ArrayList<Node>();
		frontier.offer(root);
		while (!frontier.isEmpty()) {
			Node curment = frontier.poll();
			if (curment.getLabel().equals(goal)) {
				return curment;
			}
			exploer.add(curment);
			List<Edge> children = curment.getChildren();
			for (Edge child : children) {
				Node end = child.getEnd();
				if (!frontier.contains(child) && !exploer.contains(child)) {
					frontier.add(end);
					child.getEnd().setParent(curment);
				} else if (frontier.contains(end)
						&& ((end.getH() + end.getG()) > (curment.getG() + curment.getH() + child.getWeight()))) {

					end.setG(curment.getH() + child.getWeight());
					end.setParent(curment);
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
