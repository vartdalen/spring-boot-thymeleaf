package no.oslomet.model;

import java.util.ArrayList;

public class BookForm {
    private ArrayList<Book> bookList;

    public BookForm(){
    }

    public BookForm(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() { return bookList; }
    public void setBookList(ArrayList<Book> bookList) { this.bookList = bookList; }
}
