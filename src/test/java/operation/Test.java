package operation;

public class Test {
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 30;
	public static void main(String[] args) {
		int number = 10;
		printInfo(number);
		number = number << 1;
		System.out.println(number);
		printInfo(number);
		System.out.println(DEFAULT_INITIAL_CAPACITY);
	
	}
	
    /**
      * 输出一个int的二进制数
      * @param num
      */
     private static void printInfo(int num){
         System.out.println(Integer.toBinaryString(num));
    }
	

}
