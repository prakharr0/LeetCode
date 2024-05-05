package random;

public class TowerOfHanoi {
    public int towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int x = towerOfHanoi(n-1, from, aux, to);
        int y = towerOfHanoi(n-1, aux, to, from);

        return x + y + 1;
    }
}
