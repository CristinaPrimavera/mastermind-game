import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CheckerTest {

    private String blanco = "blanco";
    private String rojo = "rojo";

    @Test
    public void todosBlancoTest() {
        // when guess 1234
        // given code 1234
        // then all blanco

        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 3, 4});

        int[] givenGuess = new int[]{1, 2, 3, 4};

        String[] expectedResult = new String[]{blanco, blanco, blanco, blanco};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

        // lambda expression
//        boolean todosSonBlancos = Arrays.stream(checkerResult).allMatch(color -> "blanco".equalsIgnoreCase(color));
//        System.out.println("todosSonBlancos " + todosSonBlancos);

    }

    @Test
    public void todosRojosTest() {
        // given code 1234
        // when guess 4321
        // then all red
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 3, 4});

        int[] givenGuess = new int[]{4, 3, 2, 1};

        String[] expectedResult = new String[]{rojo, rojo, rojo, rojo};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

    }

    @Test
    public void nigunoExisteTest() {
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
    public void repetidosExisteTest() {
        // given code 1212
        // when guess 2112
        // then red red white white
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 1, 2});

        int[] givenGuess = new int[]{2, 1, 1, 2};

        String[] expectedResult = new String[]{rojo, rojo, blanco, blanco};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);
    }

    @Test
    public void unoNoExisteTest() {
        // given code 1123
        // when guess 2134
        // then red white red null
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 1, 2, 3});

        int[] givenGuess = new int[]{2, 1, 3, 4};

        String[] expectedResult = new String[]{rojo, blanco, rojo, null};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);
    }


    @Test
    public void tuTest() {
        Checker gameTest = new Checker();
        gameTest.setNumbers(new int[]{1, 2, 4, 2});

        int[] givenGuess = new int[]{1, 2, 4, 3};

        String[] expectedResult = new String[]{blanco, blanco, blanco, null};
        String[] checkerResult = gameTest.numberChecker(givenGuess);
        assertArrayEquals(expectedResult, checkerResult);

    }


//    @Test
//    public void repetidosExiste2() {
//        Checker gameTest = new Checker();
//        gameTest.setNumbers(new int[]{1, 2, 3, 4});
//
//        int[] givenGuess = new int[]{1, 1, 3, 4};
//
//        String[] expectedResult = new String[]{blanco, null, blanco, blanco};   //Por el diseno, ese segundo 1 va a dar rojo
//        String[] checkerResult = gameTest.numberChecker(givenGuess);
//        assertArrayEquals(expectedResult, checkerResult);
//
//    }

}
