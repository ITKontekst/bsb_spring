package pl.itkontekst.spring;

/**
 * Created by Wojciech Oczkowski on 2019-06-14.
 */
public class MyDBConfig {
    private String hostname;
    private String port;
    private String username;
    private String password;

    public MyDBConfig(String hostname, String port, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyDBConfig{" +
                "hostname='" + hostname + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
