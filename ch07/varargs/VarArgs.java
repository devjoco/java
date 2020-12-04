public class VarArgs {
    public static void main(String[] args) {
        System.out.println(sum("Numbers 1-4", 1,2,3,4));
    }

    public static int sum(String desc, int... vals) {
        System.out.println("Summing " + desc);
        int ans = 0;
        for(int val : vals) 
            ans += val;
        return ans;
    }
}
