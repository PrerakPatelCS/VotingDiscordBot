package DiscordBot.Voter;

public class Ballot {
    
    String Name;
    private Ballot[] ballots;
    private int numBallots;
    private static final int GROW_AMOUNT = 4;
    private static final int FAIL_CONDITION = -1;
    public static String text;

    
    
    public Ballot() {
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
    
    private int find(Ballot ballot){
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
    

    
    public boolean remove(Ballot ballot){
        final int index = find(ballot);
        //System.out.println(index);
        if(index >= 0) {
            ballots[index] = null;
            numBallots--;
            return true;
        }
        return false;
    }
    
    private void shiftArray() {
        Ballot [] shiftedArray = new Ballot[ballots.length];
        int count = 0;
        for(int i = 0; i < ballots.length; i++) {
            if(ballots[i] != null) {
                shiftedArray[count] = ballots[i];
            }
            else{
                count--;
            }
            count++;
        }
        ballots = shiftedArray;
    }
    
    public void print(){
        shiftArray();
        for(int i = 0; i < ballots.length; i++) {
            if(ballots[i] == null) { 
                continue;
            }
            Event.getText(ballots[i].Name + '\n');
        }
    }
    
    
}
