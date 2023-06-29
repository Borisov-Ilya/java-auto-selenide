package api.reqres.registration;

public class SuccessReg {
    private Integer id;
    private String token;

    public SuccessReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessReg() {
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
