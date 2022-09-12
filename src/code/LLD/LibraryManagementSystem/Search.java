package code.LLD.LibraryManagementSystem;

import java.util.List;

public interface Search {

    public List<BookItem> searchByAuthor(String authorName);
    public List<BookItem> searchByTitle(String title);
}
