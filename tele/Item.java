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
    	
    	//�ѱ� �ѱ��ڴ� 2����Ʈ�� ���̸� ���ߵǼ� ��Ʈ������ �ٲ۵� �ٽ� ����Ʈ�� ��ȯ�� ���̸� ����
    	// �׷��� length�� ���� ������ ������ �߰��ϵ��� ��
    	while (padded.toString().getBytes().length < this.length)
    	{
    		padded.append(' ');
    	}
    	return padded.toString();
    }

	public static void main(String[] args)
	{
		// ÷�� Item class�� ������� �׽�Ʈ
//		Item item = new Item();
//		item.setName("�̸�");
//		item.setLength(10);
//		item.setValue("������");
//		item.setValue("������");
//		Item item2 = new Item();
//		item2.setValue("������2");
//		System.out.println("["+item.raw()+"]");
//		System.out.println(item.getValue());
		
		
        // Item�̶� packet Ŭ���� ������� �׽�Ʈ
//		Packet packet = new Packet();
//		
//		Item item = new Item();
//		item.setName("�̸�");
//		item.setLength(10);
//		item.setValue("������");
//		
//		Item item2 = new Item();
//		item2.setName("��ȭ��ȣ");
//		item2.setLength(11);
//		item2.setValue("01076202146");
//		
//		packet.addItem(item);
//		packet.addItem(item2);
//		
//		System.out.println(packet.raw());
		
		// ��Ŷ�� raw �޼ҵ� ������ �׽�Ʈ
//		Packet packet = new Packet();
//		
//		Item item1 = Item.create("�̸�", 10, "������");
//		Item item2 = Item.create("��ȭ��ȣ", 11, "01076202146");
//		
//		packet.addItem(item1);
//		packet.addItem(item2);
//		
//		System.out.println(packet.raw());
		
//		String test ="test";
//		byte[] btest = test.getBytes(); // �迭�� �̷��� �ϴ°� ����?
//		// test��� ��Ʈ���� ����Ʈ�� �ٲ㼭 ������ �ǹ̴� �ƴѵ�
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
	    recvPacket.addItem(Item.create("����", 8, null));
	    recvPacket.addItem(Item.create("�ּ�", 30, null));
	    recvPacket.parse("19801215����� ���ı� ��ǵ� 123-3    ");

	    System.out.println(recvPacket.getItem("�ּ�").raw());
		
	    
	    
	}
    
    
}
