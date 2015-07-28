package com.mt;

import org.junit.Test;
import static org.junit.Assert.*;
import com.mt.domain.Explorer;
import com.mt.domain.Position;

/**
 * Tests for explorer
 * @author kiran
 *
 */
public class ExplorerTest {

	@Test
	public void testChangePosition() {
		Explorer explorer = new Explorer();
		explorer.changePosition(new Position(5, 6));
		
		assertEquals(5, explorer.getPosition().getX());
		assertEquals(6, explorer.getPosition().getY());	
	}

	
	@Test
	public void testChangePositionTwice() {
		Explorer explorer = new Explorer();
		explorer.changePosition(new Position(5, 6));
		explorer.changePosition(new Position(6, 7));
		
		assertEquals(6, explorer.getPosition().getX());
		assertEquals(7, explorer.getPosition().getY());	
	}

	
}
