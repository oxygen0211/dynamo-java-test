import java.util.List;

import com.stoerk.cloud.event.service.data.Event;
import com.stoerk.cloud.event.service.data.adapter.DynamoDBAdapter;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		DynamoDBAdapter adapter = new DynamoDBAdapter();
		while (true) {
			long queryStart = System.currentTimeMillis();
			List<Event> events = adapter.retrieveEvents("103");
			long queryDuration = System.currentTimeMillis() - queryStart;
			System.out.println("Queried "+events.size()+" elements int "+queryDuration+"ms");
			Thread.sleep(5000);
		} 
	}

}
