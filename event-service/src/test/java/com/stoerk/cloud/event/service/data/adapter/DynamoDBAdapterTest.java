package com.stoerk.cloud.event.service.data.adapter;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.stoerk.cloud.event.service.data.Event;

public class DynamoDBAdapterTest {

	private DynamoDBAdapter fixture;

	@Before
	public void setUp() {
		fixture = new DynamoDBAdapter();
	}

	@Test
	public void testDynamoEventQuery() {
		List<Event> events = fixture.retrieveEvents("103");
		assertTrue(events.size() > 0);
	}
}
