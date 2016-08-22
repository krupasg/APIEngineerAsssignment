package tweets;

import java.util.ArrayList;
import java.util.List;

import twitter4j.IDs;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterHandler {

	public static List<Long> getSharedFriendsBetWeenTwoUsers(String handle1, String handle2){
		//get the twitter client reference
		Twitter twitter = getTwitterClientReferenceWithAuthorization();
		long[] arrayIds1 = null;
		long[] arrayIds2 = null;
		List<Long> commonFriends = null;
		try {
			IDs ids1 = twitter.getFriendsIDs(handle1, -1); 
			arrayIds1 =  ids1.getIDs();
		
			IDs ids2 =  twitter.getFriendsIDs(handle2, -1);
			arrayIds2 =  ids2.getIDs();
			commonFriends = getCommonaFriends(arrayIds1, arrayIds2);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return commonFriends;
	}
	
	private static List<Long> getCommonaFriends(long[] arrayIds1, long[] arrayIds2) {
		List<Long> commonFriends = new ArrayList<Long>();
		for (long l1 : arrayIds1) {
			for (long l2 : arrayIds2) {
				if (l1==l2){
					commonFriends.add(l1);
				}
			}
		}
		return commonFriends;
	}
	
	public static Twitter getTwitterClientReferenceWithAuthorization() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("", "");
		twitter.setOAuthAccessToken(new AccessToken("", ""));
		return twitter;
	}
	
	public ArrayList<String> retrieve(String username,int numberofpost)
	{

		Twitter twitter = getTwitterClientReferenceWithAuthorization();
//		twitter.setOAuthConsumer("1DG4SW6jXruZUvdIC4TZAgvPB", "uC3XEYeIfxnS8AHEDlB9X32YD5pZAALiLiF0eeSeq9hRWjM77K");
//		twitter.setOAuthAccessToken(new AccessToken("766481486069559297-ReQuTePdx5GFHFa4vTJxGXwbaOIr914", "Vyq2DaczxqUCgd5uPFuA2KE8rfyUgDZkGIe1L4axLDkO7"));
		ArrayList<String> tweets = new ArrayList<String>();
		for(int count=0; count<tweets.size(); count++) {
			System.out.println(tweets);
		}
		
		try {
//			//ResponseList<Status> a = twitter.getUserTimeline(new Paging(1,5));
//			ResponseList<Status> a = twitter.getUserTimeline(new Paging(1,7));
//			for (Status b : a) {
//				System.out.println(b.getText());
//			}

			Object krupa43085872;
			ResponseList<Status> a1 = twitter.getUserTimeline(username, new Paging(1,numberofpost));

			for (Status status : a1) {
				tweets.add(status.getText());
				System.out.println(status.getText());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return tweets;
	}
	
	public static void main (String args[]) {
		
		System.out.println("Shared Friends" + TwitterHandler.getSharedFriendsBetWeenTwoUsers("", "").size());
		
	}


}


