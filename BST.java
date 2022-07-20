public class BST {
    public class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        } 
    }

    Node root;
    BST() {
        root = null;
    }
    BST(int value) {
        root = new Node(value);
    }

    public void insertUtil(int key) {
        root = insert(root, key);
    }

    public Node insert(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }
        if(key < root.key) {
            root.left = insert(root.left, key);
        }
        else if(key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }
    public void inorderUtil() {
        inorder(root);
    }
    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insertUtil(10);
        tree.insertUtil(20);
        tree.insertUtil(30);
        tree.inorderUtil();
    }
}
