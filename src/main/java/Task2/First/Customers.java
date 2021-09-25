package Task2.First;

class Customers{
	private String name;
	private int p_number;
	private String address;
	private int acc_num;
	private String Account_Type1;
	private String Account_Type2;
	
	public Customers() {		//Default Constructor
		name="\0";
		p_number=0;
		acc_num=0;
		address="\0";
		Account_Type1 = "\0";
		Account_Type2 = "\0";
	}
	
	public Customers(String Name,int P_Number,String Address,int Acc_Num) {		//Parametrized Constructor
		if(Name==null) {
			throw new IllegalArgumentException("Username can not be blank");
		}
		
		else if(Name.length()<3) {
			throw new IllegalArgumentException("Username is too short");
		}
		
		else if(Name.length()>30) {
			throw new IllegalArgumentException("Username is too long");
		}
		
		if(Address == null)
		throw new IllegalArgumentException("Address can not be Empty");
		
		
		
		Account_Type1 = "\0";
		Account_Type2 = "\0";
		name=Name;
		p_number=P_Number;
		address=Address;
		acc_num=Acc_Num;
	}
	
	//Getters
	
	public String getName() {		
		return name;
	}
	
	public int getPNumber() {
		return p_number;
	}
	
	public int getAccNum() {
		return acc_num;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getAccount_Type1() {
		return Account_Type1;
	}
	
	public String getAccount_Type2() {
		return Account_Type2;
	}
	
	//Setters
	public void setName(String Name) {
		if(Name==null) {
			throw new IllegalArgumentException("Username can not be blank");
		}
		
		else if(Name.length()<3) {
			throw new IllegalArgumentException("Username is too short");
		}
		
		else if(Name.length()>30) {
			throw new IllegalArgumentException("Username is too long");
		}
		name=Name;
		
	}
	
	public void setAccount_Type1(String s) {
		Account_Type1 = s;
	}
	
	public void setAccount_Type2(String s) {
		Account_Type2 = s;
	}
	
	public void setAddress(String s) {
		if(s == null) {
			throw new IllegalArgumentException("Address can not be Empty");
		}
		
		else if(s!=null)
		address = s;
	}
}
