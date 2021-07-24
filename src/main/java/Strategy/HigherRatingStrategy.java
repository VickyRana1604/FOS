package Strategy;

import Entities.Restraurant;
import Entities.FoodItem;
import FOSException.OrderException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HigherRatingStrategy implements RestraurantSelectionStrategy {

    public Restraurant selectRestraurant(final List<FoodItem> orderedItems, List<Restraurant> restraurantList) throws OrderException {

        List<Restraurant> orderableRestros = restraurantList
                .stream()
                .filter(restraurant -> restraurant.areItemsOderable(orderedItems))
                .collect(Collectors.toList());

        if (orderableRestros == null) {
            throw new OrderException("There is no restro who can fullfill this order");
        }
        Collections.sort(orderableRestros, new Comparator<Restraurant>() {
            @Override
            public int compare(Restraurant o1, Restraurant o2) {
                return -Double.compare(o1.getRating(), o2.getRating());
            }
        });

        return orderableRestros.get(0);
    }
}
