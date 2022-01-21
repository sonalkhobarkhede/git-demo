
public class LinkList {

	Node head;

	public LinkList() {
		head = null;
	}

	public void insert(int value) {    ///  O(1)

		//Step #1.. Create new Node...
		Node tmp = new Node(value);

		//Check for 1st node..
		if(head == null)  //C1
		{
			head = tmp;  
		}
		//I have at-least 1 node.. 
		else  //C2
		{
			if(head.getNext() == null)
			{
				//Only one node in LL
				tmp.setNext(head);
				head = tmp;
			}
			else
			{
				//More than 1 node in LL
				tmp.setNext(head);
				head = tmp;
			}			
		}
	}

	public void append(int value) {   ///  C2 * (n-1)  ==>  n-1 ==> O(n)
		
		Node tmp = new Node(value);

		//Check for 1st node..
		if(head == null)   //C1
		{
			head = tmp;
		}
		else
		{                             //C2 * n-1
			Node it = head;

			while( it.getNext() != null )
			{
				it = it.getNext();
			}

			//ok 'it' is not pointing to last node..
			it.setNext(tmp);
		}
	}

	public void insertByPos(int value, int pos)	{    // O(2n) ==> O(n)
		
		int numOfNodes = getNumOfNodes();  // n
				
		if(pos == 1)    // 1
		{
			insert(value);
		}
		else if(pos == (numOfNodes + 1) )   // n
		{
			append(value);
		}
		else if(pos > 1  && pos < (numOfNodes + 1) )  // n-pos
		{
			Node tmp = new Node(value);
			
			//ok, we have to insert node in middle
			Node it = head;
			for(int i = 1; i < (pos-1) ; i++)
			{
				it = it.getNext();
			}
			
			//'it' reach the targeted node..
			tmp.setNext( it.getNext() );
			it.setNext(tmp);			
		}
		else   // 1
		{
			System.out.println("Invalid Pos value..");
		}
	}

	private int getNumOfNodes() {
		
		int nodeCount = 0;
		Node it = head;
		while(it != null)
		{
			nodeCount++;
			it = it.getNext();
		}
		return nodeCount;
	}

	public void deleteFirst() { // O(1)
		//check for empty
		if(head == null)  // C1
		{
			System.out.println("LL is empty!");
		}
		else
		{   //C2
			//LL has some nodes
			//Ok check if LL has only 1 node
			if(head.getNext() == null)
			{
				//we need to make head=null after deleting node...
				Node tmp = head;
				head = null;				
			}
			else
			{
				Node tmp = head;
				head = tmp.getNext();
				tmp.setNext(null);
			}
		}
	}

	public void deleteLast(){  // O(n-2) ==> O(n)
		
		//check for empty
		if(head == null)  //C1
		{
			System.out.println("LL is empty!");
		}
		else    // n-2
		{
			//we have some nodes
			//Ok check if LL has only 1 node
			if(head.getNext() == null)
			{
				//we need to make head=null after deleting node...
				Node tmp = head;
				head = null;				
			}
			else
			{
				Node it = head;

				// 'it' should stop at last but one node...
				while(it.getNext().getNext() != null)
				{
					it = it.getNext();
				}
				Node tmp = it.getNext();
				it.setNext(null);
			}
		}
	}

	public void deleteByPos(int pos)
	{}
	
	public void reverse(){   // O(n)
		
		Node itp = null;
		Node it = head;
		Node itn = head;
		
		while(it != null)
		{
			itn = itn.getNext();
			it.setNext(itp);
			itp = it;
			it = itn;			
		}
		head = itp;
	}

	public String toString() {
		String str = "";

		Node it = head;

		//System.out.println("LL::toString START");
		while(it != null)
		{
			//str += "" + it.getData() + "-->";
			str += "" + it;
			it = it.getNext();
		}
		//System.out.println("LL::toString END");
		return str;
	}

}
