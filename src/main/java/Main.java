import Entities.*;
import Entities.FoodItem;
import Service.FoodOrderService;
import Strategy.HigherRatingStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        FoodOrderService service=new FoodOrderService();

        service.onboardRestraurant(new Restraurant("R1",4.5,5));
        service.updateRestraurant("R1", MenuItem.builder().name("Veg Biryani").price(100).build());
        service.updateRestraurant("R1",MenuItem.builder().name("Chicken Biryani").price(150).build());

        service.onboardRestraurant(new Restraurant("R2",4,5));
        service.updateRestraurant("R2",MenuItem.builder().name("Idli").price(10).build());
        service.updateRestraurant("R2",MenuItem.builder().name("Dosa").price(50).build());
        service.updateRestraurant("R2",MenuItem.builder().name("Veg Biryani").price(80).build());
        service.updateRestraurant("R2",MenuItem.builder().name("Chicken Biryani").price(175).build());

        service.onboardRestraurant(new Restraurant("R3",4.9,1));
        service.updateRestraurant("R3",MenuItem.builder().name("Idli").price(15).build());
        service.updateRestraurant("R3",MenuItem.builder().name("Dosa").price(30).build());
        service.updateRestraurant("R3",MenuItem.builder().name("Gobi Manchurian").price(150).build());
        service.updateRestraurant("R3",MenuItem.builder().name("Chicken Biryani").price(175).build());

        service.updateRestraurant("R1",MenuItem.builder().name("Chicken65").price(250).build());
        service.updateRestraurant("R2",MenuItem.builder().name("Chicken Biryani").price(150).build());



        System.out.println("Entities.Order assigned to "+service.orderFood(Order.builder().id("01").user(User.builder().name("Ashwin").build())
        .foodItemList(Arrays.asList(new FoodItem("Idli",3),new FoodItem("Dosa",1)))
        .selectionStrategy(new HigherRatingStrategy())
        .state(OrderState.UNACCEPTED)
        .build()).getName());

    }
}
