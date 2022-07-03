package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest {

    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();

        inMemoryCourseRepository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();

        Course course = new Course("some-id", "some-name", "some-duration");

        inMemoryCourseRepository.save(course);

        Assertions.assertEquals(Optional.of(course), inMemoryCourseRepository.search(course.id()));

    }

    @Test
    void not_find_a_non_existing_course() {
        InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();

        assertFalse(inMemoryCourseRepository.search("non-existing-id").isPresent());
    }

}
