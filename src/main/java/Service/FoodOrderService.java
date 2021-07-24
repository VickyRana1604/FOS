package Service;

import FOSException.FoodException;
import Entities.MenuItem;
import Entities.Order;
import Entities.Restraurant;
import FOSException.OrderException;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class FoodOrderService {

    HashMap<String, Restraurant> allRestraurants = new HashMap<>();
    List<Restraurant> restraurants = new ArrayList<>();

    public String onboardRestraurant(Restraurant restraurant) throws FoodException {
        if (allRestraurants.get(restraurant.getName()) != null) {
            throw new FoodException("Restro duplicate");
        }
        allRestraurants.putIfAbsent(restraurant.getName(), restraurant);
        restraurants.add(restraurant);
        return "restraurant added successfully";
    }

    public String updateRestraurant(String restroName, MenuItem item) throws FoodException {
        if (allRestraurants.get(restroName) != null) {
            throw new FoodException("Reestro not found");
        }
        allRestraurants.get(restroName).addMenuItem(item);
        return "restro is updated successfully";
    }

    public Restraurant orderFood(Order order) throws OrderException {
        Restraurant restraurant = order.getSelectionStrategy().selectRestraurant(order.getFoodItemList(), restraurants);
        restraurant.order(order);
        return restraurant;
    }


}
