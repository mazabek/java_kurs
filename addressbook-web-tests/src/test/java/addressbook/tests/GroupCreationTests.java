package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

    }

}
