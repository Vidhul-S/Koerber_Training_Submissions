//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String args[]){
        Player p1 = new Player("Vid",4);
        Player p2 = new Player("Lay",2);
        Player p3= new Player();
        p3.setName("Dud");
        p3.setRank(3);
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();
        Player.printCount();
    }
}