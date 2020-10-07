static int makeAnagram(String a, String b) {
        int[] arrA = new int[26];
        int[] arrB = new int[26];
        
        for(int i = 0 ; i < a.length() ; i++){
            arrA[a.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < b.length() ; i++){
            arrB[b.charAt(i) - 'a']++;
        }
        int answer = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(arrA[i] == arrB[i]){
                continue;
            }
            answer += Math.abs(arrA[i] - arrB[i]);
        }
        return answer;

    }