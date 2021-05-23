package LmsLLD.models;

import LmsLLD.Enums.BookStatus;

import java.util.Date;

public class BookItem extends Book{
    private String barcode;
    private Date borrowedDate;
    private Date returnDate;
    private double price;
    private Rack rack;
    BookStatus bookStatus;
}
