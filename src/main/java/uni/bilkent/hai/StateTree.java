package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eliztekcan on 9.03.2017.
 */
public class StateTree
{
    private  Node root;

    public StateTree( State s){
        root = new Node( s);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot( Node root) {
        this.root = root;
    }

    public static class Node {

        private List<Node> children;
        private State state;

        public Node( State s)
        {
            state = s;
            children = new ArrayList<Node>();
        }

        public State getState() { return state; }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild( Node child) { children.add( child); };
    }
}
