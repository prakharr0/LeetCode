package leetcode.random;

import java.util.Set;
import java.util.HashSet;

/**
 * LeetCode 1496: Path Crossing

 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north,
 * south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have
 * previously visited. Return false otherwise.

 * Input: path = "NES"
 * Output: false

 * Input: path = "NESWW"
 * Output: true
 * @author rathi.prakhar@outlook.com
 */

public class IsPathCrossing {

    /**
     * We start at (0,0) therefore my current position is stored as (0,0)
     * Maintain a set to see the positions that were visited before. Can store a string [0 + "-" + 0] to represent (0, 0).

     * current position can be an array s.t. [i, j].
     * When moving north --> [i + 1, j], south --> [i - 1, j], east --> [i, j + 1], and west --> [i, j - 1].

     * if the new position exists in the visited set as [i + "-" + j] return true;
     * else add in the set and proceed
     */
    public boolean isPathCrossing(String path) {
        if (path == null || path.length() < 1) return false;

        Set<String> coords = new HashSet<>();
        coords.add(0 + "-" + 0);

        // indices: 0 for N/S and 1 for E/W
        int[] current = new int[]{0, 0};

        for (char c: path.toCharArray()) {
            if (c == 'N') {
                current[0]++;
            }

            if (c == 'S') {
                current[0]--;
            }

            if (c == 'E') {
                current[1]++;
            }

            if (c == 'W') {
                current[1]--;
            }

            String currentPosition = current[0] + "-" + current[1];
            if (coords.contains(currentPosition)) return true;

            coords.add(currentPosition);
        }

        return false;
    }
}
