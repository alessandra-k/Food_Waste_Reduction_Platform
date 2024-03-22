package Model;

/**
 *
 * @author aless
 */
public enum CommunicationMethod {

    EMAIL(1),
    PHONE(2);

    private final int communicationMethod_id;

    CommunicationMethod(int id) {
        this.communicationMethod_id = id;
    }

    public int getCommunicationMethod_id() {
        return communicationMethod_id;
    }

}
