import java.util.*;

class Pair {
    int node, wt;

    Pair(int n, int w) {
        node = n;
        wt = w;
    }
}

public class Main {
    static int prims(int n, List<List<Pair>> adj) {
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (vis[p.node]) continue;

            vis[p.node] = true;
            sum += p.wt;

            for (Pair it : adj.get(p.node)) {
                if (!vis[it.node]) {
                    pq.add(it);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 10));
        adj.get(1).add(new Pair(0, 10));

        adj.get(0).add(new Pair(2, 6));
        adj.get(2).add(new Pair(0, 6));

        adj.get(0).add(new Pair(3, 5));
        adj.get(3).add(new Pair(0, 5));

        adj.get(2).add(new Pair(3, 4));
        adj.get(3).add(new Pair(2, 4));

        adj.get(1).add(new Pair(3, 15));
        adj.get(3).add(new Pair(1, 15));

        System.out.println(prims(n, adj));
    }
}
