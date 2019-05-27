import java.util.Date;

public class Tweet {

    private String username;

    private String tweetText;

    private Date tweetDate;

    public Tweet(String un, String tt, Date td)
    {
        username = un;
        tweetText = tt;
        tweetDate = td;
    }

    public String getTweetText() {
        return tweetText;
    }

    public Date getTweetDate() {
        return tweetDate;
    }

    public String getUsername() {
        return username;
    }

}
