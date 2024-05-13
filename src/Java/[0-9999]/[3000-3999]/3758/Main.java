import java.io.*;
import java.util.*;

public class Main {
    static class Team {
        int score;
        int time;
        int trys;

        Team(int score, int time, int trys) {
            this.score = score;
            this.time = time;
            this.trys = trys;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[][] teams = new Team[n + 1][k + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < k + 1; j++) {
                    teams[i][j] = new Team(0, 0, 0);
                }
            }

            for (int i = 0; i < m; i++) {
                int time = i + 1;
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                Team team = teams[a][b];
                if (team.trys == 0) {
                    teams[a][b] = new Team(c, time, 1);
                } else {
                    if (team.score < c) {
                        teams[a][b].time = time;
                        teams[a][b].score = c;
                    }
                    teams[a][b].trys++;
                }
            }

            int ans = 1;
            int team_score = 0;
            int team_try = 0;
            int team_time = 0;
            for (int i = 1; i < k + 1; i++) {
                team_score += teams[t][i].score;
                team_try += teams[t][i].trys;
                team_time = Math.max(team_time, teams[t][i].time);
            }
            for (int i = 1; i < n + 1; i++) {
                if (i == t) continue;
                int temp_score = 0;
                int temp_try = 0;
                int temp_time = 0;
                for (int j = 1; j < k + 1; j++) {
                    temp_score += teams[i][j].score;
                    temp_try += teams[i][j].trys;
                    temp_time = Math.max(temp_time, teams[i][j].time);
                }
                if(team_score < temp_score) ans++;
                else if(team_score == temp_score){
                    if (team_try > temp_try) ans++;
                    else if(team_try == temp_try){
                        if (team_time > temp_try) ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}