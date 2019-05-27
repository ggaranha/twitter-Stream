import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.util.function.Consumer;

import java.io.Serializable;

public class TweetLifecycleManager implements LifecycleManager, Serializable{

    private ConfigurationBuilder configurationBuilder;

    private TwitterStream stream;


    private String tracked_terms;
    private FilterQuery query;

    String _consumerKey = System.getenv().get("TWITTER_CONSUMER_KEY");
    String _consumerSecret = System.getenv().get("TWITTER_CONSUMER_SECRET");
    String _accessToken = System.getenv().get("TWITTER_ACCESS_TOKEN");
    String _accessTokenSecret = System.getenv().get("TWITTER_ACCESS_TOKEN_SECRET");

    public TweetLifecycleManager() {

        configurationBuilder = new ConfigurationBuilder()
                .setOAuthConsumerKey(_consumerKey)
                .setOAuthConsumerSecret(_consumerSecret)
                .setOAuthAccessToken(_accessToken)
                .setOAuthAccessTokenSecret(_accessTokenSecret);

        stream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();

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
