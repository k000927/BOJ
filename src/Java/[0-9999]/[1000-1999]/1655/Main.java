import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (minHeap.isEmpty()) {
                minHeap.offer(temp);
                bw.write(minHeap.peek() + "\n");
                continue;
            } else if (maxHeap.isEmpty()) {
                if (minHeap.peek() > temp) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                } else maxHeap.offer(temp);
                bw.write(minHeap.peek() + "\n");
                continue;
            }

            int min = minHeap.peek();
            int max = maxHeap.peek();

            if (temp > max) {
                if (minHeap.size() <= maxHeap.size()) {
                    maxHeap.poll();
                    minHeap.offer(max);
                }
                maxHeap.offer(temp);
            } else if (temp >= min && temp <= max) {
                if (minHeap.size() > maxHeap.size())
                    maxHeap.offer(temp);
                else
                    minHeap.offer(temp);
            } else {
                if (minHeap.size() > maxHeap.size()) {
                    minHeap.poll();
                    maxHeap.offer(min);
                }
                minHeap.offer(temp);
            }
            bw.write(minHeap.peek() + "\n");
        }

        bw.flush();
    }

}