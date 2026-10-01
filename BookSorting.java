import java.util.*;
class Book implements Comparable<Book> {
    int bookId;
    String title;
    int pages;
    Book(int id, String t, int p) {
        this.bookId = id;
        this.title = t;
        this.pages = p;
    }
    @Override
    public int compareTo(Book o) {
        return this.bookId - o.bookId;
    }
    @Override
    public String toString() {
        return bookId + " " + title + " " + pages;
    }
}
class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {

        if (o1.pages != o2.pages)
            return o1.pages - o2.pages;

        return o1.title.compareTo(o2.title);
    }
}

class TitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo(o2.title);
    }
}

public class BookSorting {

    public static void main(String[] args) {

        ArrayList<Book> b = new ArrayList<>();

        b.add(new Book(101, "Java Basics", 150));
        b.add(new Book(104, "Data Structures", 150));
        b.add(new Book(103, "Computer Networks", 250));
        b.add(new Book(102, "Operating Systems", 400));

        b.sort(null);
        System.out.println(b);

        b.sort(new BookComparator());
        System.out.println(b);

        b.sort(new TitleComparator());
        System.out.println(b);
    }
}
