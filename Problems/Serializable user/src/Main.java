import java.io.Serializable;

class User {
    private static final long serialVersionUID = 1L;
    String name;
    transient String password;
}