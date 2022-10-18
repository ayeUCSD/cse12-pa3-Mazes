import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			System.out.println("Actual Maze:\n" + actualStr);
			String expectedStr = formatMaze(expected);
			//System.out.println("Expected Maze:\n" + expectedStr);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	@Test
	public void testLineMaze() {
		System.out.println("Start Test LineMaze\n\n");
		Maze m = new Maze(new String[] {
				"##F##",
				"##_##",
				"##_##",
				"##_##",
				"##S##", } ) ;
		
		
		String[] solution= {
				"##F##",
				"##*##",
				"##*##",
				"##*##",
				"##S##", } ;
		SearchWorklist wl = new QueueWorklist();
		checkMaze(wl,m,solution);
		System.out.println("End Test LineMaze\n\n");
		
	}
	
	@Test
	public void testStackVsQueue() {
		System.out.println("Start Test StackVsQueue\n\n");
		Maze m = new Maze(new String[] {
				"#___",
				"__F_",
				"S##_",
				"____"} ) ;
		
		
		String[] solution= {
				"#___",
				"__F*",
				"S##*",
				"****"} ;
		SearchWorklist wl = new StackWorklist();
		
		checkMaze(wl,m,solution);
		
		wl = new QueueWorklist();
		
		String[] solution2 = {
				"#___",
				"**F_",
				"S##_",
				"____"
		};
		
		Maze m2 = new Maze(new String[] {
				"#___",
				"__F_",
				"S##_",
				"____"} ) ;
		checkMaze(wl,m2,solution2);
		
		System.out.println("End Test StackVsQueue\n\n");
	}
	
}



