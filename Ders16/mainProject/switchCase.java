package mainProject;

public class switchCase {

    public void scDays(int gun) {

        switch (gun) {
            case 6:
                System.out.println("Bugün cumartesi");
                break;

            case 7:
                System.out.println("Bugün pazar");
                break;

            case 5:
                System.out.println("Bugün cuma");
                break;

            default:
                System.out.println("Bugün hafta içi");
        }

    }

    public void ifDays(int gun) {
        if (gun == 6) {
            System.out.println("Bugün cumartesi");
        } else if (gun == 7) {
            System.out.println("Bugün pazar ");
        } else if (gun == 5) {
            System.out.println("Bugün cuma");
        } else {
            System.out.println("Bugün  hafta içi ");
        }
    }
}
