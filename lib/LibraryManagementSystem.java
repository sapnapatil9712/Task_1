class Library {
    private int booksAvailable;

    public Library(int books) {
        this.booksAvailable = books;
    }

    public synchronized void borrowBook(String studentName) {
        while (booksAvailable == 0) {
            System.out.println(studentName + " is waiting for a book...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        booksAvailable--;
        System.out.println(studentName + " borrowed a book. Books left: " + booksAvailable);
    }

    public synchronized void returnBook(String studentName) {
        booksAvailable++;
        System.out.println(studentName + " returned a book. Books available: " + booksAvailable);
        notify();
    }
}

class Student extends Thread {
    private final Library library;
    private final String studentName;

    public Student(Library library, String studentName) {
        this.library = library;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        library.borrowBook(studentName);
        try {
            Thread.sleep(2000); // Simulate reading time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        library.returnBook(studentName);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(2); // Library with 2 books

        Student s1 = new Student(library, "Student1");
        Student s2 = new Student(library, "Student2");
        Student s3 = new Student(library, "Student3");

        s1.start();
        s2.start();
        s3.start();
    }
}
