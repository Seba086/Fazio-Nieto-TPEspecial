package TPE;

public class MySimpleLinkedList {
	protected User first;
	private User last;
	private int size = 0;

	

	// ELIMINA UN NODO POR POSICION, Y VINCULA EL ANTERIOR CON EL SIGUIENTE
	public void deleteElement(int pos) {
		if (size - 1 > pos && first == null) {
			System.out.println("La lista esta vacia"); // if list is empty
		} else if (pos == 0) { // Si borro el primero de la lista, el segundo se vuelve el primero
			first = first.getNext();
			size--;
		} else {
			if (size > pos || first == null) {
				User nodo = at(pos - 1);
				if (nodo != null) {
					nodo.setNext(nodo.getNext().getNext());
					size--;
				}
			} else
				System.out.println("La posicion solicitada no contiene nodo.");
		}

	}

	// Return size list
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public void addElementByPos(int i, int pos) {
		User n = new User();
		if (pos == 0) {
			if (first == null) {
				first = n;
				last = first;
			} else {
				n.setNext(first);
				first = n;
			}

		} else {
			User nodo = this.at(pos - 1);
			if (nodo != null) {
				n.setNext(nodo.getNext());
				nodo.setNext(n);
			}
		}

		size++;
	}

	// return node by position
	public User at(int pos) {
		User nodo = null;
		if (size < pos - 1 || first == null) {
			System.out.println("La posicion solicitada no contiene nodo.");
		} else {
			nodo = first;
			for (int i = 0; i < pos; i++) {
				nodo = nodo.getNext();
			}
		}
		return nodo;
	}

	//return bool if list is empty
	public boolean isEmpty() {
		return first == null;
	}
}
