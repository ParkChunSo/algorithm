public static void main(String[] args) {
        Scanner a  = new Scanner(System.in);
        float num3 = a.nextInt();
        float k1 = a.nextInt();
        float k2 = a.nextInt();

        double tempNum = 0;
        tempNum = (k1)*(k1) + (k2)*(k2);
        if ( tempNum < (num3*num3) ) {
            System.out.println("점 ("+k1+","+k2+")는 원 안에 있다.");
        }else {
            System.out.println("점 ("+k1+","+k2+")는 원 안에 없다.");
        }
    }