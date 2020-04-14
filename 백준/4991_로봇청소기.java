import java.util.*;

public class Main {
    static final int CLEAN = 0, DIRTY = 1, STUFF = 2, START = 3;
    static int w, h;
    static int[][] map;
    static int[][] distance;
    static LinkedList<Pair> list;
    static boolean[] visited;
    static Pair start;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Pair {
        int y;
        int x;

        public Pair() {
        }

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] arr = sc.nextLine().split(" ");
            w = Integer.parseInt(arr[0]);
            h = Integer.parseInt(arr[1]);
            if (w == 0 && h == 0)
                break;

            map = new int[h][w];
            list = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                String str = sc.nextLine();
                for (int k = 0; k < str.length(); k++) {
                    switch (str.charAt(k)) {
                        case '*':
                            map[i][k] = DIRTY;
                            list.add(new Pair(i, k));
                            break;
                        case 'x':
                            map[i][k] = STUFF;
                            break;
                        case 'o':
                            map[i][k] = CLEAN;
                            start = new Pair(i, k);
                            break;
                    }
                }
            }
            list.addFirst(start);
            visited = new boolean[list.size()];
            distance = new int[list.size()][list.size()];
            boolean flag = false;
            for (int i = 0; i < distance.length; i++) {
                for (int k = i + 1; k < distance.length; k++) {
                    int tmp = howFar(list.get(i), list.get(k));
                    if (tmp == Integer.MAX_VALUE) {
                        flag = true;
                        break;
                    }
                    distance[i][k] = tmp;
                    distance[k][i] = tmp;
                }
                if (flag)
                    break;
            }
            if (flag) {
                System.out.println(-1);
                continue;
            }
            System.out.println(dfs(0));
        }
    }

    public static int dfs(int idx) {
        int answer = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                flag = true;
                visited[i] = true;
                answer = Math.min(answer, dfs(i) + distance[idx][i]);
                visited[i] = false;
            }
        }

        if (!flag)
            return 0;
        return answer;
    }

    public static int howFar(Pair source, Pair destination) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        queue.offer(source);
        visited[source.y][source.x] = true;

        boolean flag = false;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair poll = queue.poll();
                if (poll.y == destination.y && poll.x == destination.x) {
                    flag = true;
                    break;
                }

                for (int k = 0; k < dy.length; k++) {
                    int y = poll.y + dy[k];
                    int x = poll.x + dx[k];
                    if (y >= 0 && y < h && x >= 0 && x < w && !visited[y][x] && map[y][x] != STUFF) {
                        visited[y][x] = true;
                        queue.offer(new Pair(y, x));
                    }
                }
            }
            if (flag)
                break;
            distance++;
        }
        if (!flag)
            return Integer.MAX_VALUE;

        return distance;
    }
}