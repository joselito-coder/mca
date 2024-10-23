import java.util.ArrayList;
import java.util.function.Consumer;

class InvalidTypeException extends Exception {

    public InvalidTypeException(String message) {
        super(message);
    }

}

class Rick<T> {

    T data;
    int random = 66;
    Consumer<Rick> lambda;

    Rick(T data) {

        this.data = data;

        // Set lambda based on the data types passed

        if (data instanceof Integer) {

            this.lambda = (var) -> {
                System.out.println("LOL INTEGER USER");
            };
            return;
        } else if (data instanceof String) {

            this.lambda = (var) -> {
                System.out.printf("NEVER GONNA GIVE %s UP ", this.data);
            };
            return;

        }

        this.lambda = (var) -> {
            var.printer();
        };

    }

    public Consumer<Rick> getLambda() {
        return lambda;
    }

    void giveYouUp() throws InvalidTypeException {
        if (!(data instanceof String)) {

            // System.out.printf("The Type passed is not a string");
            // System.out.println("This function can only be run on string generic types");
            throw new InvalidTypeException("this function can only be used on string generic types");

        }

        // System.out.println("The type passed is a string");
        System.out.println("never gonna give you up");
        System.out.println("never gonna let you down");
        System.out.println("never gonna turn around and desert you");

    }

    void printer() {

        System.out.println("The data you supplied is:");
        System.out.println(this.data);
    }

    void tryDividingByZero() throws ArithmeticException {

        try {
            int asdf = 42 / 0;
            System.out.println(asdf);

        } catch (ArithmeticException e) {

            throw new ArithmeticException("DIVING BY ZERO doesn't work");

        }

 
    }

    void tryDividingByZero(int num) throws ArithmeticException {

        try {
            int asdf = num / 0;
            System.out.println(asdf);

        } catch (ArithmeticException e) {

            throw new ArithmeticException("DIVING BY ZERO doesn't work");

        }

    }

}

class Gen {
    public static void main(String[] args) {

        try {

            Rick<String> astley = new Rick<String>("asdf");
            Rick<Float> rick = new Rick<Float>(66.42f);
            Rick<Integer> roll = new Rick<Integer>(3);

            ArrayList<Rick> arrayList = new ArrayList<>();

            arrayList.add(rick);
            arrayList.add(astley);
            arrayList.add(roll);

            arrayList.forEach(e -> {
                System.out.println();
                System.out.println("Running lambda for: " + e.data.toString());
                arrayList.forEach(e.getLambda());
                System.out.println();
            });


            rick.tryDividingByZero();
            astley.giveYouUp();
            roll.giveYouUp();

        } catch (Exception e) {

            // System.out.println(e);
            System.out.println();
            System.out.println("handling exception");
            e.printStackTrace();
            System.out.println();

        }

        System.out.println("ending program");

    }
}