package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.Before;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.joda.time.DateTime.now;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {
    List<String> books;
    PrintStream printStream;


    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
    }
    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    /*@Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);

        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }*/

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, null);

        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        books.add("Book One");
        books.add("Book Two");

        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream).println("Book One");
        verify(printStream).println("Book Two");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        //Mock DateTime
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        //Actual DateTime
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormat.shortTime();
        String timeString = dateTimeFormatter2.print(now());

        when(dateTimeFormatter.print(time)).thenReturn(timeString);

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is " + timeString);
    }
}