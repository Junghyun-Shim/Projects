package tele;

import java.util.ArrayList;
import java.util.HashMap;

public class Packet {
    private ArrayList<Item> items = new ArrayList<Item>();
    private HashMap<String, Item> nameAccess = new HashMap<String, Item>();
    
    
	public void addItem(Item item) {
		this.items.add(item);
		
		if (nameAccess.containsKey(item.getName())) {
			throw new RuntimeException(
					"Duplicated item name:["+item.getName()+"]");   	
		}
		nameAccess.put(item.getName(), item);
	}
    
    public Item getItem(String name) {
    	return this.nameAccess.get(name);
    }
    
    public String raw()
    {
    	StringBuffer result = new StringBuffer();
    	for (Item item: items)
    	{
    		result.append(item.raw());
    	}
    	return result.toString();
    }
    
    public void parse(String data)
    {
    	byte[] bdata = data.getBytes(); //¿Ã∞≈ πª±Ó?
    	int pos = 0;
    	
    	for (Item item: items)
    	{
    		byte[] temp = new byte[item.getLength()];
    		System.arraycopy(bdata, pos, temp, 0, item.getLength());
    		pos += item.getLength();
    		item.setValue(new String(temp));
    	}
    	

    	
    }
}
