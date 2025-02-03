package day9LabAssignment.java10_17;

public class B_SwitchEnhancement {
    public static void main(String[] args) {
        //java 6 u can only use char or int long or enum switch
        //java 7: string can also be used
        //java 13+ to simply the syntax of switch with ->
        // case with ability to return using yield


        enum WeekDay {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        WeekDay day = WeekDay.TUESDAY;
        switch (day) {
            case TUESDAY,THURSDAY,SATURDAY -> System.out.println("no meeting!");
            case MONDAY,WEDNESDAY,FRIDAY -> System.out.println("Let's meet!");

            case SUNDAY ->
                System.out.println("Let's meet (although Sunday should be a free day, man!)!");

            default -> System.out.println("Do I really need this?!");

        }


    }
}
