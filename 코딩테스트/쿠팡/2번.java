    Kiosk[] kiosks;
    public int solution(int n, String[] customers) {
        kiosks = new Kiosk[n+1];
        for(int i = 1 ; i < kiosks.length ; i++){
            kiosks[i] = new Kiosk();
        }
        for(String customer : customers){
            StringTokenizer st = new StringTokenizer(customer);
            String[] date = st.nextToken().split("/");
            String[] time = st.nextToken().split(":");
            String duration = st.nextToken();
            LocalDateTime localDateTime = LocalDateTime.of(
                    2020,
                    Integer.parseInt(date[0]),
                    Integer.parseInt(date[1]),
                    Integer.parseInt(time[0]),
                    Integer.parseInt(time[1]),
                    Integer.parseInt(time[2]));
            int idx = findKiosk(localDateTime);
            kiosks[idx].cnt++;
            kiosks[idx].endTime = localDateTime.plusMinutes(Integer.parseInt(duration));
        }
        int idx = 1;
        for(int i = 2 ; i < kiosks.length ; i++){
            if(kiosks[i].cnt > kiosks[idx].cnt){
                idx = i;
            }
        }
        return kiosks[idx].cnt;
    }

    private int findKiosk(LocalDateTime customer) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i < kiosks.length ; i++){
            if(kiosks[i].endTime == null)
                return i;
            if(customer.isAfter(kiosks[i].endTime))
                queue.offer(i);
        }
        if(queue.size() == 1)
            return queue.poll();
        else if(queue.size() > 1){
            return firstCase(queue, customer);
        } else{
            return secondCase(customer);
        }
    }

    private int firstCase(Queue<Integer> queue, LocalDateTime customer){
        int idx = 0;
        long maxWaiting = 0;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            long seconds = Duration.between(kiosks[poll].endTime, customer).getSeconds();
            if(seconds > maxWaiting){
                idx = poll;
                maxWaiting = seconds;
            }
        }
        return idx;
    }
    private int secondCase(LocalDateTime customer){
        int idx = 0;
        long minWaiting = Long.MAX_VALUE;
        for(int i = 1; i < kiosks.length ; i++){
            long seconds = Duration.between(customer, kiosks[i].endTime).getSeconds();
            if(seconds < minWaiting){
                idx = i;
                minWaiting = seconds;
            }
        }
        return idx;
    }

    class Kiosk{
        int cnt;
        LocalDateTime endTime;

        public Kiosk() {
            this.cnt = 0;
        }
    }
