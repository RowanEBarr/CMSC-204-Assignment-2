import java.util.ArrayList;

public class NotationStack<T> implements StackInterface{
	private static int end;
	private static int capacity;
	private Object stack[];
	
	public NotationStack(int size) {
		end = 0;
		capacity = size;
		stack = new Object[capacity];
	}
	
	public NotationStack(){
		end = 0;
		capacity = 50;
		stack = new Object[capacity];
	}
	@Override
	public boolean isEmpty() {
		if (end == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (end == capacity)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Object pop() throws StackUnderflowException {
		if (end == 0)
		{
			throw new StackUnderflowException("The stack is empty!");
		}
		Object item = stack[end-1];
		stack[end-1]=null;
		end--;
		return item;
	}

	@Override
	public Object top() throws StackUnderflowException {
		if (end == 0)
		{
			throw new StackUnderflowException("The stack is empty!");
		}
		Object item = stack[end-1];
		return item;
	}

	@Override
	public int size() {
		int size = end;
		return size;
	}

	@Override
	public boolean push(Object e) throws StackOverflowException {
		if (end == capacity)
		{
			throw new StackOverflowException("The stack is full!");
		}
		stack[end] = e;
		end++;
		return true;
		
	}

	@Override
	public String toString() {
		String sContents = "";
		for (int i = 0;i<end;i++)
		{
			sContents += stack[i];
		}
		return sContents;
	}
	
	@Override
	public String toString(String delimiter) {
		String sContents = "";
		sContents += stack[0];
		for (int i = 1;i<end;i++)
		{
			sContents= sContents + delimiter + stack[i];
		}
		return sContents;
	}

	@Override
	public void fill(ArrayList list) {
		ArrayList listCopy = new ArrayList();
		for (int i = 0; i < list.size();i++)
		{
			listCopy.add(i,list.get(i));
		}
		for (int i = 0; i < listCopy.size();i++)
		{
			stack[i] = listCopy.get(i);
			end++;
		}
	}



}
