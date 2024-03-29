package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.DictionaryDaoImp;
import edu.javacourse.studentorder.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws  Exception {
        List<Street> d = new DictionaryDaoImp().findStreet("d");
        for(Street s : d){
            System.out.println(s.getStreetName());
        }

          //        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }
    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder: ");
        return answer;
    }
    public static StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("����� ����");

        Street street = new Street(1L, "First street");

        Address address = new Address("195000", street, "12", "", "142");

        //���
        Adult husband = new Adult("������", "������", "���������", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("����� ������� %" + id);
        husband.setStudentId(""+ (100000 + id));
        husband.setAddress(address);
        //����
        Adult wife = new Adult("�������", "��������", "����������", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        wife.setIssueDepartment("����� ������� %" + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        //������
        Child child1 = new Child("�������", "�����", "����������", LocalDate.of(2018,6,29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        child1.setIssueDepartment("����� ���� %" + id);
        child1.setAddress(address);
        //������
        Child child2 = new Child("������", "�������", "����������", LocalDate.of(2018,6,29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        child2.setIssueDepartment("����� ���� %" + id);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}
