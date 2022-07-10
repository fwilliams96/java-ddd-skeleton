package tv.codely.mooc.courses.application.create;

import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {

    private CourseCreator courseCreator;

    public CreateCourseCommandHandler(CourseCreator courseCreator) {
        this.courseCreator = courseCreator;
    }

    @Override
    public void handle(CreateCourseCommand command) {
        CourseId id = new CourseId(command.id());
        CourseName name = new CourseName(command.name());
        CourseDuration duration = new CourseDuration(command.duration());

        courseCreator.create(id, name, duration);
    }
}