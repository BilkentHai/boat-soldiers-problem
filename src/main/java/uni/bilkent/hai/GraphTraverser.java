package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by deniz on 09/03/17.
 */
public class GraphTraverser
{
    public GraphTraverser()
    {
        StateGenerator sg = new StateGenerator();
        State start = sg.getStartState();
        StateTree tree = new StateTree( start);

        Stack<State> path = new Stack<State>();
        List<State> visited = new ArrayList<State>();

        visited.add( start);
        path.add( start);

        while ( !path.isEmpty())
        {
            State cur = path.peek();
            System.out.println( cur);
            List<State> neighborStates = cur.getNeighborStates();
            boolean deadEnd = true;

            for ( State s : neighborStates)
            {
                if ( !visited.contains( s))
                {
                    path.push(s);
                    visited.add( s);
                    deadEnd = false;
                    break;
                }
            }

            if ( deadEnd)
                path.pop();
        }

        System.out.println( visited.size());
    }

    public static void main( String[] args)
    {
        GraphTraverser gt = new GraphTraverser();
    }
}
