package logic;
import node.Node;

public class SuffixTree {

	private Node root;
	private Node branch;
	private Node child;

	private Node search2Insert(String searchStr) {
		return search2Insert(root, searchStr);
	}

	public void insert(Node child) {
		String key = child.getPathLabel();
		if(root != null) {
			Node end = search2Insert(key);
			Node branch = new Node();
			branch.setDigitNumber(end.compare(key));
			branch.setPathLabel(key.substring(0, branch.getDigitNumber()));
			//retrace
			Node x = root, y = null; //y parent of x
			while(x != null && x != end) {
				if(x.getDigitNumber() == null || x.getDigitNumber() > branch.getDigitNumber())
					break;
				else {
					y = x;
					x = x.getChild(key.charAt(x.getDigitNumber()));
				}
			}
			//replace or insert branch node btw y and x
			//y can be null implies x is root
			//x can be null?
			if(x.getDigitNumber() != null && branch.getDigitNumber() == x.getDigitNumber()) {
				x.setChild(child);				
			}else {
				//can y be null here? = x is root
				y.setChild(branch); //branch.pathLabel should be of y.digitNumber length at least
				branch.setChild(x);
				branch.setChild(child);
			}
		}else {
			root = new Node();
			root.setDigitNumber(0);
			root.setPathLabel("");			
			root.setChild(child);
		}
	}

	private Node search2Insert(Node x, String searchStr) {
		// TODO Auto-generated method stub
		Character index = searchStr.charAt(x.getDigitNumber());
		Node y = x.getChild(index);
		if(y == null)
			return x;

		if(y.getDigitNumber() == null)//search ends at an element node
			if(y.getPathLabel().equalsIgnoreCase(searchStr + "$"))
				return null;
			else
				return y;
		else
			return search2Insert(y, searchStr);
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void printTree() {
		printTree(root);
	}

	private void printTree(Node x) {
		for(int i = 0; i < 10; i++) {
			Node y;
			if(x.getDigitNumber() != null && (y = x.getChild((char)i)) != null)
				printTree(y);
			else
				System.out.println(x.getPathLabel());
		}

		for(int i = 0; i < 26; i++) {
			Node y;
			if(x.getDigitNumber() != null && (y = x.getChild((char)(i + 65))) != null)
				printTree(y);
			else
				System.out.println(x.getPathLabel());
		}
	}

	public void insertOptimized(Node child) {		
		this.child = child;
		if(root != null)			
			insertOptimized(child.getPathLabel(), root, null);		
		else {
			root = new Node();
			root.setDigitNumber(0);
			root.setPathLabel("");			
			root.setChild(child);
		}
		this.branch = null;
	}

	public void insertOptimized(String key, Node current, Node prev) {
		//is current a branch node?
		if(current.getDigitNumber() != null) {
			Node y = current.getChild(key.charAt(current.getDigitNumber()));
			if(y != null)
				insertOptimized(key, y, current);
			else {
				branch = new Node();
				branch.setDigitNumber(current.compare(key));
				branch.setPathLabel(key.substring(0, branch.getDigitNumber()));
				if(prev == null) {
					if(branch.getDigitNumber() == current.getDigitNumber())
						current.setChild(child);
				} else
				if(branch.getDigitNumber() > prev.getDigitNumber() && 
						branch.getDigitNumber() <= current.getDigitNumber()) {
					if(branch.getDigitNumber() == current.getDigitNumber()) {
						current.setChild(child);						
					} else {
						prev.setChild(branch);
						branch.setChild(current);
						branch.setChild(child);
					}
				}
			}
		} else {
			branch = new Node();
			branch.setDigitNumber(current.compare(key));
			branch.setPathLabel(key.substring(0, branch.getDigitNumber()));
			prev.setChild(branch);
			branch.setChild(current);
			branch.setChild(child);
		}
	}
}
