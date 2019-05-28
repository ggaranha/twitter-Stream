import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.util.function.Consumer;
import twitter4j.StatusListener;

import java.io.Serializable;

public class TweetLifecycleManager implements LifecycleManager, Serializable{

    private ConfigurationBuilder configurationBuilder;

    private TwitterStream stream;

    private TweetListener lnr;

    private String tracked_terms;
    private FilterQuery query;

    String terms = "futebol,novela";

    String _consumerKey = "QBTNu4wt8vWDsGVYF16fInSs5";
    String _consumerSecret = "Uaxc934jyI2CoSq4810HjcgHYL3sG9yYc01iStuW5rXo3v6rSr";
    String _accessToken = "805917465758892036-Zj2hU6t1ecE4qyP0HjxF9X8pIlaqkvG";
    String _accessTokenSecret = "1Es3vYrUfkOeGG48HFHgymU2rabqwLAnw5UUMOGoAkP0N";

    public TweetLifecycleManager() {

        lnr = new TweetListener();
        tracked_terms = terms;

        configurationBuilder = new ConfigurationBuilder()
                .setOAuthConsumerKey(_consumerKey)
                .setOAuthConsumerSecret(_consumerSecret)
                .setOAuthAccessToken(_accessToken)
                .setOAuthAccessTokenSecret(_accessTokenSecret);

        stream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();
        stream.addListener(lnr.listener);

        query = new FilterQuery();
        query.track(tracked_terms.split(","));
        stream.filter(query);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
/*
    LifecycleManager manager = new LifecycleManager() {
        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }
    }*/
}
