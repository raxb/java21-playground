package abt.switch_expression;

import abt.sealed.*;

import static abt.switch_expression.Coin.TAILS;

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

        switchInstances(new Rectangle());
        switchInstances(new SemiCircleImpl2());
        switchInstances(new TwoDRhombus());
        switchInstances(new SemiCircle());

        switchEnumSealed(Coin.HEADS);
        switchEnumSealed(Coin.TAILS);

    }

    private static void switchExp(String[] args) {
        var day = switch (DAYS.valueOf(args[0])){
            case MONDAY, WEDNESDAY, THURSDAY -> "Work Maniac";
            case DAYS.TUESDAY -> "Planning";
            case DAYS d when d == DAYS.FRIDAY -> {
                if(args.length>1 && "meet".equalsIgnoreCase(args[1])) {
                    yield "Grooming on "+d.name();
                } else
                    yield "Party on "+d.name();
            }
            default -> """
        What work?
            "Isn't it a weekend?"
        """;
        };
        System.out.println(day);
    }

    private static void switchInstances(Shape shape){
        switch (shape){
            case null -> System.out.println("Invalid shape");
            case Square s -> s.draw();
            case Rectangle r -> r.draw();
            case Rhombus rhombus-> {
                System.out.println("Inside Rhombus case");
                rhombus.twoDDraw();
            }
            case Circle circle when circle instanceof SemiCircle -> {
                System.out.println("Inside Circle guarded SemiCircle case");
                circle.draw();
            }
            case Circle circle -> {
                System.out.println("Inside Circle case");
                circle.draw();
            }
        }

    }

    private static void switchEnumSealed(Currency currency){
        switch (currency){
            case Coin.HEADS -> System.out.println("HEADS");
            case null, default -> System.out.println("null currency or TAILS");
        }
    }
}
