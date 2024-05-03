import java.io.*;
import java.util.*;

public class Main {
    static class Team {
        int players;
        int score = 0;
        int five = 0;
        int index = 0;

        Team(int players) {
            this.players = players;
        }

        Boolean compare(Team t) {
            if (this.players != 6) return false;
            if (t.players != 6) return true;
            if (this.score < t.score) return true;
            if (this.score == t.score && this.five < t.five) return true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] players = new int[n];
            Team[] team = new Team[n];
            for (int i = 0; i < n; i++) {
                team[i] = new Team(0);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int team_n = Integer.parseInt(st.nextToken());
                players[i] = team_n;
                team[team_n].players++;
            }

            int score = 1;
            for (int i = 0; i < n; i++) {

                int team_n = players[i];
                if (team[team_n].players != 6) continue;
                int idx = team[team_n].index;
                if (idx < 4) {
                    team[team_n].score += score++;
                    team[team_n].index++;
                } else if (idx == 4) {
                    team[team_n].five = score++;
                    team[team_n].index++;
                } else score++;
            }

            int ans = 1;
            for (int i = 2; i < n; i++) {
                if (team[ans].compare(team[i])) continue;
                ans = i;
            }
            System.out.println(ans);
        }
    }
}