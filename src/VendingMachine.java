import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Snack> snacks;
    private StateOfVendingMachine state;
    private String currentSnack;
    private double insertedMoney;

    public VendingMachine() {
        this.snacks = new HashMap<>();
        this.state = new IdleState();
        this.insertedMoney = 0;
    }

    public void addSnack(Snack snack) {
        this.snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String name) {
        return snacks.get(name);
    }

    public void selectSnack(String snackName) {
        state.selectSnack(snackName, this);
    }

    public void insertMoney(double amount) {
        state.insertMoney(amount, this);
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void setCurrentSnack(String snackName) {
        this.currentSnack = snackName;
    }

    public String getCurrentSnack() {
        return currentSnack;
    }

    public void setInsertedMoney(double amount) {
        this.insertedMoney = amount;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }
}
