package abt.switch_expression;
/*
https://openjdk.org/jeps/441
 */
public class SwitchExpMain {
    enum DAYS {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
    public static void main(String[] args) {
        switchExp(new String[]{"MONDAY"});
        switchExp(new String[]{"FRIDAY"});
        switchExp(new String[]{"FRIDAY", "meet"});
        switchExp(new String[]{"SATURDAY"});
    }

    private static void switchExp(String[] args) {
        var day = switch (DAYS.valueOf(args[0])){
            case MONDAY, WEDNESDAY, THURSDAY -> "Work Maniac";
            case TUESDAY -> "Planning";
            case FRIDAY -> {
                if(args.length>1 && "meet".equalsIgnoreCase(args[1])) {
                    yield "Grooming";
                } else
                    yield "Party";
            }
            default -> """
        What work?
            "Isn't it a weekend?"
        """;
        };
        System.out.println(day);
    }
}
