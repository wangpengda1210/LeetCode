import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Character> players = new LinkedList<>();
        int radiantCount = 0;
        int radiantBan = 0;
        int direCount = 0;
        int direBan = 0;

        for (char c : senate.toCharArray()) {
            players.add(c);
            if (c == 'D') {
                direCount++;
            } else {
                radiantCount++;
            }
        }

        while (direCount > 0 && radiantCount > 0) {
            char next = players.poll();
            if (next == 'D') {
                if (direBan > 0) {
                    direBan--;
                    direCount--;
                } else {
                    radiantBan++;
                    players.add('D');
                }
            } else {
                if (radiantBan > 0) {
                    radiantBan--;
                    radiantCount--;
                } else {
                    direBan++;
                    players.add('R');
                }
            }
        }

        return direCount > 0 ? "Dire" : "Radiant";
    }
}
