package Strategy;

import Entities.Restraurant;
import Entities.FoodItem;
import FOSException.OrderException;

import java.util.List;

public interface RestraurantSelectionStrategy {
    Restraurant selectRestraurant(List<FoodItem> orderedItems, List<Restraurant> restraurantList) throws OrderException;
}
