package code.LLD.LibraryManagementSystem;

import java.util.Date;

public class BookItem extends Book {

    private Date dateOfPublication;
    private String ISBN;
    private String barCode;
    private Rack rackLocation;
    private BookStatus bookStatus;
    private BookFormat bookFormat;
}
