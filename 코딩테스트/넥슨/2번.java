public static int maxDifference(List<Integer> px) {
        // Write your code here
        if (px.size() == 1)
            return -1;

        int idx = 1;
        int maxVal = 0, minVal = px.get(0);
        int answer = -1;
        for( ; idx < px.size() ; idx++){
            if(px.get(idx) < minVal)
                minVal = px.get(idx);
            if(px.get(idx) > px.get(idx-1)) {
                maxVal = px.get(idx);
                answer = maxVal - minVal;
                break;
            }
        }
        for (; idx < px.size(); idx++) {
            if (px.get(idx) < minVal)
                minVal = px.get(idx);

            if (px.get(idx) <= maxVal)
                continue;

            maxVal = px.get(idx);
            answer = Math.max(answer, maxVal - minVal);
        }

        return answer;
    }