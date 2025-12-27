package A7_BST;

class Node {
	Node left, right;
	String word, meaning;

	Node() {
		left = right = null;
		word = meaning = null;
	}

	public Node(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
		left = right = null;
	}
}
