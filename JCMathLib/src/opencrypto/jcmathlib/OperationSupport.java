package opencrypto.jcmathlib;

/**
 * OperationSupport class
 * 
 * @author Antonin Dufka
 */
public class OperationSupport {
    private static OperationSupport instance;

    public static final short SIMULATOR = 0x0000;
    public static final short J2E145G = 0x0001;
    public static final short J3H145 = 0x0002;
    public static final short J3R180 = 0x0003;

    public boolean RSA_MULT_TRICK = false;
    public boolean RSA_MOD_EXP = false;
    public boolean RSA_PREPEND_ZEROS = false;
    public boolean RSA_KEY_REFRESH = false;
    public boolean ECDH_XY = false;
    public boolean ECDH_X_ONLY = true;
    public boolean EC_SW_DOUBLE = false;

    private OperationSupport() {}

    public static OperationSupport getInstance() {
        if (OperationSupport.instance == null)
            OperationSupport.instance = new OperationSupport();
        return OperationSupport.instance;
    }

    public void setCard(short card_identifier) {
        switch (card_identifier) {
            case SIMULATOR:
                RSA_MULT_TRICK = false;
                RSA_MOD_EXP = true;
                RSA_PREPEND_ZEROS = true;
                RSA_KEY_REFRESH = true;
                // ECDH_XY = true;
                EC_SW_DOUBLE = true;
                break;
            case J2E145G:
                RSA_MULT_TRICK = true;
                RSA_MOD_EXP = true;
                break;
            case J3H145:
                RSA_MULT_TRICK = true;
                RSA_MOD_EXP = false;
                break;
            case J3R180:
                RSA_MULT_TRICK = true;
                RSA_MOD_EXP = false;
                break;
            default:
                break;
        }
    }
}
