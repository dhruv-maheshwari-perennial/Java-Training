package Java_Generics;

public class Generic_01 {
    public static void main(String[] args) {
        FootballPlayer fp = new FootballPlayer("Dhruv");
        FootballPlayer fp2 = new FootballPlayer("Gordon");
        BaseballPlayer bp = new BaseballPlayer("Kartik");
        CricketPlayer cp = new CricketPlayer("Dhoni");

        Team<FootballPlayer> myFootBallTeam = new Team<>("My FootBall Team");
        myFootBallTeam.addPlayer(fp);
//        System.out.println(myFootBallTeam.numPlayers());

        Team<BaseballPlayer> myBaseBallTeam = new Team<>("My BaseBall Team");
        myBaseBallTeam.addPlayer(bp);
//        System.out.println(myBaseBallTeam.numPlayers());

        Team<CricketPlayer> brokenTeam = new Team<>("My Cricket Team");
        brokenTeam.addPlayer(cp);
//        System.out.println(brokenTeam.numPlayers());

        Team<FootballPlayer> myFootBallTeam1 = new Team<>("My FootBall Team1");
        myFootBallTeam1.addPlayer(fp2);

        Team<FootballPlayer> myFootBallTeam2 = new Team<>("My FootBall Team2");
        Team<FootballPlayer> myFootBallTeam3 = new Team<>("My FootBall Team3");

        myFootBallTeam2.matchResult(myFootBallTeam3, 1, 0);
        myFootBallTeam2.matchResult(myFootBallTeam, 2, 4);

        myFootBallTeam.matchResult(myFootBallTeam3, 2, 1);
//        myFootBallTeam.matchResult(myBaseBallTeam, 1, 1);

        System.out.println("Rankings");
        System.out.println(myFootBallTeam.getName() + ": " + myFootBallTeam.ranking());
        System.out.println(myFootBallTeam1.getName() + ": " + myFootBallTeam1.ranking());
        System.out.println(myFootBallTeam2.getName() + ": " + myFootBallTeam2.ranking());
        System.out.println(myFootBallTeam3.getName() + ": " + myFootBallTeam3.ranking());

        System.out.println(myFootBallTeam.compareTo(myFootBallTeam1));
        System.out.println(myFootBallTeam.compareTo(myFootBallTeam2));
        System.out.println(myFootBallTeam.compareTo(myFootBallTeam3));

        System.out.println(myFootBallTeam1.compareTo(myFootBallTeam));
        System.out.println(myFootBallTeam1.compareTo(myFootBallTeam2));
        System.out.println(myFootBallTeam1.compareTo(myFootBallTeam3));
    }
}
