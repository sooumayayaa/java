
public class Strings {

@SuppressWarnings("unused")
public static void main(String[] args) {

    char c[]=  { 'J', 'A', 'V', 'A' };
    String str1 = new String(c);
    char[] d =  { 'J', 'A', 'V', 'A' };
    String str2  = new String(d);
    String str3 = "JAVA";
    @SuppressWarnings("RedundantStringConstructorCall")
    String str4 = new String("JAVA");
    byte ascii[] = { 74, 65, 86, 65 };
    String str5 = new String(ascii); 
    System.out.println("str1 : " + str1);
    System.out.println("str2 : " + str2);
    System.out.println("str3 : " + str3);
    System.out.println("str4 : " + str4);
    System.out.println("str5 : " + str5);

    String str = "Hello, World!";
 System.out.println("Length: " + str.length()); // Length of the string
 System.out.println("Character at index 7: " + str.charAt(7)); // Character at index 7
 System.out.println("Substring (7 to 12): " + str.substring(7, 12)); // Substring from index 7 to 12
 System.out.println("Uppercase: " + str.toUpperCase()); // Convert to uppercase
 System.out.println("Replaced String: " + str.replace("World", "Java")); 
    
 }
}