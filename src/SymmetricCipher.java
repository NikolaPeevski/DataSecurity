public class SymmetricCipher {
    private SymmetricCipher st;

    private SymmetricCipher() {

    }

    public SymmetricCipher getInstance() {
        if (st == null)
            st = new SymmetricCipher();
        return st;
    }

    public void encrypt() {

    }

    public void decrypt() {

    }

    public void generateKey() {

    }
}
