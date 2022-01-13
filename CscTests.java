package testSimu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CscTests {

	private Csc maVoitureTest;

	public CscTests() {
	}

	@BeforeEach
	public void createVoiture() {
		maVoitureTest = new Csc();
	}

	@Test
	void testdistanceSecurite() {
		assertEquals(30.0, maVoitureTest.distanceSecurite(50.0));
		assertEquals(54.0, maVoitureTest.distanceSecurite(90.0));
		assertEquals(72.0, maVoitureTest.distanceSecurite(120.0));
	}

	@Test
	void testcscIsDanger() {
		assertEquals(true, maVoitureTest.cscIsDanger(50.0, 10.0));
		assertEquals(true, maVoitureTest.cscIsDanger(50.0, 20.0));
		assertEquals(true, maVoitureTest.cscIsDanger(50.0, 28.0));
		assertEquals(false, maVoitureTest.cscIsDanger(50.0, 31.0));
		assertEquals(true, maVoitureTest.cscIsDanger(90.0, 20.0));
		assertEquals(true, maVoitureTest.cscIsDanger(90.0, 40.0));
		assertEquals(true, maVoitureTest.cscIsDanger(90.0, 50.0));
		assertEquals(false, maVoitureTest.cscIsDanger(90.0, 56.0));
		assertEquals(false, maVoitureTest.cscIsDanger(90.0, 60.0));
		assertEquals(true, maVoitureTest.cscIsDanger(120.0, 10.0));
		assertEquals(true, maVoitureTest.cscIsDanger(120.0, 30.0));
		assertEquals(true, maVoitureTest.cscIsDanger(120.0, 70.0));
		assertEquals(false, maVoitureTest.cscIsDanger(120.0, 73.0));
		assertEquals(false, maVoitureTest.cscIsDanger(120.0, 80.0));
	}

	@Test
	void testcscDecision() {
		assertEquals(maVoitureTest.intensiteFrein, maVoitureTest.cscDecision(true));
		assertEquals(0.0, maVoitureTest.cscDecision(false));
	}

}