import java.util.*;

class Exp5 {
    static class Node {
        Node[] child = new Node[3];
        boolean end;
    }

    Node root = new Node();

    void insert(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) node.child[idx] = new Node();
            node = node.child[idx];
        }
        node.end = true;
    }

    boolean search(String s, Node node, int pos, int diff) {
        if (node == null) return false;
        if (pos == s.length()) return diff == 1 && node.end;

        int idx = s.charAt(pos) - 'a';
        for (int i = 0; i < 3; i++) {
            if (node.child[i] != null) {
                int nd = diff + (i == idx ? 0 : 1);
                if (nd <= 1 && search(s, node.child[i], pos + 1, nd)) return true;
            }
        }
        return false;
    }
}
