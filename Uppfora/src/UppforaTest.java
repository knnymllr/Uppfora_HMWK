import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UppforaTest {

	@Test
	void testCheckEntry() {
		assertTrue(Uppfora.checkEntry("PERSHULT"));
		assertTrue(Uppfora.checkEntry("KLYKET"));
		assertTrue(Uppfora.checkEntry("TJUSIG"));
		assertTrue(Uppfora.checkEntry("SKADIS"));
		assertTrue(Uppfora.checkEntry("HOVOLM"));
		assertFalse(Uppfora.checkEntry("Pershult"));
		assertFalse(Uppfora.checkEntry("kLYKET"));
		assertFalse(Uppfora.checkEntry("Rock"));
		assertFalse(Uppfora.checkEntry("Paper"));
		assertFalse(Uppfora.checkEntry("Scissors"));
	}
	
	@Test
	void testCheckWinner() {
		assertTrue(Uppfora.checkWinner("PERSHULT", "KLYKET"));
		assertTrue(Uppfora.checkWinner("PERSHULT", "SKADIS"));
		assertTrue(Uppfora.checkWinner("KLYKET", "TJUSIG"));
		assertTrue(Uppfora.checkWinner("KLYKET", "HOVOLM"));
		assertTrue(Uppfora.checkWinner("TJUSIG", "PERSHULT"));
		assertTrue(Uppfora.checkWinner("TJUSIG", "SKADIS"));
		assertTrue(Uppfora.checkWinner("SKADIS", "HOVOLM"));
		assertTrue(Uppfora.checkWinner("SKADIS", "KLYKET"));
		assertTrue(Uppfora.checkWinner("HOVOLM", "PERSHULT"));
		assertTrue(Uppfora.checkWinner("HOVOLM", "TJUSIG"));
		assertFalse(Uppfora.checkWinner("PERSHULT", "TJUSIG"));
		assertFalse(Uppfora.checkWinner("PERSHULT", "HOVOLM"));
		assertFalse(Uppfora.checkWinner("KLYKET", "PERSHULT"));
		assertFalse(Uppfora.checkWinner("KLYKET", "SKADIS"));
		assertFalse(Uppfora.checkWinner("TJUSIG", "KLYKET"));
		assertFalse(Uppfora.checkWinner("TJUSIG", "HOVOLM"));
		assertFalse(Uppfora.checkWinner("SKADIS", "PERSHULT"));
		assertFalse(Uppfora.checkWinner("SKADIS", "TJUSIG"));
		assertFalse(Uppfora.checkWinner("HOVOLM", "SKADIS"));
		assertFalse(Uppfora.checkWinner("HOVOLM", "KLYKET"));
		assertFalse(Uppfora.checkWinner("PERSHULT", "PERSHULT"));
		assertFalse(Uppfora.checkWinner("KLYKET", "KLYKET"));
		assertFalse(Uppfora.checkWinner("TJUSIG", "TJUSIG"));
		assertFalse(Uppfora.checkWinner("SKADIS", "SKADIS"));
		assertFalse(Uppfora.checkWinner("HOVOLM", "HOVOLM"));
	}
	
}
