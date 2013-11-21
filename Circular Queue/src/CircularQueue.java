import java.util.Scanner;


public class CircularQueue {
	private Integer head = 0, tail = 0; 
	private Integer[] data;
	
	private Boolean availability;
	
	public CircularQueue(Integer size){
		this.data = new Integer[size];
		availability = true;
	}
	
	public synchronized Integer getLength(){
		return data.length;
	}
	
	public Integer getNextIndex(Integer currentIndex){
		currentIndex++;
		
		if(currentIndex == data.length)
			return 0;
		else
			return currentIndex;
	}
	
	public static void main(String[] args){
		System.out.println("Enter the size of the queue: ");
		Scanner rdr = new Scanner(System.in);
		Integer size = rdr.nextInt();
		
		CircularQueue cq = new CircularQueue(size);
	}
	
	public synchronized Boolean enqueue(Integer x){
		if(!availability)
			return false;
		
		data[tail] = x;
		
		tail = tail + 1;
		if(tail == data.length)
			tail = 0;
		
		if(tail == head)
			availability = false;
		else
			availability = true;
		
		return true;
	}
	
	public synchronized Integer Dequeue(){
		if(availability){
			return null;
		}
		Integer x = data[head];
		
		head = head + 1;
		if(head == data.length)
			head = 0;
		
		if(head == tail)
			availability = true;
		else
			availability = false;
		
		return x;
	}
	
	public synchronized void initialize(){
		for(Integer x : data){
			x = 0;
		}
	}
}
