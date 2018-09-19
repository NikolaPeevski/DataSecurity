import javax.crypto.Cipher;
import java.security.MessageDigest;

public class AsymmetricCipher {
    private AsymmetricCipher st;
    private MessageDigest md;
    private Cipher cp;

    private AsymmetricCipher() {
        try {
            cp = Cipher.getInstance("AES");
        } catch (Exception e) {

        }
    }

    public AsymmetricCipher getInstance() {
        if (st == null)
            st = new AsymmetricCipher();
        return st;
    }

    public void encrypt() {

    }

    public void decrypt() {

    }

    public void generateKeys() {

    }
}
