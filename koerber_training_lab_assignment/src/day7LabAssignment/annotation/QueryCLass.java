package day7LabAssignment.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;


public class QueryCLass {

    public void readAnnotation(AnnotatedElement element) {

        Annotation[] annotations = element.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author author) {
                System.out.println("Author Name: " + author.name());
            }
            if (annotation instanceof Version version) {
                System.out.println("Version Number: " + version.number());
            }
        }


    }
    public static void main(String[] args) {
        QueryCLass q = new QueryCLass();
        q.readAnnotation(AnnotatedClass.class);
    }
}
