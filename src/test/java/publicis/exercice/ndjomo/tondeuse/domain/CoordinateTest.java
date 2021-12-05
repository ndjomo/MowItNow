package publicis.exercice.ndjomo.tondeuse.domain;

import org.junit.jupiter.api.Test;
import publicis.exercice.ndjomo.tondeuse.exception.BuisnessException;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    /**
     * Test d'initialisation nominal
     * @throws Exception
     */
    @Test
    void initCordonnees() throws Exception {
        Coordinate coordinate = new Coordinate("1 3 N");
        assertTrue(coordinate != null);
    }

    /**
     * Erreur d'initialisation des cordonnées
     * @throws Exception
     */
    @Test
    void initErrorCordonnees() throws Exception {
        Exception exception = assertThrows(BuisnessException.class, () -> {
            new Coordinate("N");;
        });

        String expectedMessage = "Impossible d'initialiser la tondeuse";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test de toutes les déplacements en rotations de 90° gauche et droite
     * @throws Exception
     */
    @Test
    void moveRotation() throws Exception {
        Coordinate coordinate = new Coordinate("1 3 N");
        Coordinate conerCoordinate = new Coordinate("6 6");

        coordinate.move('G', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'W');

        coordinate.move('G', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'S');

        coordinate.move('G', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'E');

        coordinate.move('G', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'N');

        coordinate.move('D', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'E');

        coordinate.move('D', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'S');

        coordinate.move('D', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'W');

        coordinate.move('D', conerCoordinate);
        assertTrue(coordinate.getOrientation() == 'N');
    }

    /**
     * Test des déplacements en translation d'une case
     * @throws Exception
     */
    @Test
    void moveTraslate() throws Exception {
        Coordinate coordinate = new Coordinate("1 3 N");
        Coordinate conerCoordinate = new Coordinate("6 6");

        // Cas nominal
        coordinate.move('A', conerCoordinate);
        assertTrue(coordinate.getY() == 4);

        // Cas limite en bas
        coordinate = new Coordinate("1 0 S");
        coordinate.move('A', conerCoordinate);
        assertTrue(coordinate.getY() == 0);

        // Cas limite en haut
        coordinate = new Coordinate("1 6 N");
        coordinate.move('A', conerCoordinate);
        assertTrue(coordinate.getY() == 6);

        // Cas limite à droite
        coordinate = new Coordinate("6 3 E");
        coordinate.move('A', conerCoordinate);
        assertTrue(coordinate.getX() == 6);

        // Cas limite à droite
        coordinate = new Coordinate("0 3 W");
        coordinate.move('A', conerCoordinate);
        assertTrue(coordinate.getX() == 0);
    }

    /**
     * Test d'affichage de position
     * @throws Exception
     */
    @Test
    void testToString() throws Exception {
        Coordinate coordinate = new Coordinate("1 3 N");
        assertTrue("1 3 N".equals(coordinate.toString()));
    }
}