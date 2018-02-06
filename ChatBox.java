import java.util.*;
public class ChatBox{

	public static class Chat implements Comparable<Chat>{
		int Chat_id;
		int User_id;
		int Message_Size;
		String Message;

		public Chat(int t_id, int user_id, int message_size, String message){
			this.Chat_id = t_id;
			this.User_id = user_id;
			this.Message_Size = message_size;
			this.Message = message;
		}

		@Override
		public int compareTo(Chat t){
			int t_id = ((Chat)t).Chat_id;
			return this.Chat_id - t_id;
		}

		/*Comparator for sorting by user_id*/
		public static Comparator<Chat> chatComparatorByUserId = new Comparator<Chat>(){
			public int compare(Chat c1, Chat c2){
				return c1.User_id - c2.User_id;
			}
		};

		/*Comparator for sorting by Message Size*/
		public static Comparator<Chat> chatComparatorByMessageSize = new Comparator<Chat>(){
			public int compare(Chat c1, Chat c2){
				return c1.Message_Size - c2.Message_Size;
			}
		};

		@Override
		public String toString(){
			return "[ Chat_id = "+this.Chat_id+" User_id = "+this.User_id+" Message = "+this.Message+" Message_size = "+this.Message_Size+" ]";
		}
	}

	/*Another way to define comparator as a class*/
	public static class ChatComparatorByMessage implements Comparator<Chat>{
		public int compare(Chat c1, Chat c2){
			return c1.Message.compareTo(c2.Message);
		}
	}

	public static void main(String [] a){
		List<Chat> chats = new ArrayList<Chat>();
		chats.add(new Chat(2,3,10,"this is 2"));
		chats.add(new Chat(1,1,9,"this is 1"));
		chats.add(new Chat(4,5,19,"this is 4"));
		chats.add(new Chat(3,10,50,"this is 3"));
		chats.add(new Chat(6,8,20,"this is 6"));
		chats.add(new Chat(5,2,11,"this is 5"));

		Collections.sort(chats);
		/*Sorted by Transaction_Id*/
		System.out.println("Sorted by Transaction_Id");
		for(Chat t : chats)
			System.out.println(t);

		/*Sorted by user_Id*/
		Collections.sort(chats, Chat.chatComparatorByUserId);
		System.out.println("Sorted by User_Id");
		for(Chat t : chats)
			System.out.println(t);

		/*Sorted by Message_Size*/
		Collections.sort(chats, Chat.chatComparatorByMessageSize);
		System.out.println("Sorted by Message_Size");
		for(Chat t : chats)
			System.out.println(t);

		/*Sorted by Message*/
		Collections.sort(chats, new ChatComparatorByMessage());
		System.out.println("Sorted by Message");
		for(Chat t : chats)
			System.out.println(t);		
	}
}