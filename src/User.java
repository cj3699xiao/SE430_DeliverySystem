public abstract class User {
    private String UserID;
    private String UserName;
    private String PhoneNumber;

    public User(String UID, String UN, String PN) {
        this.UserID = UID;
        this.UserName = UN;
        this.PhoneNumber = PN;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
