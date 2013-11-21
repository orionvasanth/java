package node;

public class Node {

	private Integer digitNumber;	
	private Node[] charChildren;	
	private Node[] intChildren;
	private String pathLabel;
	private Integer id;

	public Node(){
		
	}

	public void setDigitNumber(Integer digitNumber) {
		this.digitNumber = digitNumber;
		setCharChildren((Node[])new Node[27]);
		setIntChildren((Node[])new Node[10]);
	}

	public Integer getDigitNumber() {
		return digitNumber;
	}

	public void setChild(Node child) {
		if(Character.isDigit(child.getPathLabel().charAt(digitNumber)))
			intChildren[(int) child.getPathLabel().charAt(digitNumber)] = child;
		else
			if((int)Character.toUpperCase(child.getPathLabel().charAt(digitNumber)) - 65 == -29)
				charChildren[26] = child;
			else
				charChildren[(int)Character.toUpperCase(child.getPathLabel().charAt(digitNumber)) - 65] = child;
	}

	public Node getChild(Character value) {
		if(Character.isLetter(value))
			return getCharChildren((int)Character.toUpperCase(value) - 65);
		else {
			if((int) value >= 0 && (int) value <= 9)
				return getIntChildren((int) value);
			else
				return getCharChildren((int)Character.toUpperCase(value) - 65);
		}
	}

	private void setCharChildren(Node[] charChildren) {
		this.charChildren = charChildren;
	}

	private Node getCharChildren(Integer index) {
		if(index == -29) 
			return charChildren[26];
		return charChildren[index];
	}

	private void setIntChildren(Node[] intChildren) {
		this.intChildren = intChildren;
	}

	private Node getIntChildren(Integer index) {
		return intChildren[index];
	}

	public void setPathLabel(String pathLabel) {
		this.pathLabel = pathLabel;
	}

	public String getPathLabel() {
		return pathLabel;
	}

	private Integer compare(String x, String y) {
		int i;
		for(i = 0; i < y.length(); i++) {
			if((int)(Character.toLowerCase(x.charAt(i))) != (int)(Character.toLowerCase(y.charAt(i))))
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
