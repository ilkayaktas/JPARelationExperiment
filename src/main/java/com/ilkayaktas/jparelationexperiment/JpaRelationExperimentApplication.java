package com.ilkayaktas.jparelationexperiment;

import com.ilkayaktas.jparelationexperiment.manytoone.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class JpaRelationExperimentApplication {
    private Logger logger = LoggerFactory.getLogger(JpaRelationExperimentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaRelationExperimentApplication.class, args);
    }

    @Bean
    public CommandLineRunner groupRepository(GroupTestRepository groupTestRepository,
                                             UserTestRepository userTestRepository,
                                             GroupMemberTestRepository groupMemberTestRepository){
        return (args) -> {
            Group group = new Group();
            group.setName("İlkay");
            group = groupTestRepository.save(group);

            User user = new User();
            user.setName("Ahmet");
            user = userTestRepository.save(user);

            GroupMember groupMember = new GroupMember();
//            groupMember.setGroupId(group.getId());
//            groupMember.setUserId(user.getId());
            groupMember.setUser(user);
            groupMember.setGroup(group);
            groupMember.setTime(System.currentTimeMillis());
            groupMember = groupMemberTestRepository.save(groupMember);

            Optional<GroupMember> member = groupMemberTestRepository.findById(groupMember.getId());
            if (member.isPresent()){
                logger.info("Grup adı "+member.get().getGroup().getName() + "\n" +
                        "Kişi adı "+member.get().getUser().getName() + "\n" +
                        "Zaman "+member.get().getTime());
            }

        };
    }

    public CommandLineRunner studentRepositoryRunner(StudentRepository repository) {
        return (args) -> {
            Student student = new Student();
            student.setName("Ahmet");
            student.setId(1L);

            Tuition tuition = new Tuition();
            tuition.setId(1L);
            tuition.setFee(200d);
            tuition.setStudent(student);

            student.setTuition(tuition);

            student = repository.save(student);

            Optional<Student> groupEntityModel = repository.findById(student.getId());
            if (groupEntityModel.isPresent()){
                logger.info(groupEntityModel.get().getName());
            } else{
                logger.error("Öğrenci bulunamadı.");
            }


            University university = new University();
            university.setName("Üniversite");

            Student student1 = new Student();
            student1.setName("AAAA");

            Student student2 = new Student();
            student2.setName("BBBBB");

            university.setStudents(List.of(student1, student2));
        };
    }

    public CommandLineRunner universityRepositoryRunner(UniversityRepository repository,
                                                        StudentRepository studentRepository,
                                                        StaffRepository staffRepository) {
        return (args) -> {

            University university = new University();
            university.setName("Universidad de Las Palmas de Gran Canaria");

            Student student1 = new Student();
            student1.setName("AAAA");
            student1.setUniversity(university);

            Student student2 = new Student();
            student2.setName("BBBBB");
            student2.setUniversity(university);

            Staff staff1 = new Staff();
            staff1.setName("CCCC");

            Staff staff2 = new Staff();
            staff2.setName("CCCC");

            university.setStudents(List.of(student1, student2));
            university.setStaff(List.of(staff1, staff2));

            logger.info("Save student!");
            repository.save(university);

            logger.info("Find student!");
            List<Student> studentList = studentRepository.findByName("AAAA");
            System.out.println(studentList.get(0).getUniversity());
        };
    }

    public CommandLineRunner courseRepositoryRunner(StudentRepository studentRepository) {
        return (args) -> {
            Course course = new Course();
            course.setName("Ada");

            Student student1 = new Student();
            student1.setName("Ayşe");
            student1.setCourses(Set.of(course));

            studentRepository.save(student1);

        };
    }
}
