public class DispensingSnackState implements StateOfVendingMachine {
    @Override
    public void selectSnack(String snackName, VendingMachine machine) {
        System.out.println("Dispensing current snack, please wait");
    }

    @Override
    public void insertMoney(double amount, VendingMachine machine) {
        System.out.println("Currently dispensing, please wait");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        Snack snack = machine.getSnack(machine.getCurrentSnack());
        if (snack.getQuantity() > 0 && machine.getInsertedMoney() >= snack.getPrice()) {
            snack.setQuantity(snack.getQuantity() - 1);
            System.out.println("Dispensing " + snack.getName());
            machine.setInsertedMoney(0);
            machine.setState(new IdleState());
            if (machine.getInsertedMoney() > snack.getPrice()) {
                System.out.println("Returning excess money: " + (machine.getInsertedMoney() - snack.getPrice()));
            }
        } else {
            System.out.println("Error in dispensing, please try again");
            machine.setState(new IdleState());
        }
    }
}

