package test.annotations;

public class ClassWithAnnotation {

    private Integer userId;
    private String username;

    @CustomAnnotation()
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
