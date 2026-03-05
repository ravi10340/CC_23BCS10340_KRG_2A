import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            String s = sc.next();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        String ans = "";
        int mx = 0;

        for(String k: map.keySet()){
            if(map.get(k) > mx){
                mx = map.get(k);
                ans = k;
            }
        }

        System.out.println(ans);
    }
}
