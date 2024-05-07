public class IdleState implements StateOfVendingMachine {
    @Override
    public void selectSnack(String snackName, VendingMachine machine) {
        machine.setCurrentSnack(snackName);
        machine.setState(new WaitingForMoneyState());
        System.out.println("Snack selected, please insert money");
    }

    @Override
    public void insertMoney(double amount, VendingMachine machine) {
        System.out.println("Please select a snack first");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Please select a snack and insert money first");
    }
}

