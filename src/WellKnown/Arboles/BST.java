package WellKnown.Arboles;

public class BST {

    static class Node {

        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        public void display_node() {
            System.out.println("{" + key + "}");
        }
    }

    static class Tree {

        Node root;

        public Node find(int key) {
            Node current = root;
            while (current.key != key) {
                if (current.key > key) {
                    current = current.left;
                } else if (current.key < key) {
                    current = current.right;
                } else {
                    return null;
                }


            }
            return current;

        }

        public void insert(int key) {
            Node new_node = new Node(key);

            if (root == null) {
                root = new_node;
            } else {
                Node current = root;
                Node parent = root;
                while (current != null) {
                    parent = current;
                    if (current.key > key) {
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }
                // parent.display_node();
                if (parent.key > key) {
                    parent.left = new_node;
                } else {
                    parent.right = new_node;
                }


            }
        }

        //root-left-right
        public void pre_order(Node node) {
            if (node != null) {
                node.display_node();
                pre_order(node.left);
                pre_order(node.right);
            }
        }

        //left - root - right
        public void in_order(Node node) {
            if (node != null) {
                in_order(node.left);
                node.display_node();
                in_order(node.right);
            }
        }

        // left - right - root
        public void pos_order(Node node) {
            if (node != null) {
                pos_order(node.left);
                pos_order(node.right);
                node.display_node();
            }
        }

        public Node minimum() {
            Node current, parent;
            parent = null;
            current = root;
            while (current != null) {
                parent = current;
                current = current.left;
            }
            return parent;
        }

        public Node maximum() {
            Node current, parent;
            parent = null;
            current = root;
            while (current != null) {
                parent = current;
                current = current.right;
            }
            return parent;
        }

        //delete a node
        //Este es uno de los mas complicados pero se resume en esto
        // 1. verificar si no tiene hijos, o si tiene el derecho , el izquierdo o ambos
        // 2. si tiene ambos se debe reemplazar por el sucesor
        // 2.1 si el sucesor es el hijo derecho directo, simplemente se conecta con el padre
        // 2.2 si el sucesor es un descendiente del hijo derecho, se conecta con el padre y ademas en la izquierda del padre se conecta la derecha del sucesor
        public void delete(int key) {
            Node current = root;
            Node parent = null;
            boolean is_left_child = true;
            while (current.key != key) {
                parent = current;
                if (current.key > key) {
                    is_left_child = true;
                    current = current.left;
                } else {
                    is_left_child = false;
                    current = current.right;
                }
                if (current == null) {  // node not found
                    return;
                }
            }


            if (current.right == null && current.left == null) { // no tiene hijos
                if (current == root) {
                    root = null;
                } else if (is_left_child) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (current.left == null) { // Solo tiene el hijo derecho
                if (current == root) {
                    root = current.right;
                } else if (is_left_child) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else if (current.right == null) {  // Tiene el hijo izquierdo
                if (current == root) {
                    root = current.left;
                } else if (is_left_child) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }

            } else { //it has both childs
                // mirar los tipos de casos que existen
                // 1. Que el sucesor sea el hijo directo derecho
                // 2. Que le sucesor sea un nieto del hijo directo

                Node successor = getSuccesor(current);
                if (current == root) {
                    root = successor;
                } else if (is_left_child) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
        }

        //función que retorna el sucesor de un nodo
        private Node getSuccesor(Node delete_node) {
            Node parent_succesor = delete_node;
            Node successor = delete_node;
            Node current = delete_node.right;


            while (current != null) {
                parent_succesor = successor;
                successor = current;
                current = current.left;
            }
            if (successor != delete_node.right) {  // Muy importante este verifica que el sucesor no sea hijo directo del nodo a eliminar
                parent_succesor.left = successor.right;
                successor.right = delete_node.right;
            }

            return successor;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        //  tree.find(3);
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(11);
        tree.insert(6);
        tree.delete(5);

        //  tree.in_order(tree.root);




        // tree.succesor(tree.root.left.right).display_node();

        //   tree.in_order(tree.root);
//        Node min = tree.minimum();
//        Node max = tree.maximum();
//        max.display_node();



    }
}
