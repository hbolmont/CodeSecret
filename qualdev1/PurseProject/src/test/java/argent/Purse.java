// chaine d'integration continue
// archive d'integration continue
// déploiement : Jenkins
// automoatiser les test d'intégration
// mettre les projets sur le git, en faire 3 car Jenkins à
import argent.TransactionRejeteeException;
import verrou.CodeSecret;
public class Purse {
    private CodeSecret codeSecret;

    public Purse(CodeSecret codeSecret) {
        this.codeSecret = codeSecret;
    }

    public void debute(double montantDebit, String code) {
        if (!codeSecret.verifierCode(code)) throw new TransactionRejeteeException();
        solde-=montantDebut;
    }

    public double getSolde(){

    }
}
