import junit.framework.*;

class tests{
	@BeforeEach
    public void createVoiture() {
        maVoitureTest= new Csc(50);    
    }

	@Test
	void testdistanceSecurite(){
		assertEquals(30.0,Csc.distanceSecurite(50.0));
		assertEquals(54.0,Csc.distanceSecurite(90.0));
		assertEquals(72.0,Csc.distanceSecurite(120.0));
	}
	@Test
	void testcscIsDanger(){
		assertEquals(true,Csc.cscIsDanger(50.0,10.0));
		assertEquals(true,Csc.cscIsDanger(50.0,20.0));
		assertEquals(true,Csc.cscIsDanger(50.0,28.0));
		assertEquals(false,Csc.cscIsDanger(50.0,31.0));
		assertEquals(true,Csc.cscIsDanger(90.0,20.0));
		assertEquals(true,Csc.cscIsDanger(90.0,40.0));
		assertEquals(true,Csc.cscIsDanger(90.0,50.0));
		assertEquals(false,Csc.cscIsDanger(90.0,56.0));
		assertEquals(false,Csc.cscIsDanger(90.0,60.0));
		assertEquals(true,Csc.cscIsDanger(120.0,10.0));
		assertEquals(true,Csc.cscIsDanger(120.0,30.0));
		assertEquals(true,Csc.cscIsDanger(120.0,70.0));
		assertEquals(false,Csc.cscIsDanger(120.0,73.0));
		assertEquals(false,Csc.cscIsDanger(120.0,80.0));
	}
	@Test
	void testcscDecision(){
		assertEquals(Csc.intensiteFrein,Csc.cscDecision(true));
		assertEquals(0.0,Csc.cscDecision(false));
	}
	
}