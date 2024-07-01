package KdTree;

import java.util.*;

public class kdtree {
    private int dimensions_;
    private Node root_ = null;
    private List<Node> best_ = null;
    private double bestDistance_ = 0;
   
    
    public kdtree(int dimensions, List<Node> nodes) {
        dimensions_ = dimensions;
        root_ = makeTree(nodes, 0, nodes.size(), 0);
    }
    
    public List<Node> findNearest(Node target, int k) {
        best_ = new ArrayList<>();
        bestDistance_ = 0;
       
        nearest(root_, target, 0, k);
        return best_;
    }
    
   
    
    public double distance() {
        return Math.sqrt(bestDistance_);
    }
    
    private void nearest(Node root, Node target, int index, int k) {
        if (root == null)
            return;
        double d = root.distance(target);
        if (best_.size() < k || d < bestDistance_) {
            bestDistance_ = d;
            best_.add(root);
            if (best_.size() > k)
                best_.remove(0);
        }
        if (bestDistance_ == 0)
            return;
        double dx = root.get(index) - target.get(index);
        index = (index + 1) % dimensions_;
        nearest(dx > 0 ? root.left_ : root.right_, target, index, k);
        if (dx * dx >= bestDistance_)
            return;
        nearest(dx > 0 ? root.right_ : root.left_, target, index, k);
    }
    
    private Node makeTree(List<Node> nodes, int begin, int end, int index) {
        if (end <= begin)
            return null;
        int n = begin + (end - begin)/2;
        Node node = quickselect.select(nodes, begin, end - 1, n, new NodeComparator(index));
        index = (index + 1) % dimensions_;
        node.left_ = makeTree(nodes, begin, n, index);
        node.right_ = makeTree(nodes, n + 1, end, index);
        return node;
    }
    
    private static class NodeComparator implements Comparator<Node> {
        private int index_;

        private NodeComparator(int index) {
            index_ = index;
        }
        public int compare(Node n1, Node n2) {
            return Double.compare(n1.get(index_), n2.get(index_));
        }
    }
    
    public static class Node {
        private double[] coords_;
        private Node left_ = null;
        private Node right_ = null;
        private String id_;
        private String diagnosis_;

        public Node(String id, String diagnosis, double[] coords) {
            id_ = id;
            diagnosis_ = diagnosis;
            coords_ = coords;
        }

        double get(int index) {
            return coords_[index];
        }
        String getdiagnosis() {
        	return diagnosis_;
        }

        double distance(Node node) {
            double dist = 0;
            for (int i = 0; i < coords_.length; ++i) {
                double d = coords_[i] - node.coords_[i];
                dist += d * d;
            }
            return dist;
        }

        public String toString() {
            StringBuilder s = new StringBuilder("(" + id_ + ", " + diagnosis_ + ", ");
            for (int i = 0; i < coords_.length; ++i) {
                if (i > 0)
                    s.append(", ");
                s.append(coords_[i]);
            }
            s.append(')');
            return s.toString();
        }
    }
}
