package com.gxcttdvnapi.api.models;
import javax.persistence.*;

@Entity
@Table(name = "Class")

public class Class {
    private Integer classID;
    private String className;
    private String classDescription;
    private Integer teacherID;
    private Integer teacherAssistantID;

    public Class() {}

    public Class(String classname, String classdescription, Integer teacherid,
                 Integer teacherassistantid)
    {
        this.className = classname;
        this.classDescription = classdescription;
        this.teacherID = teacherid;
        this.teacherAssistantID = teacherassistantid;
    }

    @Id
    @Column(name = "classID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //getter
    public Integer getClassID() {
        return classID;
    }
    //setter
    public void setClassID(Integer classid) { classID = classid; }

    @Column(name = "className", nullable = false)
    public String getClassName() {
        return className;
    }
    public void setClassName(String classname) { className = classname; }

    @Column(name = "classDescription", nullable = false)
    public String getClassDescription() {
        return classDescription;
    }
    public void setClassDescription(String classdescription) { classDescription = classdescription; }

    @Column(name = "teacherID")
    public Integer getTeacherID() { return teacherID; }
    public void setTeacherID(Integer teacherid) { teacherID = teacherid; }

    @Column(name = "teacherAssistantID")
    public Integer getTeacherAssistantID() { return teacherAssistantID; }
    public void setTeacherAssistantID(Integer teacherAssistantID) { this.teacherAssistantID = teacherAssistantID; }
}
