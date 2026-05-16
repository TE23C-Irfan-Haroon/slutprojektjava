package haroon.irfan;

public abstract class Media {

    private String id;
    private String type;
    private String title;
    private boolean isAvailable;

    public Media(String id, String type, String title, boolean isAvailable) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public abstract String getInfo();
}