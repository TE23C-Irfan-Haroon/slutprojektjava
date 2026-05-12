package haroon.irfan;

public class Magazine extends LibraryItem {
    private String category;
    private int publishedYear;
    private int issueNumber;

    public Magazine(String id, String title, boolean isAvailable,
                String category, int publishedYear, int issueNumber) {

        super(id, title, isAvailable); 

        this.category = category;
        this.publishedYear = publishedYear;
        this.issueNumber = issueNumber;
    }

    public String getCategory() {
        return category;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}


