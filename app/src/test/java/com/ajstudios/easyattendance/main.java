class Main {
  public static void main(String[] args) {

    // create long variable
    long value1 = 52336L;
    long value2 = -445636L;

    // change long to int
    int num1 = Math.toIntExact(value1);
    int num2 = Math.toIntExact(value2);

    // print the int value
    System.out.println(num1);  // 3215
    System.out.println(num2);  // -445636
  }
}