package Backend_Tasks;

class Bank {
    protected double transactionCharge = 0.02;

    public double getTransactionCharge() {
        return transactionCharge;
    }
}

class ICICI extends Bank {
    private double additionalCharge = 0.005;

    public double calculateTransactionCharge() {
        return transactionCharge + additionalCharge;
    }
}

class HDFC extends Bank {
    private double additionalCharge = 0.007;

    public double calculateTransactionCharge() {
        return transactionCharge + additionalCharge;
    }
}

public class Banks {
    public static void main(String[] args) {
        ICICI icici = new ICICI();
        HDFC hdfc = new HDFC();

        System.out.println("ICICI Transaction Charge Rate: " + icici.calculateTransactionCharge() * 100 + "%");
        System.out.println("HDFC Transaction Charge Rate: " + hdfc.calculateTransactionCharge() * 100 + "%");
    }
}
