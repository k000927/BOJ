import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static IP mask;

    static class IP {
        String a;
        String b;
        String c;
        String d;

        // 10진수 입력
        IP(String address) {
            String[] split = address.split("\\.");
            a = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(split[0]))));
            b = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(split[1]))));
            c = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(split[2]))));
            d = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(split[3]))));
        }

        // 2진수 입력
        IP(String address, boolean flag) {
            a = address.substring(0, 8);
            b = address.substring(8, 16);
            c = address.substring(16, 24);
            d = address.substring(24, 32);
        }

        public String toDecAddress() {
            return Integer.parseInt(a.replace("X", "0"), 2) + "." +
                    Integer.parseInt(b.replace("X", "0"), 2) + "." +
                    Integer.parseInt(c.replace("X", "0"), 2) + "." +
                    Integer.parseInt(d.replace("X", "0"), 2);
        }

        @Override
        public String toString() {
            return a + b + c + d;
        }
    }

    static String getMask(IP ipA, IP ipB) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            if (flag) sb.append("X");
            else if (ipA.toString().charAt(i) == ipB.toString().charAt(i)) {
                sb.append(ipA.toString().charAt(i));
            } else {
                flag = true;
                sb.append("X");
            }
        }

        return sb.toString();
    }

    static void getNetworkMask() {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            if (mask.toString().charAt(i) == 'X') sb.append("0");
            else sb.append("1");
        }

        String address = sb.toString();

        sb = new StringBuilder();
        sb.append(Integer.parseInt(address.substring(0, 8), 2)).append(".")
                .append(Integer.parseInt(address.substring(8, 16), 2)).append(".")
                .append(Integer.parseInt(address.substring(16, 24), 2)).append(".")
                .append(Integer.parseInt(address.substring(24, 32), 2));
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(br.readLine());
            System.out.println("255.255.255.255");
            System.exit(0);
        }

        IP ipA = new IP(br.readLine());
        IP ipB = new IP(br.readLine());

        mask = new IP(getMask(ipA, ipB), true);

        for (int i = 0; i < n - 2; i++) {
            IP temp = new IP(br.readLine());
            mask = new IP(getMask(mask, temp), false);
        }

        System.out.println(mask.toDecAddress());
        getNetworkMask();
    }
}