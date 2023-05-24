import java.util.Scanner;


// Not working right


public class DAA006 {
    public record Point(int x, int y) {
        public double distance(Point point){
            return Math.sqrt(((x - point.x())*(x - point.x())) + ((y - point.y())*(y - point.y())));
        }
        public boolean inside_square(Square square){
            return x > square.left && x < square.right && y > square.down && y < square.up;
        }
        public boolean inside_circle(Circle circle){
            return (distance(circle.getCenter()) <= circle.getR());
        }
    }

    public static class Square {
        private final int up;
        private final int down;
        private final int left;
        private final int right;

        public Square(Point d_l, int length){
            this.up = d_l.y() + length;
            this.down = d_l.y();
            this.left = d_l.x();
            this.right = d_l.x() + length;
        }

        public int getUp() {
            return up;
        }

        public int getDown() {
            return down;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int get_length() {
            return Math.abs(up - down);
        }

        public Square[] divide(){
            Square[] squares = new Square[4];
            squares[0] = new Square(new Point(getLeft(), (get_length()/2) + getDown()), get_length()/2);
            squares[1] = new Square(new Point(right - (get_length()/2), up - (get_length()/2)), get_length()/2);
            squares[2] = new Square(new Point(left, down), get_length()/2);
            squares[3] = new Square(new Point(getLeft() + (get_length()/2), getDown()), get_length()/2);
            return squares;
        }

        public double area() {
            return get_length() * get_length();
        }
    }

    public static class Circle {
        private final Point center;
        private final int r;
        public Circle(int x, int y, int r){
            center = new Point(x, y);
            this.r = r;
        }

        public Point getCenter() {
            return center;
        }

        public int getR() {
            return r;
        }

        public double area() {
            return Math.PI * r * r;
        }
    }

    public static double interseccao(Square square, Circle circle) {
        // If the circle is completely outside the square, return 0
        if (!((new Point(square.getLeft(),square.getUp())).inside_circle(circle)) 
         && !(((new Point(square.getLeft(),square.getDown())).inside_circle(circle)))
         && !(((new Point(square.getRight(),square.getUp())).inside_circle(circle)))
         && !(((new Point(square.getRight(),square.getDown())).inside_circle(circle)))){
            return 0;
        }

        // If the square is completely inside the circle, return its area
        if (new Point(square.getLeft(), square.getDown()).inside_circle(circle)
                && new Point(square.getLeft(), square.getUp()).inside_circle(circle)
                && new Point(square.getRight(), square.getDown()).inside_circle(circle)
                && new Point(square.getRight(), square.getUp()).inside_circle(circle)) {
            return square.area();
        }

        // If the circle is completely inside the square, return its area
        if (new Point(circle.getCenter().x + circle.getR(), circle.getCenter().y).inside_square(square)
                && new Point(circle.getCenter().x, circle.getCenter().y + circle.getR()).inside_square(square)
                && new Point(circle.getCenter().x - circle.getR(), circle.getCenter().y).inside_square(square)
                && new Point(circle.getCenter().x, circle.getCenter().y - circle.getR()).inside_square(square)) {
            return circle.area();
        }

        // Otherwise, divide the square into 4 smaller squares and recursively compute their areas
        double area = 0;
        if (square.get_length() > 0.001) {
            area += interseccao(square.divide()[0], circle);
            area += interseccao(square.divide()[1], circle);
            area += interseccao(square.divide()[2], circle);
            area += interseccao(square.divide()[3], circle);
        }

        return area;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for (int i=0;i<n;i++){
            String[] line= in.nextLine().split(" ");
            Square square = new Square(new Point(Integer.parseInt(line[0]),Integer.parseInt(line[1])),Integer.parseInt(line[2]));
            Circle circle = new Circle(Integer.parseInt(line[3]),Integer.parseInt(line[4]),Integer.parseInt(line[5]));
            System.out.println(interseccao(square,circle));
        }

    }
}
