package integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurseCodeSecretIntegrationTest {

    Purse purse;
    CodeSecret codeSecret;
    private double montantCredit = 100;
    private double montantDebit = 20;
    private String goodCode;
    private String badCode;

    @BeforeEach
    public void setUp() {
        codeSecret = new CodeSecret();
        purse = new Purse(codeSecret);
        purse.credite(montantCredit);
        goodCode = codeSecret.revelerCode();
        badCode = goodCode.substring(0, 2)+(goodCode.charAt(3)!='0'?'0':'1');
    }

    @Test
    public void testDebitAvecCodeAutorise() {
        purse.debite(montantCredit, goodCode);
        Assertions.assertEquals(montantCredit-montantDebit, purse.getSolde());
    }

    @Test
    public void testDebitAvecCodeFauxRejete() {
        Assertions.assertThrows(TransactionRejeteeException.class,
                ()->purse.debite(montantDebit, badCode));
    }

    @Test
    public void testDebitAvecCodeBloqueRejete() {

    }

    @Test
    public void testCreditAvecCodeBloqueRejete() {

    }
}
