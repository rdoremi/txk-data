package com.design.pattern.creational.abstractfactory;

public class TestAbsfMain {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();;
        article.produce();
    }
}
