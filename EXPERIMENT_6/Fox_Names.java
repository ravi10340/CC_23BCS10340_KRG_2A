import java.util.*;

class Exp6 {
    public String solve(String[] words) {
        List<Integer>[] g = new ArrayList[26];
        for (int i = 0; i < 26; i++) g[i] = new ArrayList<>();

        int[] indeg = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    g[a.charAt(j) - 'a'].add(b.charAt(j) - 'a');
                    indeg[b.charAt(j) - 'a']++;
                    found = true;
                    break;
                }
            }
            if (!found && a.length() > b.length()) return "Impossible";
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.append((char) (u + 'a'));
            for (int v : g[u]) {
                if (--indeg[v] == 0) q.add(v);
            }
        }

        return res.length() == 26 ? res.toString() : "Impossible";
    }
}
