
class exp_8Library {
    // Static Nested Class
    static class Book {
        String title;
        String author;
        String ISBN;

        Book(String title, String author, String ISBN) {
            this.title = title;
            this.author = author;
            this.ISBN = ISBN;
        }

    
        void displayDetails() {
            System.out.println("Book Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + ISBN);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        book.displayDetails();
    }
}
