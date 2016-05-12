import controller.Controller;
import model.Model;
import view.View;

/**
 * Created on 2:19 09.05.2016
 *
 * @author Bersik (Serhii Kisilchuk)
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}
