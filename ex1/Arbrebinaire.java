1)  Situations techniques : 
Base de données
  Répertoires,dossiers,fichiers
  

  Situations fonctionnelles:
  Hiérarchie des fichiers
  Hiérarchie de classes
  


    

2)

    package Liste_chainée;

public class BinaryTree {

    private static class Node {
        private Integer element;
        private Node left;
        private Node right;

        public Node(Integer element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public Integer getElement() {
            return element;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Integer element) {
        this.root = new Node(element, null, null);
    }


    public boolean isEmpty() {
        return root == null;
    }

    private Node getRoot() {
        return root;
    }

    public Integer rootElement() {
        if (isEmpty()) {
            return null;
        }
        return root.getElement();
    }

    public String toStringPrefixe() {
        StringBuilder sb = new StringBuilder();
        prefixeHelper(root, sb);
        return sb.toString().trim();
    }

    private void prefixeHelper(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.getElement()).append(" ");
        prefixeHelper(node.getLeft(), sb);
        prefixeHelper(node.getRight(), sb);
    }

    public static void main(String[] args) {
        BinaryTree feuille5 = new BinaryTree(5);
        BinaryTree feuille2 = new BinaryTree(2);
        BinaryTree feuille8 = new BinaryTree(8);

        BinaryTree sousArbreGauche = new BinaryTree(100, feuille5, feuille2); 
        BinaryTree arbreComplet = new BinaryTree(200, sousArbreGauche, feuille8); 

        System.out.println("Élément racine : " + arbreComplet.rootElement());
        System.out.println("Parcours préfixé : " + arbreComplet.toStringPrefixe());
    }
}



3)

  Il y a 4 facons de parcourir un arbre:
Parcours infixe
Parcours préfixe
Parcours Postfixe
Parcours en largeur

  Non car par exemple le parcours infixé n'est pas applicable naturellement à un arbre n-aire. Il repose sur l'idée de visiter la racine exactement entre le fils gauche et le fils droit.



4) Le nom de la méthode du parcours qui commence par la racine s'appelle le parcours préfixe.


5)

private void preOrder(Node<T> node, StringBuilder sb) {
    if (node == null) return;
    sb.append(node.element).append(" "); 
    preOrder(node.left, sb);           
    preOrder(node.right, sb);           
}



6)
 public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
    return sb.toString().trim();
}

7)
public static void main(String[] args) {
    BinaryTree<String> tree = new BinaryTree<>();
    

    BinaryTree.Node<String> n5 = new BinaryTree.Node<>("5", null, null);
    BinaryTree.Node<String> n2 = new BinaryTree.Node<>("2", null, null);
    BinaryTree.Node<String> nPlus = new BinaryTree.Node<>("+", n5, n2);
    BinaryTree.Node<String> n8 = new BinaryTree.Node<>("8", null, null);
    
    tree.root = new BinaryTree.Node<>("*", nPlus, n8);
    
   
    System.out.println("Parcours préfixé : " + tree.toString());
}


8) 
import java.util.ArrayList;
import java.util.List;

public class NaryTree<T> {
    
    public static class Node<T> {
        T element;
        List<Node<T>> children;
        
        public Node(T element) {
            this.element = element;
            this.children = new ArrayList<>();
        }
        
        public void addChild(Node<T> child) {
            children.add(child);
        }
    }
    
    protected Node<T> root = null;
    
    public NaryTree(Node<T> root) {
        this.root = root;
    }
}

