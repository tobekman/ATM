package com.tobias.atm;

public class Main {

    public static void main(String[] args) {

        Atm atm = new Atm(2, 3, 5);

        atm.showTotalAmount();

        atm.withdraw(1500);
        atm.withdraw(700);
        atm.withdraw(400);
        atm.withdraw(1100);
        atm.withdraw(700);
        atm.withdraw(300);

        atm.showTotalAmount();

    }

}
