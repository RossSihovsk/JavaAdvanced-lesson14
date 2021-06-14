import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Arrays;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        Session session = CreateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Item item1 = new Item("item01");
        Item item2 = new Item("item02");
        Item item3 = new Item("item03");
        Item item4 = new Item("item04");
        Cart cart = new Cart("test1","name1");
        cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));

        session.persist(cart);

        transaction.commit();
        session.close();

    }
}
