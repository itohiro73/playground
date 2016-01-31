package jp.itohiro.playground.fp_in_scala;

public class Charge {
    private final CreditCard cc;
    private final long amount;

    public Charge(CreditCard cc, long amount){

        this.cc = cc;
        this.amount = amount;
    }

    public Charge combine(Charge other) {
        if (this.cc == other.getCc()) {
            return new Charge(cc, amount + other.getAmount());
        }
        else{
            throw new RuntimeException("Can't combine charges to different cards");
        }
    }

    public CreditCard getCc() {
        return this.cc;
    }

    public long getAmount() {
        return amount;
    }
}
