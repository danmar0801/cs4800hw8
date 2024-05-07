public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.addSnack(new Snack("Coke", 1.25, 10));
        machine.addSnack(new Snack("Pepsi", 1.20, 5));

        machine.selectSnack("Coke");
        machine.insertMoney(1.30);  // This should dispense the snack and return extra money if any
    }
}