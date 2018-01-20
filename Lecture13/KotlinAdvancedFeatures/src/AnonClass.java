

public class AnonClass {

    static class X {
        int a = 10;
    }

    static <T extends X> void  myfun  (T t) {
        System.out.println(
                t.getClass().getName()
        );
    }

    public static void main(String[] args) {

        myfun(new X() {
            int b = 10;
        });
    }
}
