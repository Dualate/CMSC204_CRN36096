/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 * @param <T> generic parameter
 */
public class TreeNode<T> {
	
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	/**
	 * constructor that initializes data with value and sets children to null
	 * @param data
	 */
	public TreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	/**
	 * returns node data
	 * @return data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Assigns value to node
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Returns reference to left child
	 * @return left node
	 */
	public TreeNode<T> getLeft(){
		return left;
	}
	
	/**
	 * Returns reference to right child
	 * @return right node
	 */
	public TreeNode<T> getRight(){
		return right;
	}

	/**
	 * Assigns value to left child
	 * @param left node to be added
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	/**
	 * Assigns value to right child
	 * @param right node to be added
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
}
