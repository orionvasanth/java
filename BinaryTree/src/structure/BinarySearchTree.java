package structure;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import sortingTemplates.QuickSort;
import sortingTemplates.Sort;

public class BinarySearchTree extends BinaryTree {

	public static void insert(BinarySearchTree bst, TreeNode node) {
		if (bst.getRoot() == null)
			bst.setRoot(node);
		else {
			TreeNode x = bst.getRoot(), y = null;

			while (x != null) {
				y = x;

				if (node.getData() < x.getData())
					x = x.getLeftChild();
				else
					x = x.getRightChild();
			}

			node.setParent(y);
			if (y == null)
				bst.setRoot(node);
			else if (node.getData() < y.getData())
				y.setLeftChild(node);
			else
				y.setRightChild(node);
		}
	}

	public static void insert(BinarySearchTree bst, Integer data) {
		insert(bst, new TreeNode(data));
	}

	public static TreeNode getNodeBydata(BinarySearchTree bst, Integer data) {
		TreeNode x = bst.getRoot();

		while (x != null) {
			if (x.getData() == data)
				return x;
			else if (data < x.getData())
				x = x.getLeftChild();
			else
				x = x.getRightChild();
		}

		return x;
	}

	public static void delete(BinarySearchTree bst, Integer data) {
		delete(bst, getNodeBydata(bst, data));
	}

	private static void transplant(BinarySearchTree bst, TreeNode u, TreeNode v) {
		if (u.getParent() == null) {
			bst.setRoot(v);
		} else {
			if (u.getParent().getLeftChild() == u) {
				u.getParent().setLeftChild(v);
			} else {
				u.getParent().setRightChild(v);
			}
		}

		if (v != null)
			v.setParent(u.getParent());
	}

	public static TreeNode iterativeTreeMinimum(TreeNode node) {
		if (node == null)
			return node;

		while (node != null) {
			if (node.getLeftChild() != null) {
				node = node.getLeftChild();
			} else
				break;
		}

		return node;
	}

	public static TreeNode recursiveTreeMinimum(TreeNode node) {
		if (node.getLeftChild() != null)
			return recursiveTreeMinimum(node.getLeftChild());
		else
			return node;
	}

	public static TreeNode iterativeTreeMaximum(TreeNode node) {
		if (node == null)
			return node;

		while (node != null) {
			if (node.getRightChild() != null) {
				node = node.getRightChild();
			} else
				break;
		}

		return node;
	}

	public static TreeNode recursiveTreeMaximum(TreeNode node) {
		if (node.getRightChild() != null)
			return recursiveTreeMaximum(node.getRightChild());
		else
			return node;
	}

	public static TreeNode getSuccessor(TreeNode node) {
		if (node == null)
			return node;

		if (node.getRightChild() != null) {
			return iterativeTreeMinimum(node.getRightChild());
		} else {
			TreeNode y = node.getParent();
			if (y != null && y.getRightChild() == node) {
				node = y;
				y = y.getParent();
			}
			return y;
		}
	}

	public static TreeNode getPredecessor(TreeNode node) {
		if (node == null)
			return node;
		if (node.getLeftChild() != null) {
			return iterativeTreeMaximum(node.getLeftChild());
		} else {
			TreeNode y = node.getParent();
			if (y != null && y.getLeftChild() == node) {
				node = y;
				y = y.getParent();
			}
			return y;
		}
	}

