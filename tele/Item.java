package tele;

public class Item 
{
	private String name;
	private int length;
	private String value;

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
    public String getName()
    {
    	return name;
    }
    
    public int getLength()
    {
    	return length;
    }
    
    public String getValue()
    {
    	return value;
    }
    
    // factory method
    public static Item create(String name, int length, String value)
    {
    	Item item = new Item();
		item.setName(name);
		item.setLength(length);
		item.setValue(value);
		
		return item;
    }
    
	
    public String raw()
    {
    	StringBuffer padded = new StringBuffer(this.value);
    	
    	//한글 한글자당 2바이트로 길이를 세야되서 스트링으로 바꾼뒤 다시 바이트로 변환후 길이를 쟀음
    	// 그래서 length에 넣은 값까지 공백을 추가하도록 함
    	while (padded.toString().getBytes().length < this.length)
    	{
    		padded.append(' ');
    	}
    	return padded.toString();
    }

	public static void main(String[] args)
	{
		// 첨에 Item class만 만들고나서 테스트
//		Item item = new Item();
//		item.setName("이름");
//		item.setLength(10);
//		item.setValue("심정현");
//		item.setValue("김혜원");
//		Item item2 = new Item();
//		item2.setValue("김혜원2");
//		System.out.println("["+item.raw()+"]");
//		System.out.println(item.getValue());
		
		
        // Item이랑 packet 클래스 만들고나서 테스트
//		Packet packet = new Packet();
//		
//		Item item = new Item();
//		item.setName("이름");
//		item.setLength(10);
//		item.setValue("심정현");
//		
//		Item item2 = new Item();
//		item2.setName("전화번호");
//		item2.setLength(11);
//		item2.setValue("01076202146");
//		
//		packet.addItem(item);
//		packet.addItem(item2);
//		
//		System.out.println(packet.raw());
		
		// 패킷에 raw 메소드 수정후 테스트
//		Packet packet = new Packet();
//		
//		Item item1 = Item.create("이름", 10, "심정현");
//		Item item2 = Item.create("전화번호", 11, "01076202146");
//		
//		packet.addItem(item1);
//		packet.addItem(item2);
//		
//		System.out.println(packet.raw());
		
//		String test ="test";
//		byte[] btest = test.getBytes(); // 배열에 이렇게 하는건 뭘까?
//		// test라는 스트링을 바이트로 바꿔서 넣으란 의미는 아닌듯
//		//System.out.println(btest[0].length);
//		System.out.println(test.getBytes().length);
//		
//		
//		String test2 ="test";
//		String[] btest2 = new String[2];
//		btest2[0] = test2;
//		System.out.println(btest2[0].length());
//		
	    Packet recvPacket = new Packet();
	    recvPacket.addItem(Item.create("생일", 8, null));
	    recvPacket.addItem(Item.create("주소", 30, null));
	    recvPacket.parse("19801215서울시 송파구 잠실동 123-3    ");

	    System.out.println(recvPacket.getItem("주소").raw());
		
	    
	    
	}
    
    
}
