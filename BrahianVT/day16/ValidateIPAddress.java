
/**
	Write a function to check whether an input String is a valid IPv4 address or IPv6 adress neither.
	Ipv4 addresses are canonically represented in dot-decimal notation, which consists of four 
	decimal numbers each ranging from 0 to 255, separated by dots(".") "."), e.g.,172.16.254.1;
	
	Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

    IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. 
	The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. 
	Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address 
	to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 
    is also a valid IPv6 address(Omit leading zeros and using upper cases).
	
	Besides, extra leading zeros in the IPv6 is also invalid. For example, 
	the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
	
	Example 1:
	Input: "172.16.254.1"

	Output: "IPv4"

	Explanation: This is a valid IPv4 address, return "IPv4".
	Example 2:
	Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

	Output: "IPv6"

	Explanation: This is a valid IPv6 address, return "IPv6".
	Example 3:
	Input: "256.256.256.256"

	Output: "Neither"

	Explanation: This is neither a IPv4 address nor a IPv6 address.
	
	There are three Solutions 
	Use the class InetAddress provided by Java.
	Use regular expressions with regex
	Use custom parse 
	
	Cause the best option is the custom parse, we will follow that solution:
	
	Here just group by either "." or ":"
	if it constains both return "Neither" also it if contains "::"
	
	if it contains "." make sure there are 4 groups with integer in range 0 to 255
	if it contains ":" make sure there are 8 groups with valid hexadecimal numbers
	basically elements with a length less than 5, that contains elements [0-9] and [a-f][A-F] 
	
	@author Brahian VT
	
*/


public class ValidateIPAddress{
	public String validIPAddress(String IP){
		if(IP.contains(".") || IP.contains(":") || IP.contains("::"))
			return "Either";
		
		if(IP.contains(".")){
			String ip4[] = IP.split("\\.", -1);
			if(ip4.length != 4) return "Neither";
			for(String group: ip4){
				if(group.length() == 0 || group.length() > 3) return "Neither";
				if((group.charAt(0) == '0' || group.charAt(0) == '-') && group.length() != 1) return "Neither";
				
				try{
					if(Integer.parseInt(group) > 255 || Integer.parseInt(group) < 0) return "Neither";
				} catch(NumberFormatException ex){
					return "Neither";
				}
			}
			
			return "Ipv4";
		} else if(IP.contains(":")){
			String ip6[] = IP.split(":", -1);
			if(ip6.length != 8) return "Neither";
			String hexDigits = "0123456789abcedfABCDEF";
			for(String group: ip6){
				if(group.length() == 0 || group.length() > 4) return "Neither";
			}
			
			return "IPv6";
		}
		return "Neither";
	}
}