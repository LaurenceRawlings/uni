
public class EdiblePlant {
    
    private String name;
    private boolean isFruit;
    private String colour;
    
    public EdiblePlant(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setColour(String colour){
        this.colour = colour;
    }
    
    public String getColour(){
        return colour;
    }
    
    public boolean isFruit(){
        return isFruit;
    }
    
    public void setFruit(boolean isFruit){
        this.isFruit = isFruit;
    }

}
