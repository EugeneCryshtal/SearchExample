package ugncry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ugncry.entity.User;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ugncry on 11.07.2016.
 */
public class SearchTest extends SearchExampleApplicationTests {

    @Autowired
    private UserSearchService userSearchService;

    @Test
    public void searchByStringTest() {
        List<User> searchResultByName = userSearchService.search("Lena");
        assertEquals(searchResultByName.size(), 1);

        List<User> searchResultByDescription = userSearchService.search("FANCY");
        assertEquals(searchResultByDescription.size(), 2);
    }

    @Test
    public void searchByEnumTest() {
        List<User> searchResultBySkill = userSearchService.search("MID");
        assertEquals(searchResultBySkill.size(), 2);
    }

    @Test
    public void searchBySetTest() {
        List<User> searchResultByStudies = userSearchService.search("imagination");
        assertEquals(searchResultByStudies.size(), 1);
    }

    @Test
    public void searchByListTest() {
        List<User> searchResultByNumber = userSearchService.search("111000333");
        assertEquals(searchResultByNumber.size(), 1);
    }

}
