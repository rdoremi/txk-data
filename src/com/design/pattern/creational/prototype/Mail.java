package com.design.pattern.creational.prototype;

public class Mail implements Cloneable {
    private String name;
    private String emailAddress;
    private String content;
    public Mail(){
        System.out.println("Main constu....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("克隆");
        return super.clone();
    }
}