	public static void delete(BinarySearchTree bst, TreeNode node) {
		if (node.getLeftChild() == null) {
			if (node.getRightChild() == null) {
				// node has no children
				if (node.getParent() != null) {
					if (node.getParent().getLeftChild() == node) {
						node.getParent().setLeftChild(null);
					} else {
						node.getParent().setRightChild(null);
					}
				} else {
					// node is root and it has no children.
					bst.setRoot(null);
				}
			} else {
				// node has right child and no left child
				if (node.getParent() != null) {
					if (node.getParent().getLeftChild() == node) {
						node.getParent().setLeftChild(node.getRightChild());
					} else {
						node.getParent().setRightChild(node.getRightChild());
					}
					node.getRightChild().setParent(node.getParent());
				} else {
					// node is root
					bst.setRoot(node.getRightChild());
					node.getRightChild().setParent(null);
				}
			}

		} else {
			if (node.getRightChild() == null) {
				// node has left child and no right child
				if (node.getParent() != null) {
					if (node.getParent().getLeftChild() == node) {
						node.getParent().setLeftChild(node.getLeftChild());
					} else {
						node.getParent().setRightChild(node.getLeftChild());
					}
					node.getLeftChild().setParent(node.getParent());
				} else {
					bst.setRoot(node.getLeftChild());
					node.getLeftChild().setParent(null);
				}
			} else {
				// node has 2 children
				TreeNode successor = getSuccessor(node);
				if (successor.getParent() == node) {
					if (node.getParent() != null) {
						if (node.getParent().getLeftChild() == node) {
							node.getParent().setLeftChild(successor);
							successor.setParent(node.getParent());
							successor.setLeftChild(node.getLeftChild());
						}
					} else {
						bst.setRoot(successor);
						successor.setParent(node.getParent());
						successor.setLeftChild(node.getLeftChild());
					}
				} else {
					TreeNode x = successor.getRightChild();
					if (x != null) {
						// successor will be the leftchild of its parent,
						// verify.
						if (successor.getParent().getLeftChild() == successor) {
							successor.getParent().setLeftChild(x);
							x.setParent(successor.getParent());
						} else {
							successor.getParent().setRightChild(x);
							x.setParent(successor.getParent());
							System.out
									.println("Successor need not be the leftchild of its parent, verified");
						}
					}
					if (node.getParent() != null) {
						if (node.getParent().getLeftChild() == node) {
							node.getParent().setLeftChild(successor);
						} else {
							node.getParent().setRightChild(successor);
						}
						successor.setParent(node.getParent());
						successor.setLeftChild(node.getLeftChild());
						successor.setRightChild(node.getRightChild());
					} else {
						bst.setRoot(successor);
						successor.setParent(node.getParent());
						successor.setLeftChild(node.getLeftChild());
						successor.setRightChild(node.getRightChild());
					}
				}
			}
		}
	}

	public static void deleteUsingTransplant(BinarySearchTree bst, TreeNode node) {
		if (node == null)
			return;

		if (node.getLeftChild() == null) {
			transplant(bst, node, node.getRightChild());
		} else {
			if (node.getRightChild() == null)
				transplant(bst, node, node.getLeftChild());
		}
		TreeNode y = iterativeTreeMinimum(node.getRightChild());
		if (y.getParent() != node) {
			transplant(bst, y, y.getRightChild());
			y.setRightChild(node.getRightChild());
			y.getRightChild().setParent(y);
		}
		transplant(bst, node, y);
		y.setLeftChild(node.getLeftChild());
		y.getLeftChild().setParent(y);
	}

	public static void recursiveInorderWalk(TreeNode node) {
		if (node != null) {
			if (node.getLeftChild() != null)
				recursiveInorderWalk(node.getLeftChild());

			System.out.print(node.getData() + " ");

			if (node.getRightChild() != null)
				recursiveInorderWalk(node.getRightChild());
		} else
			return;
	}

	public static void iterativeInorderWalk(TreeNode node) {
		Stack<TreeNode> parentStack = new Stack<TreeNode>();
		while (!parentStack.isEmpty() || node != null) {
			if (node != null) {
				parentStack.push(node);
				node = node.getLeftChild();
			} else {
				node = parentStack.pop();
				System.out.print(node.getData() + " ");
				node = node.getRightChild();
			}
		}
	}

	public static void iterativeInorderWalkUsingParent(TreeNode node) {
		if (node == null)
			return;
		TreeNode prevNode = null;
		while (node != null) {
			if (prevNode != null && prevNode.getParent() == node) {
				if (node.getLeftChild() == prevNode) {
					System.out.print(node.getData() + " ");
					if (node.getRightChild() != null) {
						prevNode = node;
						node = node.getRightChild();
					}
				} else {
					if (node.getRightChild() == prevNode) {
						prevNode = node;
						node = node.getParent();
					}
				}
			} else {
				if (node.getLeftChild() != null) {
					prevNode = node;
					node = node.getLeftChild();
				} else {
					if (node.getRightChild() != null) {
						prevNode = node;
						node = node.getRightChild();
					} else {
						System.out.print(node.getData() + " ");
						prevNode = node;
						node = node.getParent();
					}
				}
			}
		}
	}

