import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CheckerTest {

    private String white = "white";
    private String red = "red";

    @Test
    public void allAreWhiteTest() {
        // when guess 1234
        // given code 1234
        // then all white
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 3, 4});

        int[] givenGuess = new int[]{1, 2, 3, 4};

        String[] expectedResult = new String[]{white, white, white, white};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

        // lambda expression
//        boolean allAreWhite = Arrays.stream(checkerResult).allMatch(color -> "white".equalsIgnoreCase(color));
//        System.out.println("allAreWhite " + allAreWhite);

    }

    @Test
    public void allAreRedTest() {
        // given code 1234
        // when guess 4321
        // then all red
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 3, 4});

        int[] givenGuess = new int[]{4, 3, 2, 1};

        String[] expectedResult = new String[]{red, red, red, red};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

    }

    @Test
    public void noneExistTest() {
        // given code 2233
        // when guess 1144
        // then all nothing
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{2, 2, 3, 3});

        int[] givenGuess = new int[]{1, 1, 4, 4};

        String[] expectedResult = new String[]{null, null, null, null};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

    }

    @Test
    public void repeatedExistTest() {
        // given code 1212
        // when guess 2112
        // then red red white white
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 1, 2});

        int[] givenGuess = new int[]{2, 1, 1, 2};

        String[] expectedResult = new String[]{red, red, white, white};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);
    }

    @Test
    public void oneDoesNotExistTest() {
        // given code 1123
        // when guess 2134
        // then red white red null
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 1, 2, 3});

        int[] givenGuess = new int[]{2, 1, 3, 4};

        String[] expectedResult = new String[]{red, white, red, null};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);
    }


    @Test
    public void myTest() {
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 4, 2});

        int[] givenGuess = new int[]{1, 2, 4, 3};

        String[] expectedResult = new String[]{white, white, white, null};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

    }


//    @Test
//    public void repeatedExistTest2() {
//        Checker gameTest = new Checker();
//        gameTest.setNumbers(new int[]{1, 2, 3, 4});
//
//        int[] givenGuess = new int[]{1, 1, 3, 4};
//
//        String[] expectedResult = new String[]{white, null, white, white};   //Will fail at the moment! Because of
//                                                                              the design, the 2nd one will be red
//        String[] checkerResult = gameTest.numberChecker(givenGuess);
//        assertArrayEquals(expectedResult, checkerResult);
//
//    }

}
