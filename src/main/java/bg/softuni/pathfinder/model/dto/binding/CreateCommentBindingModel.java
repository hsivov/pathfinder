package bg.softuni.pathfinder.model.dto.binding;

public class CreateCommentBindingModel {
    private long routeId;
    private String textContent;

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
