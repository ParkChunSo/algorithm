public static String[] solution(String[][] tickets) {
    HashMap<String, ArrayList<String>> path = new HashMap<>();

    for(String[] tmp : tickets){
      if(path.get(tmp[0]) == null)
        path.put(tmp[0], new ArrayList<>());

      path.get(tmp[0]).add(tmp[1]);
    }
    ArrayList<String> answer = new ArrayList<>();
    Stack<String> dfs = new Stack<>();
    ArrayList<String> icnPath = path.get("ICN");
    path.put("ICN", new ArrayList<>());
    answer.add("ICN");
    Collections.sort(icnPath);

    for (int i = icnPath.size() - 1 ; i >= 0 ; i--)
      dfs.push(icnPath.get(i));

    while(!dfs.empty()){
      String startPoint = dfs.pop();
      answer.add(startPoint);
      if(path.get(startPoint) == null)
        continue;

      ArrayList<String> endPoint = path.get(startPoint);
      path.put(startPoint, new ArrayList<>());
      Collections.sort(icnPath);
      for (int i = endPoint.size() -1 ; i >= 0 ; i--)
        dfs.push(endPoint.get(i));
    }

    return answer.toArray(new String[0]);
  }