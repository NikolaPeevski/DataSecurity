import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SymmetricCipher {
    //TODO: Write comments and javadoc for this class
    private static SymmetricCipher st;
    private final String algo = "RawBytes";
    private MessageDigest md;
    private Cipher cp;
    private byte[] digestedKey;
    private SecretKeySpec sks;

    private SymmetricCipher(String encryptionMode) {
        try {
            cp = Cipher.getInstance("AES");
            md = MessageDigest.getInstance(encryptionMode);

        } catch (Exception e) {

        }
    }

    public SymmetricCipher getInstance(String encryptionMode) {
        if (st == null)
            st = new SymmetricCipher(encryptionMode);
        return st;
    }

    public byte[] encrypt(byte[] key, String message) {
        digestedKey = md.digest(key);

        sks = new SecretKeySpec(digestedKey, algo);
        try {
            cp.init(Cipher.ENCRYPT_MODE, sks);
            return cp.doFinal(message.getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {

        }
        return new byte[]{};
    }

    public byte[] decrypt(byte[] key, String encryptedMessage) {
        digestedKey = md.digest(key);
        sks = new SecretKeySpec(digestedKey, algo);

        try {
            cp.init(Cipher.DECRYPT_MODE, sks);
            return cp.doFinal(encryptedMessage.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {

        }
        return new byte[]{};
    }


}
