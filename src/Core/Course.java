/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Mohammad_Ali
 */
public class Course {
private String courseName;
private int courseDuration;

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseDuration
     */
    public int getCourseDuration() {
        return courseDuration;
    }

    /**
     * @param courseDuration the courseDuration to set
     */
    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
}
