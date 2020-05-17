package qcm.utils;

public class ArgumentCheck {

    public final int ARGUMENTS_LENGTH;

    public ArgumentCheck(int ARGUMENTS_LENGTH) {
        this.ARGUMENTS_LENGTH = ARGUMENTS_LENGTH;
    }

    public void check(String [] args) {
        if(args.length < ARGUMENTS_LENGTH) {
            System.out.println(
                    args.length + " out of " + ARGUMENTS_LENGTH + " argument(s).\n" +
                            "You need " + (ARGUMENTS_LENGTH - args.length) + " more argument(s) to run this program."
            );
            System.exit(1);
        }
        else if(args.length > ARGUMENTS_LENGTH) {
            System.out.println(
                    "Too much arguments.\n" +
                            "This program requires only " + ARGUMENTS_LENGTH + " argument(s).\n" +
                            "You've passed " + args.length + " instead.\n"
            );
            System.exit(1);
        }
    }
}
