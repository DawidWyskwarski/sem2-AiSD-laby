import java.util.HashMap;
import java.util.Map;

class BaseIngredient{
    
    private String name;

    public BaseIngredient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": ";
    }
}

class Dish{

    private String name;
    Map<BaseIngredient,Integer> ingredients;
    Map<Dish,Integer> dishes;

    public Dish(String name){
        this. name = name;
        ingredients = new HashMap<>();
        dishes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addIngredients(BaseIngredient b, int quantity){
        ingredients.put(b, quantity);
    }

    public void addDishes(Dish d, int quantity){
        dishes.put(d, quantity);
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public Map<BaseIngredient,Integer> base(int multilier){

        Map<BaseIngredient,Integer> list = new HashMap<>();

        for (Map.Entry<BaseIngredient,Integer> element : ingredients.entrySet()) {
            BaseIngredient key = element.getKey();
            Integer value = element.getValue() * multilier;
            list.merge(key, value, Integer::sum);
        }

        for (Map.Entry<Dish,Integer> element : dishes.entrySet()) {
            Dish dish = element.getKey();
            Integer value = element.getValue() * multilier;
            Map<BaseIngredient, Integer> dishBase = dish.base(value);

            for (Map.Entry<BaseIngredient, Integer> baseEntry : dishBase.entrySet()) {
                BaseIngredient key = baseEntry.getKey();
                Integer baseValue = baseEntry.getValue();
                list.merge(key, baseValue, Integer::sum);
            }
        }

        return list;
    }
}

public class App { 
    public static void main(String[] args) throws Exception {

        Map <Dish,Integer> list = new HashMap<>();
        
        // obiad drugie danie
        BaseIngredient potatos = new BaseIngredient("Potats");
        BaseIngredient breadCrapms = new BaseIngredient("Bread cramps");
        BaseIngredient meat = new BaseIngredient("Beef");
        BaseIngredient cucumber = new BaseIngredient("Cucumber");
        BaseIngredient lemon = new BaseIngredient("Lemon juice");
        BaseIngredient cream = new BaseIngredient("Cream");

        Dish salad = new Dish("salad");
        Dish cucumber_salad = new Dish("Cucumber salad");
        Dish schnitzel = new Dish("Schnitzel");
        Dish diner = new Dish("Diner");

        cucumber_salad.addIngredients(cream, 100); // ml
        cucumber_salad.addIngredients(lemon, 50); // ml

        salad.addDishes(cucumber_salad, 2); // servings
        salad.addIngredients(cucumber, 3); // whole 3 cucumbers

        schnitzel.addIngredients(breadCrapms, 50); //g
        schnitzel.addIngredients(meat, 200); //g

        diner.addDishes(salad, 2); //servings
        diner.addDishes(schnitzel, 2); //servings
        diner.addIngredients(potatos, 125); //g

        list.put(diner, 4);

        //pizza
        Dish dough = new Dish("Dough");
        BaseIngredient yeast = new BaseIngredient("Yeast");
        BaseIngredient water = new BaseIngredient("Water");
        BaseIngredient sugar = new BaseIngredient("Sugar");
        BaseIngredient flour = new BaseIngredient("flour");
        BaseIngredient salt = new BaseIngredient("Salt");
        BaseIngredient oil = new BaseIngredient("Oil");

        dough.addIngredients(yeast, 25);
        dough.addIngredients(water,150);
        dough.addIngredients(sugar, 3);
        dough.addIngredients(flour, 250);
        dough.addIngredients(salt,5);
        dough.addIngredients(oil, 5);

        Dish pizza = new Dish("Pizza");
        
        Dish tomatoSouce = new Dish("Tomato souce");
        BaseIngredient tomatoes = new BaseIngredient("Tomatoes");
        tomatoSouce.addIngredients(tomatoes, 30);

        BaseIngredient oregano = new BaseIngredient("Oregano");
        BaseIngredient mozzarella = new BaseIngredient("Mozzarella");
        BaseIngredient ham = new BaseIngredient("Ham");

        pizza.addDishes(dough, 1);
        pizza.addDishes(tomatoSouce, 1);
        pizza.addIngredients(oregano, 5);
        pizza.addIngredients(mozzarella, 150);
        pizza.addIngredients(ham, 100);
        pizza.addIngredients(cucumber, 2);

        list.put(pizza, 2);

        Map<BaseIngredient,Integer> mapa = new HashMap<>();

        for (Map.Entry<Dish,Integer> element : list.entrySet()) {
            Map<BaseIngredient,Integer> baseMap = element.getKey().base(element.getValue());
            
            for (Map.Entry<BaseIngredient, Integer> baseEntry : baseMap.entrySet()) {
                BaseIngredient key = baseEntry.getKey();
                Integer baseValue = baseEntry.getValue();
                mapa.merge(key, baseValue, Integer::sum);
            }
        }

        System.out.println(mapa);
        

    }
}
