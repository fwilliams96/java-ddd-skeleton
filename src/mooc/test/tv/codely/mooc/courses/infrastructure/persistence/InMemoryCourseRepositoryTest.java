package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CoursesModuleInfrastructureTestCase;
import tv.codely.mooc.courses.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest extends CoursesModuleInfrastructureTestCase {

    @Test
    void save_a_valid_course() {
        repository.save(CourseMother.random());
    }

    @Test
    void search_an_existing_course() {
        Course course = CourseMother.random();

        repository.save(course);

        Assertions.assertEquals(Optional.of(course), repository.search(course.id()));

    }

    @Test
    void not_find_a_non_existing_course() {
        assertFalse(repository.search(CourseIdMother.random()).isPresent());
    }

}
