import java.util.ArrayList;

/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {

		
		Square start = maze.start;
		start.visit();
		wl.add(start);
		System.out.println("Starting search with square " + start.toString());
		Square current;
		
		while (!wl.isEmpty()) {
			//System.out.println("Worklist has: " + wl.toArrayList().toString());
			current = wl.remove();
			if (current == maze.finish) {
				System.out.println("I AM RETURNING " + current.toString());
				return current;
				
			} else {
				
				//System.out.println("looking at " + current.toString() + " not equal to " + maze.finish.toString());
				
				ArrayList<Square> neighbors = getNeighbors(maze,current);
				for (Square s : neighbors) {
					s.visit();
					s.setPrevious(current);
					wl.add(s);
					//System.out.println("Added " + s.toString());
					

				}
				//System.out.println("\n");
			}

		}
		
		System.out.println("Returning null");
		return null;
	}

	/* Add any helper methods you want */
	public static ArrayList<Square> getNeighbors(Maze maze, Square s) {
		System.out.println("neighbors for " + s.toString());
		ArrayList<Square> neighbors = new ArrayList<Square>();
		Square temp;
		// check up
		if (s.getRow() != 0) {
			temp = maze.contents[s.getRow() - 1][s.getCol()];
			
			if (!temp.isVisited() && !temp.getIsWall()) {
				neighbors.add(temp);
			}
		}

		// check down
		if (s.getRow() != maze.contents.length - 1) {
			temp = maze.contents[s.getRow() + 1][s.getCol()];
			if (!temp.isVisited() && !temp.getIsWall()) {
				neighbors.add(temp);
			}
		}
		// check right
		if (s.getCol() != maze.contents[0].length-1) {
			temp = maze.contents[s.getRow()][s.getCol() + 1];
			if (!temp.isVisited() && !temp.getIsWall()) {
				neighbors.add(temp);
			}
		}
		// check left
		if (s.getCol() != 0) {
			temp = maze.contents[s.getRow()][s.getCol() - 1];
			if (!temp.isVisited() && !temp.getIsWall()) {
				neighbors.add(temp);
			}
		}
		System.out.println("found " + neighbors.size() + " neighbors");
		return neighbors;
	}
}
