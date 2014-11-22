package foosball.tests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import foosball.exceptions.*;
import foosball.strategy.Team;
@Test
public class TeamTests {
	Team testTeam;
	public void testTeamCount() {
		try {
			testTeam = new Team(5,1,1,true);
		} catch (TeamCountException e) {
			assertEquals(true, true);
		} catch (AttackerCountException e) {
			assertEquals(true, false);
		} catch (MidfielderCountException e) {
			assertEquals(true, false);
		} catch (DefenderCountException e) {
			assertEquals(true, false);
		}
	}

	public void testAttackerCount() {
		try {
			testTeam = new Team(6,2,2,true);
		} catch (TeamCountException e) {
			assertEquals(true, false);
		} catch (AttackerCountException e) {
			assertEquals(true, true);
		} catch (MidfielderCountException e) {
			assertEquals(true, false);
		} catch (DefenderCountException e) {
			assertEquals(true, false);
		}
	}
	
	public void testDefenderCount() {
		try {
			testTeam = new Team(1,2,7,true);
		} catch (TeamCountException e) {
			assertEquals(true, false);
		} catch (AttackerCountException e) {
			assertEquals(true, false);
		} catch (MidfielderCountException e) {
			assertEquals(true, false);
		} catch (DefenderCountException e) {
			assertEquals(true, true);
		}
	}
	
	public void testMidFielderCount() {
		try {
			testTeam = new Team(3,6,1,true);
		} catch (TeamCountException e) {
			assertEquals(true, true);
		} catch (AttackerCountException e) {
			assertEquals(true, true);
		} catch (MidfielderCountException e) {
			assertEquals(true, false);
		} catch (DefenderCountException e) {
			assertEquals(true, true);
		}
	}
}