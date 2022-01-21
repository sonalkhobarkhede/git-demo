
public class Main {

	public static void main(String[] args) {

		LinkList l1 = new LinkList();
		l1.insert(10);
		l1.append(300);
		l1.insert(20);
		l1.insert(30);
		l1.append(100);
		System.out.println(l1);
		l1.insertByPos(1000, 0);
		System.out.println(l1);
		
		l1.reverse();
		System.out.println(l1);
		
	/*	l1.insert(40);
		l1.append(200);
		System.out.println(l1);
		
		l1.deleteFirst();
		l1.deleteLast();
		
		System.out.println(l1);*/
	}
}
