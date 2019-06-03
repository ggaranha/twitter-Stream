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

    String _consumerKey = "CONSUMER_KEY";
    String _consumerSecret = "CONSUMER_SECRET";
    String _accessToken = "TOKEN_KEY";
    String _accessTokenSecret = "TOKEN_SECRET";

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
