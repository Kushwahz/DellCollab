package com.dell.zealthinkers.dellcollab;

public class DropRequest {
    public String person;
    public String contact;
    public String route;

    public DropRequest(String person, String contact, String route) {
        this.person = person;
        this.contact = contact;
        this.route = route;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
