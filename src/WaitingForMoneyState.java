public class WaitingForMoneyState implements StateOfVendingMachine {
    @Override
    public void selectSnack(String snackName, VendingMachine machine) {
        System.out.println("Snack already selected, please insert money");
    }

    @Override
    public void insertMoney(double amount, VendingMachine machine) {
        Snack snack = machine.getSnack(machine.getCurrentSnack());
        if (snack != null && amount >= snack.getPrice()) {
            if (snack.getQuantity() > 0) {
                machine.setInsertedMoney(amount);
                machine.setState(new DispensingSnackState());
                dispenseSnack(machine);
            } else {
                System.out.println("Sorry, selected snack is out of stock");
            }
        } else {
            System.out.println("Insufficient money inserted, please insert at least " + snack.getPrice());
        }
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        // Handled by the next state
    }
}
