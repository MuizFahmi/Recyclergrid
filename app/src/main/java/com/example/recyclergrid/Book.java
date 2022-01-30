package com.example.recyclergrid;

import java.util.Comparator;

public class Book {
    private String Title;
    private String Category;
    private String Description;
    private int Thumbnail;

    public Book(){
    }

    public Book(String title, String category, String description, int thumbnail) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }

    public static Comparator<Book> CardAlphabetComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book, Book t1) {
            return book.getTitle().compareTo(t1.getTitle());
        }
    };

    public static Comparator<Book> CardTypeComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book, Book t1) {
            return book.getCategory().compareTo(t1.getCategory());
        }
    };

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

}
