package Code;

public abstract class GenericSearch {
	
	public abstract String search(Node state);
	
	public boolean isGoalState(Node state)
	{
		return false;
	}
	
	
}