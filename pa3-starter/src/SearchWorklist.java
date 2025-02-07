import java.util.*;
/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {
	Stack<Square> s = new Stack<Square>();
	
	public void add(Square c) {
		s.add(c);
	}
	public Square remove() {
		return s.pop();
	}
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	public ArrayList<Square> toArrayList(){
		ArrayList<Square> al = new ArrayList<Square>();
		al.addAll(s);
		return al;
	}
	
}

class QueueWorklist implements SearchWorklist {
	Queue<Square> q = new LinkedList<Square>();
	public void add(Square c) {
		q.add(c);
	}
	public Square remove() {
		return q.remove();
	}
	public boolean isEmpty() {
		return q.isEmpty();
	}
	public ArrayList<Square> toArrayList(){
		ArrayList<Square> al = new ArrayList<Square>();
		al.addAll(q);
		return al;
	}
	

}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
	ArrayList<Square> toArrayList();
}
