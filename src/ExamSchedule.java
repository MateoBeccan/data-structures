public class ExamSchedule {
    private ExamNode head;
    private ExamNode current;

    public ExamSchedule() {
        this.head = null;
        this.current = null;
    }

    // Agregar examen al final de la lista
    public void addExam(String examDetails) {
        ExamNode newExam = new ExamNode(examDetails);
        if (head == null) {
            head = newExam;
            current = head;
        } else {
            ExamNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newExam;
            current = newExam;
        }
        System.out.println("Exam added: " + examDetails);
    }

    // Ver siguiente examen
    public void viewNextExam() {
        if (current == null) {
            System.out.println("No exams available.");
        } else if (current.next == null) {
            System.out.println("You are already at the last exam.");
            System.out.println("This is the last exam: " + current.examDetails);
        } else {
            current = current.next;
            System.out.println("Next exam: " + current.examDetails);
        }
    }

    // Ver examen anterior
    public void viewPreviousExam() {
        if (current == null) {
            System.out.println("No exams available.");
            return;
        }
        if (current == head) {
            System.out.println("You are already at the first exam.");
            System.out.println("Exam: " + current.examDetails);
            return;
        }
        // Recorrer desde head hasta encontrar el nodo anterior a current
        ExamNode temp = head;
        while (temp.next != current) {
            temp = temp.next;
        }
        current = temp;
        System.out.println("Previous exam: " + current.examDetails);
    }

    // Ver todos los exámenes
    public void viewAllExamSchedule() {
        if (head == null) {
            System.out.println("No exams scheduled.");
            return;
        }
        System.out.println(" Exam Schedule:");
        ExamNode temp = head;
        int count = 1;
        while (temp != null) {
            System.out.println(count + ". " + temp.examDetails);
            temp = temp.next;
            count++;
        }
    }
}
