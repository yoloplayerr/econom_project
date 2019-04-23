package economic_project;

public class Tree {
	/**
	 * Корень
	 */
	Node root; 
	
	/**
	 * Вставка элементов 
	 * @param node
	 * @param key
	 * @return
	 */
	Node insert(Node node, double key) { 
		  
        /* В случае если узла нет создаем корень */
        if (node == null) {
            return (new Node(key)); 
        }
        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else // Duplicate keys not allowed 
            return node;
		return node; 
	}
	/**
	 * 
	 * @param node
	 */
	void preOrder(Node node) { 
        if (node!= null) { 
            System.out.println(node.key + " "); 
            preOrder(node.left); 
           
            preOrder(node.right); 
           
        } 
    } 
}