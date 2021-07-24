package Entities;

import java.util.*;

import FOSException.FoodException;
import FOSException.OrderException;
import lombok.Getter;

@Getter
public class Restraurant {
    String name;
    double rating;
    int max_no_orders;
    int current_orderr_count;
    private Set<Order> liveOrders=new LinkedHashSet<>();
    private HashMap<String, MenuItem> menu=new HashMap<>();

    public Restraurant(String name,
            double rating,
            int max_no_orders){
        this.name=name;
        this.rating=rating;
        this.max_no_orders=max_no_orders;
        liveOrders=new LinkedHashSet<>();
     menu=new HashMap<>();

    }
    public void addMenuItem(MenuItem item) throws FoodException {

        menu.put(item.name, item);
        return;
    }

    public void removeMenuItem(String itemName) throws FoodException {
        if (menu.get(itemName) != null) {
            throw new FoodException("No such menu item is present");
        }
        menu.remove(itemName);
    }

    public Order order(Order order) throws OrderException {
        if (current_orderr_count >= max_no_orders) {
            order.state = OrderState.CANCELLED;
            throw new OrderException("order Limit Exceeded");
        }
        current_orderr_count++;
        order.state = OrderState.ACCEPTED;
        liveOrders.add(order);
        completeOrder(order);
        return order;
    }
    public void completeOrder(Order order){
        current_orderr_count--;
        order.state = OrderState.COMPLETED;
        liveOrders.remove(order);
    }

    private boolean isCookingDone(Order order) {
        return true;
    }

    public boolean areItemsOderable(List<FoodItem> foodItems) {
        if (current_orderr_count >= max_no_orders) return false;

        for (FoodItem item : foodItems) {
            if (menu.get(item.name) == null) {
                return false;
            }
        }
        return true;
    }

}
