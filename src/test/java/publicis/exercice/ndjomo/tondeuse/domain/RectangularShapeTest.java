package publicis.exercice.ndjomo.tondeuse.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularShapeTest {

    RectangularShape rectangularShape = new RectangularShape();

    @BeforeEach
    public void initTest() throws Exception {
        rectangularShape.init("1 2 N");
        rectangularShape.limit("5 5");
    }

    /**
     * Test d'initialisation du terrain
     */
    @Test
    void initForm() {
        assertTrue("1 2 N".equals(rectangularShape.getCurrentCoodinat().toString()));
    }

    @Test
    void move() throws Exception {
        rectangularShape.move('G', rectangularShape.getCornerCoodinate());
        assertTrue(rectangularShape.getCurrentCoodinat().getOrientation() == 'W');
    }

    @Test
    void limit() {
        assertTrue("5 5".equals(rectangularShape.getCornerCoodinate().toString()));
    }

    /**
     * Test d'égalité entre 2 position: Test de collision
     * @throws Exception
     */
    @Test
    void isEquals() throws Exception {
        Coordinate c1 = new Coordinate("2 3 W");
        Coordinate c2 = new Coordinate("2 3 W");

        assertTrue(rectangularShape.isEquals(c1, c2));

        c2 = new Coordinate("2 4 E");
        assertFalse(rectangularShape.isEquals(c1, c2));
    }

    @Test
    void walk() throws Exception {
        rectangularShape.walk("GAGAGAGAA");
        assertTrue("1 3 N".equals(rectangularShape.getCurrentCoodinat().toString()));
    }
}