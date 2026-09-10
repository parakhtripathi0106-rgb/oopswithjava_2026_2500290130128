public class Usecase1{
public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "J. Author", 350.0, "ISBN001");
        Book b2 = new Book("OOP Concepts", "K. Writer", 420.0, "ISBN002");
 
        System.out.println(b1.getTitle() + " by " + b1.getAuthor());
        System.out.println("Price: " + b2.getPrice());
        System.out.println("Library: " + Book.libraryName);
        System.out.println("Total books added: " + Book.bookCount);
    }
}
class Book{
    private String title;
    private String author;
    private double price;
    private String isbn;
    final static String libraryname = "Sunrise";
    static int bookCount = 0;
    Book (String t, String A, double p, String i){
        this.title = t;
        this.author=A;
        this.price=p;
        this.isbn=i;
        ++bookCount;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String t){
        this.title=t;
    }
public String getAuthor(){
    return author;
}
public void setAuthor(String a){
    this.author=a;
}
public double getPrice(){
    return price;
}
public void setPrice(double p){
    this.price = p;
}
public String getisbn(){
    return isbn;
}
public void setisbn(String i){
    this.isbn=i;
}
    }


