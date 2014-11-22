package foosball.tests;

import org.testng.annotations.Test;

import foosball.panels.TossResultPanel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@Test
public class TossResultTest {
	TossResultPanel tossResultTestObject = new TossResultPanel();
	public void checkResultOfcalcTossResult() {
	  assertThat(tossResultTestObject.calcTossResult(1), isOneOf("You win!", "You lose!"));
	  assertThat(tossResultTestObject.calcTossResult(2), isOneOf("You win!", "You lose!"));
  }
}
