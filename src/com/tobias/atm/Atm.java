package com.tobias.atm;

public class Atm {

    private double thousandBills;
    private double fiveHundredBills;
    private double hundredBills;

    public Atm(int thousandBills, int fiveHundredBills, int hundredBills) {
        this.thousandBills = thousandBills;
        this.fiveHundredBills = fiveHundredBills;
        this.hundredBills = hundredBills;
    }

    public double getCurrentBalance() {
        return thousandBills * 1000 + fiveHundredBills * 500 + hundredBills * 100;
    }

    public void showTotalAmount() {
        System.out.println("\nThousands: " + thousandBills);
        System.out.println("Five hundreds: " + fiveHundredBills);
        System.out.println("Hundreds: " + hundredBills);
        System.out.println("Total balance: " + getCurrentBalance());
    }

    public void withdraw(double amount) {
        System.out.println("\nWithdrawal amount: " + amount);
        if (getCurrentBalance() >= amount) {
            int whileAmount = (int)amount;
            double thousands = Math.floor(amount / 1000);
            amount -= thousands * 1000;
            double fiveHundreds = Math.floor(amount / 500);
            amount -= fiveHundreds * 500;
            double hundreds = Math.floor(amount / 100);

            while (whileAmount > 0) {
                if(thousandBills != 0 && thousands != 0) {
                    thousandBills--;
                    thousands--;
                    whileAmount -= 1000;
                    System.out.println("withdraw 1000");
                }
                if (fiveHundredBills != 0 && fiveHundreds != 0) {
                    fiveHundredBills--;
                    fiveHundreds--;
                    whileAmount -= 500;
                    System.out.println("withdraw 500");
                }
                if (hundredBills >= hundreds) {
                    if (hundredBills != 0 && hundreds != 0) {
                        hundredBills--;
                        hundreds--;
                        whileAmount -= 100;
                        System.out.println("withdraw 100");
                    }
                } else {
                    System.out.println("Not enough bills for this amount");
                    break;
                }
                if (thousandBills == 0 && thousands != 0) {
                    if (fiveHundredBills != 0) {
                        fiveHundredBills--;
                        thousands = thousands - 0.5;
                        whileAmount -= 500;
                        System.out.println("withdraw 500");
                    } else if (hundredBills > 4) {
                        hundredBills = hundredBills - 5;
                        thousands = thousands - 0.5;
                        whileAmount -= 500;
                        System.out.println("withdraw 100*5");
                    }
                }
                if (fiveHundredBills == 0 && fiveHundreds != 0) {
                    if (hundredBills > 4) {
                        hundredBills = hundredBills - 5;
                        fiveHundreds--;
                        whileAmount -= 500;
                        System.out.println("withdraw 100*5");
                    }
                }

            }
        } else {
            System.out.println("Not enough cash in machine");
        }
    }
}
