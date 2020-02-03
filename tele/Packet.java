package tele;

import java.util.ArrayList;

public class Packet {
    private ArrayList<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item){
       this.items.add(item);
    }
    
    public Item getItem(int index) {
    	return this.items.get(index);
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
    	byte[] bdata = data.getBytes();
    	
    }
}