	public static void recursivePreorderWalk(TreeNode node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			recursivePreorderWalk(node.getLeftChild());
			recursivePreorderWalk(node.getRightChild());
		}
	}

	public static void iterativePreorderWalk(TreeNode node) {
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();

		while (!nodeStack.isEmpty() || node != null) {
			if (node != null) {
				nodeStack.push(node);
				System.out.print(node.getData() + " ");
				node = node.getLeftChild();
			} else {
				node = nodeStack.pop();
				node = node.getRightChild();
			}
		}
	}

	public static void iterativePreorderWalkUsingParentField(TreeNode node) {
		if (node == null)
			return;
		TreeNode prevNode = null;
		while (node != null) {

			if (prevNode.getParent() == node) {
				if (node.getLeftChild() == prevNode) {
					if (node.getRightChild() != null) {
						prevNode = node;
						node = node.getRightChild();
					}
				} else {
					if (node.getRightChild() == prevNode) {
						prevNode = node;
						node = node.getParent();
					}
				}

			} else {

				System.out.print(node.getData() + " ");

				if (node.getLeftChild() != null) {
					prevNode = node;
					node = node.getLeftChild();
				} else {
					if (node.getRightChild() != null) {
						prevNode = node;
						node = node.getRightChild();
					} else {
						prevNode = node;
						node = node.getParent();
					}
				}

			}
		}

	}

	public static void recursivePostorderWalk(TreeNode node) {
		if (node != null) {
			recursivePostorderWalk(node.getLeftChild());
			recursivePostorderWalk(node.getRightChild());
			System.out.print(node.getData() + " ");
		} else
			return;
	}

	public static void iterativePostorderWalk(TreeNode node) {
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		if (node == null)
			return;
		nodeStack.push(node);
		TreeNode prevNode = null;

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.peek();

			// left & right subtree have not been traversed. prevNode will be
			// NULL when initially entering the loop
			if (prevNode == null || prevNode.getLeftChild() == currNode
					|| prevNode.getRightChild() == currNode) {
				if (currNode.getRightChild() != null) {
					nodeStack.push(currNode.getRightChild());
				} else {
					if (currNode.getLeftChild() != null) {
						nodeStack.push(currNode.getLeftChild());
					} else {
						System.out.println(currNode.getData() + " ");
						nodeStack.pop();
					}
				}
			} else {
				if (currNode.getLeftChild() == prevNode) {
					if (currNode.getRightChild() != null) {
						nodeStack.push(currNode.getRightChild());
					} else {
						System.out.println(currNode.getData() + " ");
						nodeStack.pop();
					}
				} else {
					if (currNode.getRightChild() == prevNode) {
						// means the right subtree have been traversed so visit
						// currNode and pop it.
						System.out.print(currNode.getData() + " ");
						nodeStack.pop();
					}
				}
			}

			prevNode = currNode;
		}
	}

	public static void iterativePostorderWalkUsingParentField(TreeNode node) {
		if (node == null)
			return;

		TreeNode prevNode = null;
		while (node != null) {
			if (prevNode.getParent() == node) {
				if (node.getLeftChild() == prevNode) {
					if (node.getRightChild() != null) {
						prevNode = node;
						node = node.getRightChild();
					}
				} else {
					if (node.getRightChild() == prevNode) {
						System.out.print(node.getData() + " ");
						prevNode = node;
						node = node.getParent();
					}
				}
			} else {
				if (node.getLeftChild() != null) {
					prevNode = node;
					node = node.getLeftChild();
				} else {
					if (node.getRightChild() != null) {
						prevNode = node;
						node = node.getRightChild();
					} else {
						System.out.print(node.getData() + " ");
						prevNode = node;
						node = node.getParent();
					}
				}
			}
		}
	}

	public static void printAllPathsForSumFromRoot(BinarySearchTree bst,
			Integer sum) {
		printAllPathsForSumFromRoot(bst.getRoot(), null, null, 0, sum);
	}

	public static void printAllPathsFromRoot(TreeNode tNode, ListNode head,
			ListNode tail, int sum) {
		if (tNode == null) {
			System.out.print("\nPath " + sum + ": ");
			LinkedList.printList(head);
			return;
		} else {
			sum = sum + tNode.getData();
			if (tail == null) {
				head = tail = new ListNode(tNode.getData());
			} else {
				tail.setNext(new ListNode(tNode.getData()));
				tail = tail.getNext();
			}
			printAllPathsFromRoot(tNode.getLeftChild(), head, tail, sum);
			printAllPathsFromRoot(tNode.getRightChild(), head, tail, sum);
		}
	}

	private static void printAllPathsForSumFromRoot(TreeNode node,
			ListNode head, ListNode tail, Integer currSum, Integer sum) {
		if(node == null && currSum == sum) {
			LinkedList.printList(head);
			return;
		}
		
		currSum += node.getData();
		if(tail == null) {
			head = tail = new ListNode(node.getData());
		} else {
			tail.setNext(new ListNode(node.getData()));
			tail = tail.getNext();
		}
		
		printAllPathsForSumFromRoot(node.getLeftChild(), head, tail, currSum, sum);
		printAllPathsForSumFromRoot(node.getRightChild(), head, tail, currSum, sum);
		
	}

	public static void levelOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		queue.addLast(node);
		queue.addLast(null);

		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (node == null) {
				if (queue.isEmpty())
					return;
				queue.addLast(null);
				System.out.println();
				continue;
			}
			if (node.getLeftChild() != null)
				queue.addLast(node.getLeftChild());

			if (node.getRightChild() != null)
				queue.addLast(node.getRightChild());

			System.out.print(node.getData() + " ");
		}
	}

	public static Boolean isThereAPathFromRoot(TreeNode node, Integer sum) {
		if (Math.abs(node.getData().intValue() - sum.intValue()) == 0)
			return Boolean.TRUE;

		if (node.getLeftChild() != null) {
			if (isThereAPathFromRoot(node.getLeftChild(), sum - node.getData()))
				return Boolean.TRUE;
		}

		if (node.getRightChild() != null) {
			if (isThereAPathFromRoot(node.getRightChild(), sum - node.getData()))
				return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public static TreeNode buildBinarySearchTreeFromSortedLinkedList(
			ListNode node, int length) {
		class Nodes {
			public ListNode lNode;
			public TreeNode tNode;

			public Nodes(ListNode lNode, TreeNode tNode) {
				this.lNode = lNode;
				this.tNode = tNode;
			}

			public Nodes buildBinarySearchTreeFromSortedLinkedList(Nodes nodes,
					int length) {
				if (length <= 0) {
					return null;
				}

				Nodes left = buildBinarySearchTreeFromSortedLinkedList(nodes,
						length / 2);
				TreeNode tRoot = null;
				if (left == null) {
					tRoot = new TreeNode(nodes.lNode.getData());
					left = new Nodes(nodes.lNode.getNext(), null);
				} else {
					tRoot = new TreeNode(left.lNode.getData());
					tRoot.setLeftChild(left.tNode);
					left = new Nodes(left.lNode.getNext(), null);
				}
				Nodes right = buildBinarySearchTreeFromSortedLinkedList(left,
						length - length / 2 - 1);
				if (right == null) {
					return new Nodes(left.lNode, tRoot);
				} else {
					tRoot.setRightChild(right.tNode);
					return new Nodes(right.lNode, tRoot);
				}
			}
		}

		Nodes nodes = new Nodes(node, null);
		return nodes.buildBinarySearchTreeFromSortedLinkedList(nodes, length).tNode;
	}

	public static TreeNode buildBinarySearchTreeFromSortedArray(Integer[] input) {
		return buildBinarySearchTreeFromSortedArray(input, 0, input.length - 1);
	}

	private static TreeNode buildBinarySearchTreeFromSortedArray(
			Integer[] input, int p, int r) {
		if (p > r || (r < 0))
			return null;

		int q = (p + r) / 2;
		TreeNode node = new TreeNode(input[q]);
		node.setLeftChild(buildBinarySearchTreeFromSortedArray(input, p, q - 1));
		if (node.getLeftChild() != null)
			node.getLeftChild().setParent(node);
		node.setRightChild(buildBinarySearchTreeFromSortedArray(input, q + 1, r));
		if (node.getRightChild() != null)
			node.getRightChild().setParent(node);

		return node;
	}
	
	public static void main(String[] args) {
		Integer[] input = new Integer[10];
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		while (set.size() != 10) {
			set.add(random.nextInt(30));
		}
		Object[] data = set.toArray();
		for (int i = 0; i < data.length; i++) {
			input[i] = (Integer) data[i];
		}
		Sort sort = new QuickSort();
		sort.sort(input);

		BinarySearchTree bst = new BinarySearchTree();
		bst.setRoot(buildBinarySearchTreeFromSortedArray(input));
		System.out.println();
		/*BinarySearchTree.levelOrderTraversal(bst.getRoot());
		System.out.println();*/
		BinarySearchTree.recursiveInorderWalk(bst.getRoot());
		System.out.println();
		BinarySearchTree.recursivePreorderWalk(bst.getRoot());
		System.out.println();
		BinarySearchTree.recursivePostorderWalk(bst.getRoot());
//		BinarySearchTree.printAllPathsFromRoot(bst.getRoot(), null, null, 0);
		
		BinaryTree.getDiameterOptimized(bst.getRoot());

	}

}
