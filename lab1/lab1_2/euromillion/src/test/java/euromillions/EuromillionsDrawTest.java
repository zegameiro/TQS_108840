package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import pt.deti.ua.euromillions.CuponEuromillions;
import pt.deti.ua.euromillions.Dip;
import pt.deti.ua.euromillions.EuromillionsDraw;

public class EuromillionsDrawTest {

    private CuponEuromillions sampleCoupon;

    @BeforeEach
    public void setUp()  {
        sampleCoupon = new CuponEuromillions();
        sampleCoupon.appendDip(Dip.generateRandomDip());
        sampleCoupon.appendDip(Dip.generateRandomDip());
        sampleCoupon.appendDip(new Dip(new int[]{1, 2, 3, 48, 49}, new int[]{1, 9}));
    }

    @DisplayName("reports correct matches in a coupon")
    @Test
    public void testCompareBetWithDrawToGetResults() {
        Dip winningDip, matchesFound;

        // test for full match, using the 3rd dip in the coupon as the Draw results
        winningDip = sampleCoupon.getDipByIndex(2);
        EuromillionsDraw testDraw = new EuromillionsDraw(winningDip);
        matchesFound = testDraw.findMatchesFor(sampleCoupon).get(2);

        assertEquals(winningDip, matchesFound, "expected the bet and the matches found to be equal");

        // test for no matches at all
        testDraw = new EuromillionsDraw(new Dip(new int[]{9, 10, 11, 12, 13}, new int[]{2, 3}));
        matchesFound = testDraw.findMatchesFor(sampleCoupon).get(2);
        // compare empty with the matches found
        assertEquals( new Dip(), matchesFound);
    }

    @DisplayName("Check format method")
    @Test
    public void testFormat() {
        CuponEuromillions cuponEuro = new CuponEuromillions();
        
        cuponEuro.appendDip(new Dip(new int[]{1, 2, 3, 4, 5}, new int[]{6,7}));
        cuponEuro.appendDip(new Dip(new int[]{8, 9, 10, 11, 12}, new int[]{1,9}));

        assertEquals("""
                    Dip #1:N[  1  2  3  4  5] S[  6  7]
                    Dip #2:N[  8  9 10 11 12] S[  1  9]
                    """, cuponEuro.format());
    }

}
