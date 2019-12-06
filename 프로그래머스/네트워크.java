  public static int solution(int n, int[][] computers) {
    int[] visit = new int[n];
    ArrayList<ArrayList<Integer>> path = new ArrayList<>();

    for(int i = 0 ; i< n ; i++)
      path.add(new ArrayList<>());

    for(int i = 0 ; i < n ; i++){
      for(int k = 0 ; k < n ; k++){
        if(i != k && computers[i][k] == 1)
          path.get(i).add(k);
      }
    }
    int answer = 0;
    for(int i = 0 ; i < n ; i++) {
      if(visit[i] == 1)
        continue;

      int startNode = i;
      Stack<Integer> dfs = new Stack<>();
      dfs.push(startNode);
      while (!dfs.empty()) {
        startNode = dfs.pop();
        visit[startNode] = 1;
        ArrayList<Integer> linked = path.get(startNode);
        for (int tmp : linked) {
          if (visit[tmp] != 1)
            dfs.push(tmp);
        }
      }
      answer++;
    }
    return answer;
  }