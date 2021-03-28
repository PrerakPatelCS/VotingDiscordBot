package DiscordBot.Voter;

public class Candidates {
    public String Name;
    public int numFirstPick;
    public int numSecondPick;
    public int numThirdPick;
    
    public Candidates[] candidate = new Candidates[GROW_AMOUNT];
    public int numCandidates = 0;
    public static final int GROW_AMOUNT = 4;
    public static final int FAIL_CONDITION = -1;

    public boolean add(String Name){
        if(find(Name) != FAIL_CONDITION){
            return false;
        }
        numCandidates++;
        if(numCandidates > candidate.length) {
            grow();
        }
        candidate[numCandidates - 1].Name = Name;
        return true;
    }
    private void grow(){
        Candidates[] grow = new Candidates[candidate.length + GROW_AMOUNT];
        for(int i = 0; i < candidate.length; i++) {
            grow[i] = candidate[i];
        }
        candidate = grow;
    }
    
    private int find(String Name){
        int index = 0;
        for(int i = 0; i < candidate.length; i++) {
            if(candidate[i] == null){
                continue;
            }
            if(candidate[i].Name.equals(Name)) {
                index = i;
                return index;
            }
        }
        index = FAIL_CONDITION;
        return index;

    }
    
    public void print(){
        for(int i = 0; i < candidate.length; i++) {
            if(candidate[i] == null) { 
                continue;
            }
            System.out.println(candidate[i].Name + '\n');
        }
    }
}
