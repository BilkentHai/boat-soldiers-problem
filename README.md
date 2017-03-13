# CS 461 – ARTIFICIAL INTELLIGENCE

# HW #1

The problem was represented using different java objects such as Boy, Soldier, Boat, SideofRiver etc. Using these objects and the problem constraints every possible state was generated using the StateGenerator class. The StateGenerator also connected the states by checking in pairs if it was possible to reach one from the other. Visualising the resulting graph, we noticed that it looked very much like a tree. Using this insight, we turned the graph into a tree taking the initial state as root and adjusting the edges to make the graph directed. This was done in the GraphTraverser class. Having represented all possible states and their transitions as a tree, we used Breadth First Search to obtain the path from the initial state to the goal state. The Solver class searches the tree in a breadth first fashion and saves its path into a hash which is then printed onto the console.

The code also includes the GraphGenerator class which, using the data resulting from the solution procedure, visualises the solution tree into a file format viewable by a web browser. This file can be viewed by opening index.html with a web browser.

All of the necessary work is done in the main function within the Main class.

The library cytoscape.js is used to visualize the state tree. This library can be accessed from [https://github.com/cytoscape/cytoscape.js](https://github.com/cytoscape/cytoscape.js)

The state tree in index.html looks like this:

Black dots indicate the path from the initial state to the goal state. Green dots represent the search path.
