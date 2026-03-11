import java.util.*;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        ArrayList<Integer> components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components.add(i);
                dfs(i);
            }
        }

        System.out.println(components.size() - 1);

        for (int i = 1; i < components.size(); i++) {
            System.out.println(components.get(i - 1) + " " + components.get(i));
        }
    }
}
