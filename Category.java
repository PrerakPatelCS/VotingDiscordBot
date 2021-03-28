package DiscordBot.Voter;

public class Category {
    
    
    public String Name;
    private People[] people;
    private int numPeople;
    private static final int GROW_AMOUNT = 4;
    private static final int FAIL_CONDITION = -1;
    public static String text;

    
    
    public Category() {
        numPeople = 0;
        people = new People[GROW_AMOUNT];
    }
    
    
    
    public boolean add(People ballot){
        if(find(ballot) != FAIL_CONDITION){
            return false;
        }
        numPeople++;
        if(numPeople > people.length) {
            grow();
        }
        people[numPeople - 1] = ballot;
        return true;
    }
    
    
    private void grow(){
        People[] grow = new People[people.length + GROW_AMOUNT];
        for(int i = 0; i < people.length; i++) {
            grow[i] = people[i];
        }
        people = grow;
    }
    
    private int find(People ballot){
        int index = 0;
        for(int i = 0; i < people.length; i++) {
            if(people[i] == null){
                continue;
            }
            if(people[i].Name.equals(ballot.Name)) {
                index = i;
                return index;
            }
        }
        index = FAIL_CONDITION;
        return index;

    }
    
    public void print(){
        for(int i = 0; i < people.length; i++) {
            if(people[i] == null) { 
                continue;
            }
            Event.getText(people[i].Name + '\n');
        }
    }
    
}
