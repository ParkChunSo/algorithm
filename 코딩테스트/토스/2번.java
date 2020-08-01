public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");

        if(nums.length != 6) {
            System.out.println(false);
        }else {
            boolean isTrue = true;
            for (int i = 1; i < nums.length; i++) {
                if (!checkValidation(Integer.parseInt(nums[i - 1]), Integer.parseInt(nums[i]))) {
                    isTrue = false;
                    break;
                }
            }
            System.out.println(isTrue);
        }
    }

    //숫자가 1 ~ 45인지, 오름차순인지
    public static boolean checkValidation(int before, int now) {
        return before > 0 && before < 46 && now > 0 && now < 46
                && before < now;
    }
}
