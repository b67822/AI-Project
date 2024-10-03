package Code;

public class WaterSortSearch extends GenericSearch {
	
	

	
	public String search(Node state) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static String solve(String initialState, String strategy, boolean visualize) {
		
		String[] splittedInitialState = initialState.split(";");
		
		int numberOfBottels = Integer.parseInt(splittedInitialState[0]);
		
		int bottleCapacity = Integer.parseInt(splittedInitialState[1]);
		
		char[][] bottels = new char[numberOfBottels][bottleCapacity];
		
		
		for(int i = 2; i<splittedInitialState.length;i++)
		{
			String[] colors = splittedInitialState[i].split(",");
			char[] characterColors = new char[colors.length];
			for(int j  = 0; j<colors.length;j++)
			{
				characterColors[j] = colors[i].charAt(0);
			}
			bottels[i-2] = characterColors;
		}
		
		Node initialNode = new Node(null, 0, 0, "", "", bottels);
		
        WaterSortSearch searchProblem = new WaterSortSearch();
        
        String result = "";

        switch (strategy) {
            case "BF":
                result = searchProblem.breadthFirstSearch(initialNode);
                break;
            case "DF":
                result = searchProblem.depthFirstSearch(initialNode);
                break;
            case "UC":
                // Call UCS (to be implemented)
                result = searchProblem.uniformCostSearch(initialNode);
                break;
            case "ID":
                // Call Iterative Deepening (to be implemented)
                result = searchProblem.iterativeDeepeningSearch(initialNode);
                break;
            case "GR1":
            case "GR2":
                // Call Greedy Search with heuristic 1 or 2
                result = searchProblem.greedySearch(initialNode, strategy);
                break;
            case "AS1":
            case "AS2":
                // Call A* Search with heuristic 1 or 2
                result = searchProblem.aStarSearch(initialNode, strategy);
                break;
            default:
                result = "Invalid strategy";
        }

        if (visualize) {
            // Visualization logic to print the state transitions (optional)
        }

        return result;
    }

	private String aStarSearch(Node initialNode, String strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	private String greedySearch(Node initialNode, String strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	private String iterativeDeepeningSearch(Node initialNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private String uniformCostSearch(Node initialNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private String depthFirstSearch(Node initialNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private String breadthFirstSearch(Node initialNode) {
		// TODO Auto-generated method stub
		return null;
	}
}
