package Entities;

import Strategy.RestraurantSelectionStrategy;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Order {
    String id;
    User user;
    List<FoodItem> foodItemList;
    RestraurantSelectionStrategy selectionStrategy;
    OrderState state;
}
