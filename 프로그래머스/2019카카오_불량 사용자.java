import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        int answer = solution.solution(user_id, banned_id);
        System.out.println(answer);
    }

    private boolean[] visited;
    public List<List<String>> combinationList = new ArrayList<>();
    public String[] userList;
    public String[] bannedList;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        this.userList = user_id;
        this.bannedList = banned_id;
        return dp(0);
    }

    public int dp(int idx) {
        if (idx == bannedList.length && isNewList())
            return 1;
        if (idx == bannedList.length)
            return 0;

        int answer = 0;
        for (int i = 0; i < userList.length; i++) {
            if (equals(userList[i], bannedList[idx])
                    && !visited[i]) {
                visited[i] = true;
                answer += dp(idx + 1);
                visited[i] = false;
            }
        }
        return answer;
    }

    public boolean isNewList() {
        boolean flag = false;
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                tmp.add(userList[i]);
        }

        for (List<String> list : combinationList) {
            for (String s : tmp) {
                if (!list.contains(s)) {
                    flag = true;
                }
            }
            if (flag)
                flag = false;
            else
                return false;
        }

        combinationList.add(tmp);
        return true;
    }

    public boolean equals(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length())
            return false;
        for (int i = 0; i < user_id.length(); i++) {
            if (user_id.charAt(i) != banned_id.charAt(i)
                    && banned_id.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}