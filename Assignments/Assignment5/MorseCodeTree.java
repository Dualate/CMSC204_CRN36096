import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	
	private TreeNode<String> root;
	
	/**
	 * calls the build Tree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>(null);
		buildTree();
	}

	
	/**
	 * Returns root of tree
	 * @return root of tree
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * Assigns value to root of tree
	 * @param node to be assigned
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}

	/**
	 * Adds node in proper position according to code
	 * @param code code for where to add new node
	 * @param result data to be added in new node
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
		
	}

	/**
	 * Recursive method to add new node
	 * @param root root of subtree
	 * @param code code of node position
	 * @param letter data of node
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (root == null) 
			root = this.root;
		
		if ( code.length() == 0) {
			root.setData(letter);
			return;
		
		} else {
		
			switch(code.charAt(0)) {
			
				case '.':
					if (root.getLeft() == null)
						root.setLeft(new TreeNode<String>(null));
					root = root.getLeft();
					break;
				
				case '-':
					if (root.getRight() == null)
						root.setRight(new TreeNode<String>(null));
					root = root.getRight();
					break;
			
			}
			
			code = code.substring(1);
			addNode(root, code, letter);
		
		}
		
		
	}

	/**
	 * Returns data from given position
	 * @param code position of node
	 * @return String representation of data
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**recursive method to find node
	 * @param root root of tree to be searched
	 * @param code position of the node
	 * @return String representation of node data
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (!code.isEmpty()) {
			
			switch(code.charAt(0)) {
			
				case '.':
					root = root.getLeft();
					break;
				
				case '-':
					root = root.getRight();
					break;
			
			}
			
			code = code.substring(1);
			return fetchNode(root, code);
		
		}
		return root.getData();
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Method to assemble morse code alphabet
	 */
	@Override
	public void buildTree() {
		insert("", "");
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns ArrayList form of morse code tree
	 * @return ArrayList representatio of morse code tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> letter_list = new ArrayList<String>();
		LNRoutputTraversal(root, letter_list);
		return letter_list;
	}
	
	/**
	 * @param root root of subtree
	 * @param list ArrayList reference to be loaded with data
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		TreeNode<String> left = root.getLeft();
		TreeNode<String> right = root.getRight();
		String data = root.getData();
		if (left != null)
			LNRoutputTraversal(left, list);
		if (data != null)
			list.add(data);
		if (right != null)
			LNRoutputTraversal(right, list);
	}




}
