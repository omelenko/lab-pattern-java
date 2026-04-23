package behavioral.iterator;

import java.util.Iterator;

public class MenuIterator implements Iterator<String>
{
    private String[] items = {"Espresso", "Latte"};
    private int position = 0;
    public boolean hasNext() { return position < items.length; }
    public String next() { return items[position++]; }
}
