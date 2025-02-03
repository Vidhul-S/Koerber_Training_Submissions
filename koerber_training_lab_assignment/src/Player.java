public class Player {
    private int id;
    private String name;
    private int rank;
    private static int playerCount = 0;

    public Player() {
        playerCount++;
    }

    //What is this : •this • is pointer (ref) that point to current object
    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name, int rank) {
        this.id = ++playerCount;
        this.name = name;
        this.rank = rank;
    }
    public void printInfo(){
        System.out.println("Player:"+id+","+name+","+rank);
    }
    public static void printCount(){
        System.out.println(playerCount);
    }
}