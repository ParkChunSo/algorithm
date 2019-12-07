public static int solution(String skill, String[] skill_trees) {
    int cnt = 0;
    for(String skillTree : skill_trees){
      ArrayList<Integer> order = new ArrayList<>();
      for(int i = 0 ; i < skill.length() ; i++){
        int idx = skillTree.indexOf(skill.charAt(i))
        if(idx == -1){
          order.add(30);
          continue;
        }
        order.add(idx);
      }

      int preOrder = order.get(0);
      boolean valid = true;
      for(int j = 1 ; j < order.size() ; j++) {
        if(preOrder > order.get(j)) {
          valid = false;
          break;
        }
        preOrder = order.get(j);
      }
      if(valid)
        cnt++;
    }

    return cnt;
  }