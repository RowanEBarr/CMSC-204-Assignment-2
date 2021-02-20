import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface {
	private static int end;
	private static int capacity;
	private Object queue[];
	
	public NotationQueue(int size) {
		end = 0;
		capacity = size;
		queue = new Object[capacity];
	}
	
	public NotationQueue(){
		end = 0;
		capacity = 50;
		queue = new Object[capacity];
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
	public Object dequeue() throws QueueUnderflowException {
		if (end == 0)
		{
			throw new QueueUnderflowException("The queue is empty!");
		}
		Object item = queue[0];
		for (int i = 0; i < end; i++)
		{
			queue[i]=queue[i+1];
		}
		queue[end]=null;
		end--;
		return item;
	}

	@Override
	public int size() {
		int size = end;
		return size;
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (end == capacity)
		{
			throw new QueueOverflowException("The queue is full!");
		}
		else 
		{
			queue[end] = e;
			end++;
			return true;
		}
	}

	@Override
	public String toString(String delimiter) {
		String qContents = "";
		qContents += queue[0];
		for (int i = 1;i<end;i++)
		{
			qContents= qContents + delimiter + queue[i];
		}
		return qContents;
	}
	
	@Override
	public String toString() {
		String qContents = "";
		for (int i = 0;i<end;i++)
		{
			qContents += queue[i];
		}
		return qContents;
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
			queue[i] = listCopy.get(i);
			end++;
		}
		
	}

}
