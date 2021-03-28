package DiscordBot.Voter;

public class Ballot {
    
    public String Name;
    private Category[] categories;
    private int numCategories;
    private static final int GROW_AMOUNT = 4;
    private static final int FAIL_CONDITION = -1;
    public static String text;

    
    
    public Ballot() {
        numCategories = 0;
        categories = new Category[GROW_AMOUNT];
    }
    
    
    
    public boolean add(Category category){
        if(find(category) != FAIL_CONDITION){
            return false;
        }
        numCategories++;
        if(numCategories > categories.length) {
            grow();
        }
        categories[numCategories - 1] = category;
        return true;
    }
    
    
    private void grow(){
        Category[] grow = new Category[categories.length + GROW_AMOUNT];
        for(int i = 0; i < categories.length; i++) {
            grow[i] = categories[i];
        }
        categories = grow;
    }
    
    public int find(Category category){
        int index = 0;
        for(int i = 0; i < categories.length; i++) {
            if(categories[i] == null){
                continue;
            }
            if(categories[i].Name.equals(category.Name)) {
                index = i;
                return index;
            }
        }
        index = FAIL_CONDITION;
        return index;

    }
    

    public void print(){
        for(int i = 0; i < categories.length; i++) {
            if(categories[i] == null) { 
                continue;
            }
            Event.getText(categories[i].Name + '\n');
        }
    }
    
    
}
