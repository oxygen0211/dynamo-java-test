import java.util.List;

import com.stoerk.cloud.event.service.data.Event;
import com.stoerk.cloud.event.service.data.adapter.DynamoDBAdapter;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			long queryStart = System.currentTimeMillis();
			DynamoDBAdapter adapter = new DynamoDBAdapter();
			List<Event> events = adapter.retrieveEvents("103");
			long queryDuration = System.currentTimeMillis() - queryStart;
			System.out.println("Queried "+events.size()+" elements int "+queryDuration+"ms");
			Thread.sleep(1000);
		} 
	}

}
