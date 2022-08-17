package app_classes;

/**
 *
 * @author dell
 */
public class Ingredients {
    private int ing_id;
    private String name;
    private int qty;
    private String image;
    private String description;
    
    public Ingredients(){}

    public Ingredients(int ing_id, String name, int qty, String description) {
        this.ing_id = ing_id;
        this.name = name;
        this.qty = qty;
        this.description = description;
    }

    public Ingredients(String name, int qty, String description) {
        this.name = name;
        this.qty = qty;
        this.description = description;
    }

    
    
    public int getIng_id() {
        return ing_id;
    }

    public void setIng_id(int ing_id) {
        this.ing_id = ing_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return   name ;
    }
    
    
}
