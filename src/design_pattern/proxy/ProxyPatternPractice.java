package design_pattern.proxy;

public class ProxyPatternPractice {

    public static void main(String[] args) {
        IBookParser iBookParser = new BookParserLazyInstanceProxy("Book-Content");
        System.out.println(iBookParser.getTotalPages());
    }
}

interface IBookParser {
    int getTotalPages();
}

class BookParser implements IBookParser {

    private  final String pageCount;

    BookParser(String pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public int getTotalPages() {
        return pageCount.length();
    }
}

class BookParserLazyInstanceProxy implements IBookParser {

    private final String bookContent;
    private BookParser bookParser = null;

    BookParserLazyInstanceProxy(String bookContent) {
        this.bookContent = bookContent;
    }

    @Override
    public int getTotalPages() {
        //defer heavy ops here
        if (bookParser ==  null) bookParser = new BookParser(bookContent);
        return bookParser.getTotalPages();
    }
}