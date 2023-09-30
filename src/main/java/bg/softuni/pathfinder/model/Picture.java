package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    private String title;
    @Column(columnDefinition = "TEXT")
    private String url;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

//•	title - Accepts String values
//•	url - Accepts very long String values
//•	author - Accepts User Entities as values
//•	route - Accepts Route Entities as values
