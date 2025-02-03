package day8LabAssignment;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.sort;


public class CopyOfDemoBookCaseStudyProblem {

	public static void main(String[] args) {

		List<Book> allBooks = loadAllBooks();

		// 1. Find books with more then 400 pages
		allBooks.stream()
				.filter(b-> b.getPages()>400)
				.forEach(System.out::println);
		// 2. Find all books that are java books and more then 400 pages
		allBooks.stream()
				.filter(b-> b.getPages() > 400)
				.filter(b->b.getSubject() == Subject.JAVA)
				.forEach(System.out::println);
		// 3. We need the top three longest books
		allBooks.stream()
				.sorted(Comparator.comparingInt(Book::getPages).reversed())
				.limit(3)
				.forEach(System.out::println);
		// 4. We need from the fourth to the last longest books
		allBooks.stream()
				.sorted(Comparator.comparingInt(Book::getPages).reversed())
				.limit(4)
				.forEach(System.out::println);
		// 5. We need to get all the publishing years
		allBooks.stream()
				.map(Book :: getYear)
				.distinct()
				.forEach(System.out::println);
		// 6. We need all the authors names who have written a book		
		allBooks.stream()
				.map(Book :: getAuthors)
				.flatMap(List :: stream)
				.map(Author ::getName)
				.distinct()
				.forEach(System.out::println);
		// 7. We need all the origin countries of the authors
		allBooks.stream()
				.map(Book :: getAuthors)
				.flatMap(List :: stream)
				.map(Author :: getCountry)
				.distinct()
				.forEach(System.out::println);
		// 8. We want the most recent published book.
		allBooks.stream()
				.sorted(Comparator.comparingInt(Book::getYear).reversed())
				.limit(1)
				.forEach(System.out::println);
		// 9. We want to know if all the books are written by more than one author
		System.out.println(allBooks.stream()
				.map(Book :: getAuthors)
				.noneMatch(authors -> authors.size() == 1));
		// 10. We want one of the books written by more than one author. (findAny)
		System.out.println(allBooks.stream()
				.map(Book :: getAuthors)
				.filter(authors -> authors.size() != 1)
				.findAny());
		// 11. We want the total number of pages published.
		System.out.println(allBooks.stream()
				.map(Book :: getPages)
				.reduce(0,(a,b) -> a+b));
		// 12. We want to know how many pages the longest book has.
		allBooks.stream()
				.sorted(Comparator.comparingInt(Book::getPages).reversed())
				.limit(1)
				.forEach(book ->  System.out.println(book.getPages()));
		// 13. We want the average number of pages of the books
		System.out.println(allBooks.stream()
				.map(Book::getPages)
				.reduce(0, Integer::sum)
				.doubleValue() / allBooks.size());
		// 14. We want all the titles of the books
		allBooks.stream()
				.map(Book :: getTitle)
				.distinct()
				.forEach(System.out::println);
		// 15. We want the book with the higher number of authors?
		System.out.println(allBooks.stream()
				.max(Comparator.comparingInt(book -> book.getAuthors().size())));
		// 16. We want a Map of book per year.
		Map<Integer, List<Book>> booksByYear = allBooks.stream()
				.collect(Collectors.groupingBy(Book::getYear));

		// 17. We want to count how many books are published per year.
		allBooks.stream()
				.collect(Collectors.groupingBy(Book::getYear))
				.forEach((year, books) ->
						System.out.println("Year: " + year + ", Count: " + books.size()));
	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
				new Author("ekta", "gupta", "in"));

		List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

		List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
				new Author("keshav", "gupta", "us"));

		books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
		books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
		books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));

		return books;
	}

}
