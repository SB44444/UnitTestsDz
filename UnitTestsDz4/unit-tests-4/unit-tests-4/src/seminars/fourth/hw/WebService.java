package seminars.fourth.hw;

public class WebService {
    public HttpClient httpClient;
    public WebService(HttpClient httpClient) { this.httpClient = httpClient; }
    public String getUrl(String url) { return httpClient.get(url); }
}

