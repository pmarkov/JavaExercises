package com.Markov;

public abstract class ListItem {

    private String element;
    private ListItem next;
    private ListItem previous;

    public ListItem(String element) {
        this.element = element;
        this.next = null;
    }

    public ListItem moveToNext() {
        return next;
    }

    public ListItem moveToPrevious() {
        return previous;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }

    public void setPrevious(ListItem previous) {
        this.previous = previous;
    }

    public int compareTo(String newElement) {
        return element.compareTo(newElement);
    }

    public Object getElement() {
        return element;
    }

}
