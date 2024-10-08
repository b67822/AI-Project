package Code;

public class Node{
	 
	private Node parent;
	private int pathCost;
	private int depth;
	private String operator;
	private String action;
	private char[][] bottels;
	private String state;

	public Node(Node parent, int pathCost, int depth, String operator, String action
			, char[][] bottels, String state)
	{
		this.parent = parent;
		this.pathCost = pathCost;
		this.depth = depth;
		this.operator = operator;
		this.action = action;
		this.bottels = bottels;
		this.state = state;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Node(Node parent, int pathCost, int depth, String operator, String action
			, char[][] bottels)
	{
		this.parent = parent;
		this.pathCost = pathCost;
		this.depth = depth;
		this.operator = operator;
		this.action = action;
		this.bottels = bottels;
	}

	public Node getParent() {
		return parent;
	}

	public int getPathCost() {
		return pathCost;
	}

	public int getDepth() {
		return depth;
	}

	public String getOperator() {
		return operator;
	}
	
	public String getAction()
	{
		return action;
	}
	
	public String getSolution()
	{
		StringBuilder res = new StringBuilder();;
		Node current = this;
		while(current!=null)
		{
			res.insert(0, current.action + ",");
			current = current.parent;
		}
		return res.toString();
	}

	public boolean isGoal(){
		// check if state is goal --> need implementation
		return false;
	}

}
