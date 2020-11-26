public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        BigInteger[] memo = new BigInteger[num + 1];
        BigInteger val = BigInteger.ONE;
        for (int i = 2; i < memo.length; i++) {
            val = val.multiply(BigInteger.TWO).add(BigInteger.ONE);
        }
        sb.append(val.toString()).append("\n");
        if (num <= 20) {
            moveHanoiTower(num, 1, 2, 3);
        }
        System.out.print(sb.toString());

    }

    private static void moveHanoiTower(int num, int from, int by, int to) {
        if (num == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            moveHanoiTower(num - 1, from, to, by);
            sb.append(from).append(" ").append(to).append("\n");
            moveHanoiTower(num - 1, by, from, to);
        }
    }
}