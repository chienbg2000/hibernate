package gui;

import InPut.InPut;
import dao.ClassDao;
import dao.StudentDao;
import entity.ClasssEntity;
import entity.StudentEntity;

import java.util.List;

public class Main {
    private static void disPlayStudent(){
        List<StudentEntity> list = dao.StudentDao.getAllStudent();
        for (StudentEntity st: list
             ) {
            System.out.println(st);
        }
    }

    private static void insertStudent(){
        System.out.println("Nhập mã sv:");
        String id = InPut.nextLine();
        System.out.println("Nhập tên sv:");
        String name = InPut.nextLine();
        System.out.println("Nhập giới tính:");
        boolean gender = InPut.nextBool();
        System.out.println("Mã lớp:");
        String classID = InPut.nextLine();
        ClasssEntity cl = ClassDao.getClass(classID);

        StudentEntity studentEntity = new StudentEntity(id,name,gender,cl);

        StudentDao.insertStudent(studentEntity);

    }

    public static void main(String[] args) {
        disPlayStudent();

    }
}
