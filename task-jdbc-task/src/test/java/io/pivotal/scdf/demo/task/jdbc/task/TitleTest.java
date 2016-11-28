package io.pivotal.scdf.demo.task.jdbc.task;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import io.pivotal.scdf.demo.task.common.model.Title;
import io.pivotal.scdf.demo.task.jdbc.task.common.GemfireDozerItemWriter;
import io.pivotal.scdf.demo.task.jdbc.task.config.CacheConfig;
import io.pivotal.scdf.demo.task.jdbc.task.config.DozerConfig;
import io.pivotal.scdf.demo.task.jdbc.task.config.RegionConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhansen on 11/4/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CacheConfig.class, RegionConfig.class, DozerConfig.class, GemfireDozerItemWriter.class, GemfireDozerItemWriterTestUtil.class})
@SuppressWarnings("serial")
@ActiveProfiles(profiles = {"titles"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TitleTest {

    @Autowired
    GemfireDozerItemWriterTestUtil util;

    @Autowired
    ClientCache cache;

    @Test
    @Profile("titles")
    public void testTitle() {
        String regionName = "Title";
        Region region = cache.getRegion(regionName);
        Object k = util.testItemWriter(regionName);
        Title value = (Title) region.get(k);
        Map<String,Object> testValue = util.createTitlesMap();
        assertEquals(testValue.get("titleId"), value.getTitleId());
        region.remove(k);
    }
}
