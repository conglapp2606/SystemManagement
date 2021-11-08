package test;

public class Test {
    static {
        System.loadLibrary("hello");
    }
    public static void main(String[] args) {
        System.out.println(hello());
    }

    public static native String hello();
}
