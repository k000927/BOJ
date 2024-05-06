import java.io.*;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        String word;
        int cnt;

        Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word w) {
            if (this.cnt > w.cnt) return -1;
            else if (this.cnt < w.cnt) return 1;

            if (this.word.length() > w.word.length()) return -1;
            else if (w.word.length() > this.word.length()) return 1;

            return this.word.compareTo(w.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Word> voca = new PriorityQueue<>();
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if(word.length() < m) continue;
            if(hash.containsKey(word)){
                hash.replace(word, hash.get(word) + 1);
            }
            else{
                hash.put(word, 1);
            }
        }
        for (String s : hash.keySet()) {
            voca.add(new Word(s, hash.get(s)));
        }
        while(!voca.isEmpty()){
            bw.write(voca.poll().word + '\n');
        }
        bw.flush();
    }
}