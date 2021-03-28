package DiscordBot.Voter;

public class BigFolder {
    public String Name;
    private Ballot[] ballots;
    private int numBallots;
    private static final int GROW_AMOUNT = 4;
    private static final int FAIL_CONDITION = -1;
    public static String text;
    
    public BigFolder() {
        numBallots = 0;
        ballots = new Ballot[GROW_AMOUNT];
    }
    
    public boolean add(Ballot ballot){
        if(find(ballot) != FAIL_CONDITION){
            return false;
        }
        numBallots++;
        if(numBallots > ballots.length) {
            grow();
        }
        ballots[numBallots - 1] = ballot;
        return true;
    }
    
    private void grow(){
        Ballot[] grow = new Ballot[ballots.length + GROW_AMOUNT];
        for(int i = 0; i < ballots.length; i++) {
            grow[i] = ballots[i];
        }
        ballots = grow;
    }
    
    public int find(Ballot ballot){
        int index = 0;
        for(int i = 0; i < ballots.length; i++) {
            if(ballots[i] == null){
                continue;
            }
            if(ballots[i].Name.equals(ballot.Name)) {
                index = i;
                return index;
            }
        }
        index = FAIL_CONDITION;
        return index;

    }
    
    public void print(){
        for(int i = 0; i < ballots.length; i++) {
            if(ballots[i] == null) { 
                continue;
            }
            Event.getText(ballots[i].Name + '\n');
        }
    }
    
    
    
    
    
    
}
