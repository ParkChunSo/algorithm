final int MOD = 10007;
    Map<String, List<String>> path = new HashMap<>();

    public int solution(String depar, String hub, String dest, String[][] roads) {
        for (String[] road : roads) {
            if (path.get(road[0]) == null) {
                path.put(road[0], new ArrayList<>());
            }
            path.get(road[0]).add(road[1]);
        }

        int first = dfs(depar, hub);
        int second = dfs(hub, dest);
        return first * second;
    }

    public int dfs(String src, String dest) {
        if (src.equals(dest))
            return 1;
        if(path.get(src) == null)
            return 0;

        int answer = 0;
        for (String s : path.get(src)) {
            answer += dfs(s, dest);
        }
        return answer % MOD;
    }