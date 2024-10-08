package Code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
		int depthLimit = 0;
        while (true) {
            String result = depthLimitedSearch(initialNode, depthLimit);
            if (!result.equals("CUTOFF") && !result.equals("NOSOLUTION")) {
                return result;
            }
            if (result.equals("NOSOLUTION")) {
                return "NOSOLUTION";
			}
            depthLimit++;
        }
	}

	private String depthLimitedSearch(Node initialNode, int depthLimit) {
		Stack<Node> frontier = new Stack<>();
        Set<String> explored = new HashSet<>();
        frontier.push(new Node(initialNode, 0, 0, null, null, null));
		while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            String currentState = currentNode.getState();
			
            if (currentNode.isGoal()) {
				return currentNode.getSolution();
            }


            if (currentNode.getDepth() >= depthLimit) {
                continue;
            }


            explored.add(currentState);
            List<String> actions = generateActions(currentState);

            for (String action : actions) {
                String newState = applyAction(currentState, action);
                if (!explored.contains(newState)) {
                    Node childNode = new Node(currentNode, currentNode.getPathCost(),currentNode.getDepth()+1,null ,null, null , newState);
                    frontier.push(childNode);
                    explored.add(newState);
                }
            }
        }

		return null;
	}

	private String uniformCostSearch(Node initialNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private String depthFirstSearch(Node initialNode) {
		Stack<Node> frontier = new Stack<>();
        Set<String> explored = new HashSet<>();

		Node StartNode = new Node(initialNode, 0, 0, null, null, null);
		frontier.add(initialNode);

		while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            String currentState = currentNode.getState();

            if (currentNode.isGoal()) {
				return currentNode.getSolution();
			}

            explored.add(currentState);

            List<String> actions = generateActions(currentState);

            for (String action : actions) {
                String newState = applyAction(currentState, action);

                if (!explored.contains(newState)) {
					Node childNode = new Node(currentNode, currentNode.getPathCost(),currentNode.getDepth()+1,null ,null, null , newState);
                    frontier.push(childNode);
                    explored.add(newState);  
                }
            }
        }
		return null;
	}

	private String breadthFirstSearch(Node initialNode) {
		Queue<Node> frontier = new LinkedList<>();
		Set<String> explored = new HashSet<>();

		Node StartNode = new Node(initialNode, 0, 0, null, null, null);
		frontier.add(initialNode);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			String currentState = currentNode.getState();

			if (currentNode.isGoal()){
				return currentNode.getSolution();
			}

			explored.add(currentState);

			List<String> actions = generateActions(currentState);

			for (String action : actions) {
				String newState = applyAction(currentState, action);

				if (!explored.contains(newState)) {
					Node childNode = new Node(currentNode, currentNode.getPathCost(),currentNode.getDepth()+1,null ,null, null , newState);
					frontier.add(childNode);
					explored.add(newState);
				}
			}
		}

		return null;
	}


	private String applyAction(String currentState, String action) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'applyAction'");
	}


	private List<String> generateActions(String currentState) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'generateActions'");
	}
}
