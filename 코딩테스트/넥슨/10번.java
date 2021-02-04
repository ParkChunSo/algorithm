static final String strUrl = "https://jsonmock.hackerrank.com/api/countries/search?name=%s";
    static final String page = "&page=%s";
    static boolean isFinish = false;

    static int getCountries(String s, int p) throws Exception {
        String response = null;
        int answer = 0, pageNum = 1;
        while(!isFinish) {
            try {
                String string = String.format(strUrl, s) + String.format(page, pageNum);
                URL url = new URL(string);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
                con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
                con.setRequestMethod("GET");

                StringBuilder sb = new StringBuilder();
                if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), "utf-8"));
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    br.close();
                    response = sb.toString();
                } else {
                    System.out.println(con.getResponseMessage());
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            answer += count(response, p);
            pageNum++;
        }
        return answer;
    }

    private static int count(String json, int p){
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try{
            obj = (JSONObject) parser.parse(json);
        }catch (Exception e){
            e.printStackTrace();
        }
        int cnt = 0;
        JSONArray data = (JSONArray)obj.get("data");
        if(data.size() == 0) {
            isFinish = true;
            return 0;
        }

        for (Object datum : data) {
            JSONObject o = (JSONObject) datum;
            if (Integer.parseInt(o.get("population").toString()) > p) {
                cnt++;
            }
        }

        return cnt;
    }