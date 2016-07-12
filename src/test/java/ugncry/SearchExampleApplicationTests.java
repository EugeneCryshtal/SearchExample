package ugncry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ugncry.entity.PhoneNumber;
import ugncry.entity.Skill;
import ugncry.entity.Study;
import ugncry.entity.User;
import ugncry.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SearchExampleApplication.class)
@WebAppConfiguration
public class SearchExampleApplicationTests {

  @Autowired
  private UserRepository userRepository;

  public void createTestData() {
    User user = new User();
    user.setName("George");
    user.setDescription("Smart, 40 y.o., fancy");
    user.setSkill(Skill.SENIOR);

    User user2 = new User();
    user2.setName("Mike");
    user2.setDescription("Funny, 15 y.o., hard-working");
    user2.setSkill(Skill.MID);

    User user3 = new User();
    user3.setName("Lena");
    user3.setDescription("Unique, 23 y.o., fancy");
    user3.setSkill(Skill.MID);


    List<PhoneNumber> numberList = new ArrayList<>();
    numberList.add(new PhoneNumber(111222333));
    user.setNumbers(numberList);

    Set<Study> studySet = new HashSet<>();
    studySet.add(new Study("Imagination"));
    user.setStudies(studySet);

    userRepository.save(user);


    numberList = new ArrayList<>();
    numberList.add(new PhoneNumber(111000333));
    user2.setNumbers(numberList);

    studySet = new HashSet<>();
    studySet.add(new Study("Work hard!"));
    user2.setStudies(studySet);

    userRepository.save(user2);


    numberList = new ArrayList<>();
    numberList.add(new PhoneNumber(999555999));
    user3.setNumbers(numberList);

    studySet = new HashSet<>();
    studySet.add(new Study("Bunch of angry people"));
    user3.setStudies(studySet);

    userRepository.save(user3);

  }

  @Test
  public void contextLoads() {
  }

}
