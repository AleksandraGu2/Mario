package physics2dtmp;

import org.joml.Vector2f;
import org.junit.Test;
import physics2dtmp.primitives.Box2D;
import physics2dtmp.primitives.Circle;
import physics2dtmp.rigidbody.IntersectionDetector2D;
import physics2dtmp.rigidbody.Rigidbody2D;
import renderer.Line2D;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CollisionDetectorTests {
    private final float EPSILON = 0.000001f;

    // ============================================================================================
    // Line Intersection tests
    // ============================================================================================
    @Test
    public void pointOnLine2DShouldReturnTrueTest() {
        Line2D line = new Line2D(new Vector2f(0, 0), new Vector2f(12, 4));
        Vector2f point = new Vector2f(0, 0);

        assertTrue(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLine2DShouldReturnTrueTestTwo() {
        Line2D line = new Line2D(new Vector2f(0, 0), new Vector2f(12, 4));
        Vector2f point = new Vector2f(12, 4);

        assertTrue(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnVerticalLineShouldReturnTrue() {
        Line2D line = new Line2D(new Vector2f(0, 0), new Vector2f(0, 10));
        Vector2f point = new Vector2f(0, 5);

        boolean result = IntersectionDetector2D.pointOnLine(point, line);
        assertTrue(result);
    }

    @Test
    public void pointOnLineShouldReturnTrueTestOne() {
        Line2D line = new Line2D(new Vector2f(0, 0), new Vector2f(12, 4));
        Vector2f point = new Vector2f(0, 0);

        assertTrue(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLineShouldReturnTrueTestTwo() {
        Line2D line = new Line2D(new Vector2f(0, 0), new Vector2f(12, 4));
        Vector2f point = new Vector2f(6, 2);

        assertTrue(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLineShouldReturnFalseTestOne() {
        Line2D line = new Line2D(new Vector2f(0, 0), new Vector2f(12, 4));
        Vector2f point = new Vector2f(4, 2);

        assertFalse(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLineShouldReturnTrueTestThree() {
        Line2D line = new Line2D(new Vector2f(10, 10), new Vector2f(22, 14));
        Vector2f point = new Vector2f(10, 10);

        assertTrue(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLineShouldReturnTrueTestFour() {
        Line2D line = new Line2D(new Vector2f(10, 10), new Vector2f(22, 14));
        Vector2f point = new Vector2f(16, 12);

        assertTrue(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLineShouldReturnFalseTestTwo() {
        Line2D line = new Line2D(new Vector2f(10, 10), new Vector2f(22, 14));
        Vector2f point = new Vector2f(14, 12);

        assertFalse(IntersectionDetector2D.pointOnLine(point, line));
    }

    @Test
    public void pointInCircleShouldReturnTrueTestOne() {
        Circle circle = new Circle();
        circle.setRadius(5f);
        Rigidbody2D body = new Rigidbody2D();
        circle.setRigidbody(body);

        Vector2f point = new Vector2f(3, -2);

        boolean result = IntersectionDetector2D.pointInCircle(point, circle);
        assertTrue(result);
    }

    @Test
    public void pointInCircleShouldReturnTrueTestTwo() {
        Circle circle = new Circle();
        circle.setRadius(5f);
        Rigidbody2D body = new Rigidbody2D();
        circle.setRigidbody(body);

        Vector2f point = new Vector2f(-4.9f, 0);

        boolean result = IntersectionDetector2D.pointInCircle(point, circle);
        assertTrue(result);
    }

    @Test
    public void pointInCircleShouldReturnFalseTestOne() {
        Circle circle = new Circle();
        circle.setRadius(5f);
        Rigidbody2D body = new Rigidbody2D();
        circle.setRigidbody(body);

        Vector2f point = new Vector2f(-6, -6);

        boolean result = IntersectionDetector2D.pointInCircle(point, circle);
        assertFalse(result);
    }

    @Test
    public void pointInCircleShouldReturnTrueTestFour() {
        Circle circle = new Circle();
        circle.setRadius(5f);
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10));
        circle.setRigidbody(body);

        Vector2f point = new Vector2f(3 + 10, -2 + 10);

        boolean result = IntersectionDetector2D.pointInCircle(point, circle);
        assertTrue(result);
    }

    @Test
    public void pointInCircleShouldReturnTrueTestFive() {
        Circle circle = new Circle();
        circle.setRadius(5f);
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10));
        circle.setRigidbody(body);

        Vector2f point = new Vector2f(-4.9f + 10, 0 + 10);

        boolean result = IntersectionDetector2D.pointInCircle(point, circle);
        assertTrue(result);
    }

    @Test
    public void pointInCircleShouldReturnFalseTestTwo() {
        Circle circle = new Circle();
        circle.setRadius(5f);
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10));
        circle.setRigidbody(body);

        Vector2f point = new Vector2f(-6 + 10, -6 + 10);

        boolean result = IntersectionDetector2D.pointInCircle(point, circle);
        assertFalse(result);
    }

    @Test
    public void pointInBox2DShouldReturnTrueTestOne() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        box.setRigidbody(body);

        Vector2f point = new Vector2f(4, 4.3f);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInBox2DShouldReturnTrueTestTwo() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-4.9f, -4.9f);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInBox2DShouldReturnFalseTestOne() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        box.setRigidbody(body);

        Vector2f point = new Vector2f(0, 5.1f);

        assertFalse(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInBox2DShouldReturnTrueTestThree() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10));
        box.setRigidbody(body);

        Vector2f point = new Vector2f(4 + 10, 4.3f + 10);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInBox2DShouldReturnTrueTestFour() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10));
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-4.9f + 10, -4.9f + 10);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInBox2DShouldReturnFalseTestTwo() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10));
        box.setRigidbody(body);

        Vector2f point = new Vector2f(0 + 10, 5.1f + 10);

        assertFalse(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInRotatedBox2DShouldReturnTrueTestOne() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(0), 45);
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-1, -1);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInRotatedShouldReturnTrueTestTwo() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(0), 45);
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-3.43553390593f, 3.43553390593f);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInRotatedShouldReturnFalseTestOne() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10), 45);
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-3.63553390593f, 3.63553390593f);

        assertFalse(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInRotatedBox2DShouldReturnTrueTestThree() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10), 45);
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-1 + 10, -1 + 10);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInRotatedShouldReturnTrueTestFour() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10), 45);
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-3.43553390593f + 10, 3.43553390593f + 10);

        assertTrue(IntersectionDetector2D.pointInBox2D(point, box));
    }

    @Test
    public void pointInRotatedShouldReturnFalseTestTwo() {
        Box2D box = new Box2D();
        box.setSize(new Vector2f(10));
        Rigidbody2D body = new Rigidbody2D();
        body.setTransform(new Vector2f(10), 45);
        box.setRigidbody(body);

        Vector2f point = new Vector2f(-3.63553390593f + 10, 3.63553390593f + 10);

        assertFalse(IntersectionDetector2D.pointInBox2D(point, box));
    }
}