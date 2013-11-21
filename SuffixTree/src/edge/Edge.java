package edge;
import node.Node1;

public class Edge {	
	private String label;
	private Node1 top;
	private Node1 bottom;
	
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setTop(Node1 top) {
		this.top = top;
	}
	public Node1 getTop() {
		return top;
	}
	public void setBottom(Node1 bottom) {
		this.bottom = bottom;
	}
	public Node1 getBottom() {
		return bottom;
	}
}
