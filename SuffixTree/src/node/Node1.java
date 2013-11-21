package node;

public class Node1 {
	
	private Integer digitNumber;	
	private Node1[] charChildren;	
	private Node1[] intChildren;
	private Node1 parent;
	private String pathLabel;
	
	public Node1(){
		setCharChildren((Node1[])new Node1[27]);
		setIntChildren((Node1[])new Node1[10]);
	}

	public void setDigitNumber(Integer digitNumber) {
		this.digitNumber = digitNumber;
	}

	public Integer getDigitNumber() {
		return digitNumber;
	}

	public void setChild(Node1 child) {
		
	}

	public Node1 getChild(Character value) {
		if(Character.isDigit(value))
			return getIntChildren(Integer.parseInt(value + ""));
		else
			return getCharChildren((int)Character.toUpperCase(value) - 65);		
	}

	public void setCharChildren(Node1[] charChildren) {
		this.charChildren = charChildren;
	}

	public Node1 getCharChildren(Integer index) {
		return charChildren[index];
	}

	public void setIntChildren(Node1[] intChildren) {
		this.intChildren = intChildren;
	}

	public Node1 getIntChildren(Integer index) {
		return intChildren[index];
	}

	public void setPathLabel(String pathLabel) {
		this.pathLabel = pathLabel;
	}

	public String getPathLabel() {
		return pathLabel;
	}
	
	public void setParent(Node1 parent) {
		this.parent = parent;
	}

	public Node1 getParent() {
		return parent;
	}

	private Integer compare(String x, String y) {
		int i;
		for(i = 0; i < y.length(); i++) {
			if((int)(x.charAt(i)) != (int)(y.charAt(i)))
				return i;
		}
		return i;
	}
	
	public Integer compare(String key) {
		if(pathLabel.length() < key.length())
			return compare(key, pathLabel);//return -ve 
		else
			return compare(pathLabel, key);//return +ve
	}
}
