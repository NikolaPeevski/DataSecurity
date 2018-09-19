import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashCipher {
    //TODO: Write comments and javadoc for this class
    private static HashCipher st;
    private final String algo = "RawBytes";
    private MessageDigest md;
    private Cipher cp;
    private byte[] digestedKey;
    private SecretKeySpec sks;

    private HashCipher(String encryptionMode) {
        try {
            cp = Cipher.getInstance("AES");
            md = MessageDigest.getInstance(encryptionMode);

        } catch (Exception e) {

        }
    }

    public HashCipher getInstance(String encryptionMode) {
        if (st == null)
            st = new HashCipher(encryptionMode);
        return st;
    }

    //TODO: Make encrypt and decrypt take string keys for simplicity
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
