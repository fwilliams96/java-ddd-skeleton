package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest {

    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();

        inMemoryCourseRepository.save(new Course(new CourseId("decf33ca-81a7-419f-a07a-74f214e928e5"), new CourseName("some-name"), new CourseDuration("some-duration")));
    }

    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();

        Course course = new Course(new CourseId("decf33ca-81a7-419f-a07a-74f214e928e5"), new CourseName("some-name"), new CourseDuration("some-duration"));

        inMemoryCourseRepository.save(course);

        Assertions.assertEquals(Optional.of(course), inMemoryCourseRepository.search(course.id()));

    }

    @Test
    void not_find_a_non_existing_course() {
        InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();

        assertFalse(inMemoryCourseRepository.search(new CourseId("decf33ca-81a7-419f-a07a-74f214e928e5")).isPresent());
    }

}
