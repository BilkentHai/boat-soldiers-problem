package uni.bilkent.hai;

import java.util.List;

/**
 * Created by eliztekcan on 9.03.2017.
 */
public class StateTree{
    private  Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public StateTree(State s){
        root = new Node();
    }

    public static class Node{
        private Node parent;
        private List<Node> children;

        public Node getParent() {
            return parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}