package com.hol9.resourceserver.model;

public class Resource {
    private Long id;
    private String name;
    private String description;
    private String owner;

    public Resource() {}
    public Resource(Long id, String name, String description, String owner) {
        this.id = id; this.name = name; this.description = description; this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
}
