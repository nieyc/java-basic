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

		//右移2位，高位补0，10100 右移动2位变为00101 ,之前十进制是20，现在变成5
		System.out.println(number>>>2);
	
	}
	
    /**
      * 输出一个int的二进制数
      * @param num
      */
     private static void printInfo(int num){
         System.out.println(Integer.toBinaryString(num));
    }
	

}
