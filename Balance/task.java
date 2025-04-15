    // Static nested class Book
    public static class Book {
        // Attributes of the Book class
        private String title;
        private String author;
        private String isbn;

        // Constructor to initialize the Book attributes
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        // Method to display book details
        public void displayDetails() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    // Main method to test the Book class
    public static void main(String[] args) {
        // Creating an instance of the Book class
        Book myBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        
        // Calling the displayDetails method to show book information
        myBook.displayDetails();
    }
 
    

