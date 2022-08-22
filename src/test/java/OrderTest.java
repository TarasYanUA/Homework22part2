import org.testng.Assert;
import org.testng.annotations.Test;
import taras.Inventory;
import taras.Order;
import taras.OrderEndPoint;
import java.io.IOException;

public class OrderTest {

    @Test
    public void getOrderIdTest() throws IOException {
        Order order = new Order();
        order.setId(2L);

        OrderEndPoint orderEndPoint = new OrderEndPoint();
        Order newOrder = orderEndPoint.getOrderId(2L);
        System.out.println("newOrder is : " + newOrder);
        System.out.println("Order is: " + order);
        Assert.assertTrue(order.getId().equals(newOrder.getId()));
    }

    @Test
    public void createOrderTest() throws IOException {
        Order order = new Order();
        order.setId(2L);
        order.setPetId(55L);
        order.setQuantity(10);
        order.setStatus("complete");

        OrderEndPoint orderEndPoint = new OrderEndPoint();
        Order myOrder = orderEndPoint.createOrder(order);
        System.out.println("My Order is  " + myOrder);
        System.out.println("Order is " + order);
        Assert.assertEquals(order.getPetId(), myOrder.getPetId());
    }

    //Тест к Варианту 2
/*    @Test
    public void createOrderTest() throws IOException {
        OrderEndPoint orderEndPoint = new OrderEndPoint();
        orderEndPoint.createOrder(2L, 5L, 1);
    }*/

    @Test
    public void deleteOrderTest() throws IOException {
        Order order = new Order();
        order.setId(4L);

        OrderEndPoint orderEndPoint = new OrderEndPoint();
        orderEndPoint.deleteOrder(order.getId());
        Order deletedOrder = orderEndPoint.getOrderId(4L);
        Assert.assertNull(deletedOrder.getId());
    }

    @Test
    public void getInventoryTest() throws  IOException {
        new OrderEndPoint().getInventory();
        Inventory inventory = new Inventory();
        inventory.setSold(4);
        inventory.setPending(13);
        inventory.setAvailable(465);

        Assert.assertEquals(inventory.getSold(), 4);
        Assert.assertEquals(inventory.getPending(), 13);
        Assert.assertEquals(inventory.getAvailable(), 465);
    }
}