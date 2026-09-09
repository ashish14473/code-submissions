/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>(); // the lookup desk: original -> copy
        return rec(node, visited);
    }

    private Node rec(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node); // already photocopied — hand back that copy
        }

        Node clone = new Node(node.val);   // make the new room, empty of hallways for now
        visited.put(node, clone);          // put it on the desk BEFORE recursing (breaks cycles!)

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(rec(neighbor, visited)); // build each hallway
        }

        return clone;
    }
}