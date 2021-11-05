package swaglabs.model;

public enum Swagger {
    Colin("standard_user","secret_sauce"), Bob("locked_out_user","secret_sauce");

    private final String username;
    private final String password;

    Swagger(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
