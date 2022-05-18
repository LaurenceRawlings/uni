import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Link head;
    private Link tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public Link getLinkAt(int index) throws NoSuchElementException {
        Link currentLink = head;
        for (int i = 0; i < index; i++) {
            currentLink = currentLink.getNext();

            if (currentLink == null) {
                throw new NoSuchElementException();
            }
        }
        return currentLink;
    }

    public T elementAt(int index) throws NoSuchElementException {
        return (T) getLinkAt(index).getElement();
    }

    public void insertAt(int index, T e) throws NoSuchElementException {
        Link newItem = new Link(e, null);

        if (isEmpty()) {
            if (index == 0) {
                head = newItem;
                tail = newItem;
            } else {
                throw new NoSuchElementException();
            }

        } else if (index == 0) {
            newItem.setNext(head);
            head = newItem;
        } else {
            Link currentItem = getLinkAt(index - 1);

            newItem.setNext(currentItem.getNext());
            currentItem.setNext(newItem);

            if (currentItem == tail) {
                tail = newItem;
            }
        }
    }

    @Override
    public String toString() {
        Link currentItem = head;
        String s = "";

        while (currentItem.getNext() != null) {
            s += currentItem.getElement() + ", ";
            currentItem = currentItem.getNext();
        }

        return s += currentItem.getElement();
    }


    //Challenge
    public void removeAt(int index) throws NoSuchElementException {
        if (index == 0) {
            head = head.getNext();
        } else {
            Link currentItem = getLinkAt(index - 1);

            if (currentItem.getNext() == null) {
                throw new NoSuchElementException();
            }

            Link remove = currentItem.getNext();
            currentItem.setNext(remove.getNext());
        }
    }
}
