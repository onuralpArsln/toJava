
public class interfaceImplement {

    public static void main(String[] args) {

        BetterStudent student = new BetterStudent();
        BetterGrad grad = new BetterGrad();
        grad.startWorking();

        Honors myHonor = new Honors();
        Honors myHonorGrad = new Honors();

        myHonor.student = student;
        myHonorGrad.student = grad;

        student.getToSchool();
        student.getToSchool("alp");
        student.getToSchool(4);

        ((BetterGrad) myHonorGrad.student).startWorking();

        myHonor.student.getBetterGrade();
        myHonorGrad.student.getBetterGrade();

    }

    static void startStudy(Study obje) {
        obje.getBetterGrade();
    }

    static void examPrep(BaseStudent obje) {
        obje.studyForExam();
    }

}

abstract class BaseStudent {
    int schooldId;

    abstract void studyForExam();

    void getToSchool() {
        System.out.println("vardım");
    }

    void getToSchool(String name) {
        System.out.println("vardım " + name);
    }

    void getToSchool(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("vardım");
        }
    }
}

interface Study {
    public void getBetterGrade();

}

class LazyStudent extends BaseStudent {
    @Override
    void studyForExam() {
        System.out.println("scrolled insta");
    }
}

class BetterStudent extends BaseStudent implements Study {

    @Override
    public void getBetterGrade() {
        int x = 10;
    }

    @Override
    void studyForExam() {
        System.out.println("solved 100000 question");
    }

}

class BetterGrad implements Study {
    public void getBetterGrade() {
        System.out.println("bettergrade");
    }

    public void startWorking() {
        System.out.println("work");
    }
}

class Honors {

    public Study student;
}