package lv.javaguru.java2.domain.moneyOperations;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Artjom on 06.11.2016.
 */
public class Account {

    private long accountBalance;

    public Account() {
        this.accountBalance = 0;
    }

    public long getAccountBalance () {
        return this.accountBalance;
    }

    public void setAccountBalance (long amount) {
        this.accountBalance = amount;
    }



}