public class q1 {
    public static void main(String args[]) {
        // System.out.println("Your first argument is: " + args[0]);
        int sum = 0;
        int product = 1;
        int len = args.length;
        System.out.print(len + ",");
        for (int i = 0; i < len; i++) {

            sum += Integer.parseInt(args[i]);
            product *= Integer.parseInt(args[i]);
        }
        System.out.print(sum + ",");
        System.out.print(product);
    }
}