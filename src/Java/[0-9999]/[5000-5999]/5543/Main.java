import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int burger = Integer.parseInt(br.readLine());
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        System.out.println(burger + Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())) - 50);
    }
}