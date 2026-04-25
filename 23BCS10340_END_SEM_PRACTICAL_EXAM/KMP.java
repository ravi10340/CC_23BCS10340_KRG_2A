public class kmp {
    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0; 
        lps[0] = 0;  

        int i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);

        int i = 0; 
        int j = 0; 

        boolean found = false;

        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                found = true;
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }

    
    public static void main(String[] args) {
        String txt = "ABCAB";
        String pat = "AB";

        System.out.println("Text: " + txt);
        System.out.println("Pattern: " + pat);

        KMPSearch(pat, txt);
    }
}

