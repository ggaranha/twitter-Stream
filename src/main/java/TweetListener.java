import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TweetListener {

    StatusListener listener = new StatusListener() {
        @Override
        public void onStatus(Status status) {
            Tweet twt = new Tweet(status.getUser().getName(), status.getText(), status.getCreatedAt());
            System.out.println(twt.getTweetDate().toString() + " : " + twt.getUsername() + " : " + twt.getTweetText());
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

        }

        @Override
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

        }

        @Override
        public void onScrubGeo(long l, long l1) {

        }

        @Override
        public void onStallWarning(StallWarning stallWarning) {

        }

        @Override
        public void onException(Exception e) {
            e.printStackTrace();

        }
    };
}
