package com.stoerk.cloud.event.service.data.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.stoerk.cloud.event.service.data.Event;

public class DynamoDBAdapter {
	private DynamoDB dynamoDB;

	public DynamoDBAdapter() {
		AmazonDynamoDBClient dynamo = new AmazonDynamoDBClient();
		dynamo.withRegion(Regions.EU_CENTRAL_1);
		dynamoDB = new DynamoDB(dynamo);
	}

	public List<Event> retrieveEvents(String commander) {
		List<Event> events = new ArrayList<Event>();

		Table table = dynamoDB.getTable("events");

		QuerySpec spec = new QuerySpec().withHashKey("commander", commander);
		System.out.println("Querying elements");
		ItemCollection<QueryOutcome> items = table.getIndex("events-by-commander").query(spec);

		Iterator<Item> iterator = items.iterator();
		
		while (iterator.hasNext()) {
			Item item = iterator.next();
			
			Event event = new Event();
			
			event.setCommander(item.get("commander").toString());
			
			events.add(event);
		}
		
		return events;
	}
}
